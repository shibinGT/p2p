package com.qhcs.ssm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qhcs.ssm.dao.AuthMapper;
import com.qhcs.ssm.entity.Auth;
import com.qhcs.ssm.entity.Role;

/**
 * 
 * TODO:权限业务处理类
 * 
 * @version 2017年9月26日下午5:18:01
 * @author 星哥
 */
@Service
public class AuthService {
	@Autowired
	private AuthMapper authMapper;

	/**
	 * 
	 * TODO:动态获取权限列表
	 * 
	 * @version 2017年9月25日下午8:01:02
	 * @author 星哥
	 * @return 返回一个权限集合列表
	 */
	public PageInfo<Auth> queryAuths(Auth auth, String order) {

		PageHelper.startPage(auth.getPageNum(), auth.getPageSize());

		List<Auth> auths = authMapper.queryAuths(auth, order);
		// 封装，把list封装成 PageInfo
		PageInfo<Auth> page = new PageInfo<>(auths);
		return page;
	}

	/**
	 * 
	 * TODO:根据id查询相应的权限
	 * 
	 * @version 2017年9月25日下午8:29:49
	 * @author 星哥
	 * @param id
	 * @return
	 */
	public Auth queryAuthById(Integer id) {
		return authMapper.queryAuthById(id);
	}

	/**
	 * 
	 * TODO:根据权限id删除权限及相应角色
	 * 
	 * @version 2017年9月25日下午8:27:36
	 * @author 星哥
	 * @param id
	 * @return
	 */
	public boolean delAuthById(Integer id) {
		boolean result = authMapper.delAuthById(id);
		authMapper.delRoleByAuthId(id);
		return result;
	}

	public Integer batchDelAuths(List<Integer> ids) {
		Integer successCount = authMapper.batchDelAuths(ids);
		authMapper.batchDelRolesAndAuths(ids);
		return successCount;
	}

	/**
	 * 
	 * TODO:新增一个权限
	 * 
	 * @version 2017年9月26日上午9:28:35
	 * @author 星哥
	 * @param auth
	 * @return 添加成功返回true
	 */
	public boolean addAuth(Auth auth) {
		return authMapper.addAuth(auth);
	}

	/**
	 * 
	 * TODO:修改权限信息
	 * 
	 * @version 2017年9月26日上午9:45:36
	 * @author 星哥
	 * @param auth
	 * @return 修改成功返回true
	 */
	public boolean updateAuth(Auth auth) {
		return authMapper.updateAuth(auth);
	}

	/**
	 * 根据用户id来查询权限
	 * 
	 * @param id
	 *            用户id
	 * @return 返回权限列表
	 */
	public List<Auth> getListByUserId(Integer id) {
		return authMapper.getListByUserId(id);
	}

	/**
	 * 
	 * 根据角色列表查询权限列表
	 * 
	 * @version 2017年10月20日下午6:43:17
	 * @author xuweiping
	 * @param roles
	 *            角色列表
	 * @return 返回权限列表
	 */
	public List<Auth> getListByRoleList(@Param("lists") List<Role> roles) {
		return authMapper.getListByRoleList(roles);
	}

}
