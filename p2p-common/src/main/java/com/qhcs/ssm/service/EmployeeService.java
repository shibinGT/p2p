package com.qhcs.ssm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qhcs.ssm.dao.EmployeeMapper;
import com.qhcs.ssm.entity.Employee;
import com.qhcs.ssm.entity.Role;

/**
 * 用户对象的业务处理类
 * 
 * @author YI
 *
 */
@Service
public class EmployeeService {

	@Autowired
	private EmployeeMapper userMapper;

	/**
	 * 根据用户id来查询用户信息
	 * 
	 * @param id
	 *            用户id
	 * @return user 返回用户信息
	 */
	public Employee queryUserById(Integer id) {
		return userMapper.queryUserById(id);
	}

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
	public Employee queryUserByName(String name) {
		return userMapper.queryUserByName(name);
	}

	// /**
	// *
	// * 增加普通用户，并添加普通用户角色
	// *
	// * @version 2017年9月25日下午10:27:36
	// * @author xuweiping
	// * @param user
	// * 用户信息
	// * @return boolean 添加成功为true，失败为false
	// */
	// public boolean addNomalUser(User user) {
	// userMapper.addNomalUser(user);
	// return userMapper.addNomalUserRole(user.getId());
	// }

	public List<Role> queryRole() {
		return userMapper.queryRole();

	}

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
	public boolean addAdmin(Employee employee) {
		return userMapper.addNomalUser(employee);
	}

	/**
	 * 
	 * 给管理员添加admin角色
	 * 
	 * @version 2017年9月25日下午10:27:36
	 * @author xuweiping
	 * @param
	 * 
	 * @return boolean 添加成功为true，失败为false
	 */
	public boolean addAdminRole(Integer uid, Integer rid) {
		boolean fal = userMapper.addAdminRole(uid, rid);
		return fal;
	}

	/**
	 * 查询用户列表
	 * 
	 * @param user
	 *            参数
	 * @return 返回用户列表信息
	 */
	public PageInfo<Employee> queryList(Employee user, String order) {

		PageHelper.startPage(user.getPageNum(), user.getPageSize());

		List<Employee> users = userMapper.queryList(user, order);
		// 封装，把list封装成 PageInfo
		PageInfo page = new PageInfo<>(users);

		System.out.println("总数量：" + page.getTotal());
		System.out.println("页数：" + page.getPages());

		// PageInfo pageInfo = PageHelper.startPage(1, 10).doSelectPageInfo(();

		return page;
	}

	// 删除用户和用户角色，用户分组
	public boolean delUserById(Integer id) {
		boolean result = userMapper.del(id);
		userMapper.delUserRole(id);
		userMapper.delUserGroup(id);
		return result;
	}

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
	public boolean batchDel(Integer[] lists) {
		userMapper.batchDelUserRole(lists);
		userMapper.batchDelUserGroup(lists);
		return userMapper.batchDel(lists);
	}

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
	public boolean updatePassword(@Param("id") Integer id, @Param("npsw") String newPassword) {
		return userMapper.updatePassword(id, newPassword);
	}

	/**
	 * 
	 * 批量上传增加员工
	 * 
	 * @version 2017年10月21日下午3:50:18
	 * @author xuweiping
	 * @param list
	 * @return
	 */
	public boolean batchAdd(@Param("list") List<Employee> list) {
		userMapper.batchAdd(list);
		return userMapper.batchAddRole(list);

	}

}
