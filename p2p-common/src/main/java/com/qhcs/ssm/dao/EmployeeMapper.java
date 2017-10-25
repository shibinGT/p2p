package com.qhcs.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qhcs.ssm.entity.Employee;
import com.qhcs.ssm.entity.Role;

/**
 * 访问User对象的mapper
 * 
 * @author YI
 *
 */
public interface EmployeeMapper {

	/**
	 * 根据用户id来查询用户信息
	 * 
	 * @param id
	 *            用户id
	 * @return user 返回用户信息
	 */
	public Employee queryUserById(Integer id);

	/**
	 * 
	 * 根据用户名查找用户信息
	 * 
	 * @version 2017年9月25日下午10:00:35
	 * @author xuweiping
	 * @param name
	 *            用户名
	 * @return user 返回用户信息
	 */
	public Employee queryUserByName(String name);

	/**
	 *
	 * 增加普通用户
	 *
	 * @version 2017年9月25日下午10:27:36
	 * @author xuweiping
	 * @param user
	 *            用户信息
	 * @return boolean 添加成功为true，失败为false
	 */
	public boolean addNomalUser(Employee employee);

	// /**
	// *
	// * 增加普通用户的角色
	// *
	// * @version 2017年9月26日上午11:31:22
	// * @author xuweiping
	// * @param id
	// * 普通用户id
	// * @return boolean 添加成功为true，失败为false
	// */
	// public boolean addNomalUserRole(Integer id);

	/**
	 * 查询用户列表
	 * 
	 * @param user
	 *            参数
	 * @return 返回用户列表信息
	 */
	public List<Employee> queryList(@Param("employee") Employee employee, @Param("order") String order);

	/**
	 * 根据id来删除用户信息
	 * 
	 * @param id
	 *            用户id
	 * @return 成功返回true，失败返回false
	 */
	public boolean del(Integer id);

	/**
	 * 根据id来删除用户角色信息
	 * 
	 * @param id
	 *            用户id
	 * @return 成功返回true，失败返回false
	 */
	public boolean delUserRole(Integer id);

	public boolean batchDelUserRole(@Param("lists") Integer[] lists);

	/**
	 * 
	 * 根据id删除用户的分组信息
	 * 
	 * @version 2017年10月20日上午10:42:50
	 * @author xuweiping
	 * @param id
	 *            用户id
	 * @return
	 */
	public boolean delUserGroup(Integer id);

	public boolean batchDelUserGroup(@Param("lists") Integer[] lists);

	/**
	 * 
	 * TODO:根据id删除用户
	 * 
	 * @version 2017年9月26日上午9:43:26
	 * @author liutianwen
	 * @param uid
	 * @return
	 */
	public boolean delUser(Integer uid);

	/**
	 * 
	 * 给管理员添加admin角色
	 * 
	 * @version 2017年9月26日上午11:31:22
	 * @author xuweiping
	 * @param id
	 *            普通用户id1
	 * @return boolean 添加成功为true，失败为false
	 */
	public boolean addAdminRole(@Param("uid") Integer uid, @Param("rid") Integer rid);

	/**
	 * 角色信息
	 * 
	 * @return 成功返回角色列表信息
	 */
	public List<Role> queryRole();

	/**
	 * 
	 * TODO:管理员修改密码,如果输入为空默认123456
	 * 
	 * @version 2017年9月26日上午9:44:03
	 * @author liutianwen
	 * @param uid
	 * @return
	 */
	public boolean changePassword(String newPassword, Integer uid);

	/**
	 * 
	 * 批量删除用户
	 * 
	 * @version 2017年10月20日上午9:31:21
	 * @author xuweiping
	 * @param ids
	 *            要删除的用户的id的list
	 * @return boolean 添加成功为true，失败为false
	 */
	public boolean batchDel(@Param("lists") Integer[] lists);

	/**
	 * 
	 * 重置密码为123456
	 * 
	 * @version 2017年10月20日下午12:08:16
	 * @author xuweiping
	 * @param id
	 *            用户id
	 * @param newPassword
	 * @return
	 */
	public boolean updatePassword(@Param("id") Integer id, @Param("npsw") String newPassword);

	/**
	 * 
	 * 批量上传增加员工
	 * 
	 * @version 2017年10月21日下午3:50:18
	 * @author xuweiping
	 * @param list
	 * @return
	 */
	public boolean batchAdd(@Param("list") List<Employee> list);

	/**
	 * 批量增加普通角色
	 * 
	 * @param lists
	 * @return
	 */
	public boolean batchAddRole(@Param("list") List<Employee> list);
}
