package com.qhcs.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qhcs.ssm.entity.Auth;
import com.qhcs.ssm.entity.Role;

/**
 * 
 * TODO:权限处理接口，实现增删改查
 * 
 * @version 2017年9月26日下午5:17:09
 * @author 星哥
 */
public interface AuthMapper {
	/**
	 * 
	 * TODO:查询权限集合
	 * 
	 * @version 2017年9月25日下午8:07:13
	 * @author 星哥
	 * @return
	 */
	public List<Auth> getList();

	/**
	 * 
	 * TODO:动态查询权限列表
	 * 
	 * @version 2017年9月25日下午8:17:34
	 * @author 星哥
	 * @param auth
	 * @return
	 */
	public List<Auth> queryAuths(@Param("auth") Auth auth, @Param("order") String order);

	/**
	 * 
	 * TODO:根据id查询相应的权限
	 * 
	 * @version 2017年9月25日下午8:29:49
	 * @author 星哥
	 * @param id
	 * @return
	 */
	public Auth queryAuthById(Integer authId);

	/**
	 * 
	 * TODO:根据权限id删除权限
	 * 
	 * @version 2017年9月25日下午8:21:51
	 * @author 星哥
	 * @param id
	 * @return
	 */
	public boolean delAuthById(Integer authId);

	/**
	 * 
	 * TODO:根据权限id删除相应角色权限表中的记录
	 * 
	 * @version 2017年9月25日下午8:25:39
	 * @author 星哥
	 * @param id
	 * @return
	 */
	public boolean delRoleByAuthId(Integer authId);

	/**
	 * 
	 * TODO:批量删除权限
	 * 
	 * @version 2017年9月26日上午10:56:58
	 * @author 星哥
	 * @param ids
	 *            权限id集合
	 * @return 返回成功的数量
	 */
	public Integer batchDelAuths(@Param("list") List<Integer> ids);

	/**
	 * 
	 * TODO:批量删除角色权限关联表中的记录
	 * 
	 * @version 2017年9月26日上午11:00:24
	 * @author 星哥
	 * @param ids
	 * @return 返回成功的数量
	 */
	public Integer batchDelRolesAndAuths(List<Integer> ids);

	/**
	 * 
	 * TODO:新增一个权限
	 * 
	 * @version 2017年9月26日上午9:28:35
	 * @author 星哥
	 * @param auth
	 * @return 添加成功返回true
	 */
	public boolean addAuth(Auth auth);

	/**
	 * 
	 * TODO:修改权限信息
	 * 
	 * @version 2017年9月26日上午9:45:36
	 * @author 星哥
	 * @param auth
	 * @return 修改成功返回true
	 */
	public boolean updateAuth(Auth auth);

	/**
	 * 根据用户id来查询权限
	 * 
	 * @param id
	 *            用户id
	 * @return 返回权限列表
	 */
	public List<Auth> getListByUserId(Integer authId);

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
	public List<Auth> getListByRoleList(@Param("lists") List<Role> roles);

}
