package com.qhcs.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qhcs.ssm.entity.Role;

public interface RoleMapper {

	/**
	 * 
	 * 根据ID删除
	 * 
	 * @version 2017年9月25日下午8:48:07
	 * @author lizongcai
	 * @param id
	 *            角色ID
	 * @return 成功返回true，失败返回false
	 */
	public boolean delete(Integer id);

	/**
	 * 批量删除
	 * 
	 * @param ids
	 *            用户id的集合
	 * @return int 返回删除成功的数量
	 */
	public boolean batchDelRole(@Param("lists") Integer[] lists);

	/**
	 * 
	 * 添加角色
	 * 
	 * @version 2017年9月25日下午8:48:07
	 * @author lizongcai
	 * @param role
	 *            角色
	 * @return 成功返回true，失败返回false
	 */
	public boolean insert(Role role);

	/**
	 * 添加角色权限关联表
	 * 
	 * @param rid
	 *            角色id
	 * @param aid
	 *            权限id
	 * @return
	 */
	public boolean addRoleAuth(@Param("roleId") Integer rid, @Param("authId") Integer aid);

	/**
	 * 
	 * 更新角色基本信息
	 * 
	 * @version 2017年9月25日下午8:48:07
	 * @author lizongcai
	 * @param role
	 *            角色
	 * @return 成功返回true，失败返回false
	 */
	boolean update(Role role);

	/**
	 * 
	 * 根据ID查询角色信息
	 * 
	 * @version 2017年9月25日下午8:52:36
	 * @author lizongcai
	 * @param id
	 *            角色ID
	 * @return 成功返回true，失败返回false
	 */
	public Role selectById(Integer id);

	/**
	 * 显示角色列表
	 * 
	 * @param role
	 * @return
	 */
	public List<Role> queryList(@Param("role") Role role, @Param("order") String order);

	public List<Role> queryRoles();

	/**
	 * 删除角色对应的权限
	 * 
	 * @param id
	 *            角色id
	 * @return
	 */
	public boolean deleteRoleAuth(Integer id);

	/**
	 * 根据用户id来查询角色
	 * 
	 * @param id
	 * @return
	 */
	public List<Role> getListByUserId(Integer id);

	/**
	 * 
	 * 根据用户id从分组中获得角色
	 * 
	 * @version 2017年10月20日下午5:37:19
	 * @author xuweiping
	 * @param id
	 * @return
	 */
	public List<Role> getListByUserIdFromGroup(Integer id);

}
