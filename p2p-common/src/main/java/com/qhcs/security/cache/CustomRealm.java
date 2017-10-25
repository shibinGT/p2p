package com.qhcs.security.cache;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.qhcs.ssm.entity.Auth;
import com.qhcs.ssm.entity.Employee;
import com.qhcs.ssm.entity.Role;
import com.qhcs.ssm.service.AuthService;
import com.qhcs.ssm.service.EmployeeService;
import com.qhcs.ssm.service.RoleService;

public class CustomRealm extends AuthorizingRealm implements Realm, InitializingBean {

	@Autowired
	private RoleService roleService;
	@Autowired
	private AuthService authService;
	@Autowired
	private EmployeeService userService;

	@Autowired
	private RedisCache<String, Object> redisCache;

	private Logger logger = Logger.getLogger(this.getClass());

	public CustomRealm() {
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// logger.info("授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		String username = (String) super.getAvailablePrincipal(principals);
		Employee user = userService.queryUserByName(username);
		List<Role> roles = roleService.getListByUserId(user.getEmployeeId());
		roles.addAll(roleService.getListByUserIdFromGroup(user.getEmployeeId()));
		StringBuilder sb = new StringBuilder();
		for (Role role : roles) {
			info.addRole(role.getRoleCode());
			sb.append(role.getRoleId());
			sb.append(",");
		}
		// List<Auth> perms = authService.getListByUserId(user.getEmployeeId());
		List<Auth> perms = authService.getListByRoleList(roles);
		for (Auth auth : perms) {
			info.addStringPermission(auth.getAuthCode());
		}
		redisCache.put(Constants.getUserModuleCacheKey(user.getEmployeeAccountNumber()), perms);
		// cacheManager.getCache("").clear();
		redisCache.put(Constants.getUserRolesCacheKey(username), roles);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		SimpleAuthenticationInfo info = null;

		UsernamePasswordToken upt = (UsernamePasswordToken) token;
		Employee user = userService.queryUserByName(upt.getUsername());
		if (user == null) {
			throw new AuthenticationException("用户名不存在！");
		}

		redisCache.put(Constants.getUserSessionKey(user.getEmployeeAccountNumber()), user);
		info = new SimpleAuthenticationInfo(user.getEmployeeAccountNumber(), user.getEmployeePassword(), getName());
		return info;
	}

	/**
	 * 更新用户授权信息缓存.
	 */
	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
		super.clearCachedAuthorizationInfo(principals);
		super.clearCache(principals);
		super.clearCachedAuthenticationInfo(principals);
		redisCache.remove(Constants.getUserModuleCacheKey(principal));
		redisCache.remove(Constants.getUserRolesCacheKey(principal));
	}

	/**
	 * 清除所有用户授权信息缓存.
	 */
	public void clearAllCachedAuthorizationInfo() {
		redisCache.clear();
		/*
		 * Cache<Object, AuthenticationInfo> cache = getAuthenticationCache();
		 * if (null != cache) { for (Object key : cache.keys()) {
		 * cache.remove(key); } }
		 */
	}

	@Override
	public void afterPropertiesSet() throws Exception {
	}

}