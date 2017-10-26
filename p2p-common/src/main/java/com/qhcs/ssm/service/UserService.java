package com.qhcs.ssm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qhcs.ssm.dao.UserMapper;
import com.qhcs.ssm.entity.User;

/**
 * 
 * @TODO:用户对象service
 * @author ：shibin
 * @version:2017年10月19日
 */
@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 
	 * TODO:根据ID查询用户信息
	 * 
	 * @version:2017年10月19日
	 * @aothor：shibin
	 * @param userId
	 * @return
	 */
	public User queryUserById(Integer userId) {
		return userMapper.queryUserById(userId);
	}

	/**
	 * 
	 * TODO:根据名字查询用户信息
	 * 
	 * @version:2017年10月19日
	 * @aothor：shibin
	 * @param userName
	 * @return
	 */
	public User queryUserByName(String userName) {
		return userMapper.queryUserByName(userName);
	}

	/**
	 * 
	 * TODO:添加用户
	 * 
	 * @version:2017年10月19日
	 * @aothor：shibin
	 * @param user
	 * @return
	 */
	public boolean addUser(User user) {
		return userMapper.addUser(user);
	}

	/**
	 * 
	 * TODO:根据手机号查询用户信息
	 * 
	 * @version:2017年10月19日
	 * @aothor：shibin
	 * @param userName
	 * @return
	 */
	public User queryUserByPhone(String userPhone) {
		return userMapper.queryUserByPhone(userPhone);
	}

	/**
	 * 
	 * TODO:改变用户状态
	 * 
	 * @version:2017年10月20日
	 * @aothor：shibin
	 * @param userStatus
	 * @param userName
	 * @return
	 */
	public boolean updateUserStatus(Integer userStatus, String userName) {
		return userMapper.updateUserStatus(userStatus, userName);
	}

	/**
	 * 
	 * TODO:修改密码
	 * 
	 * @version:2017年10月21日
	 * @aothor：shibin
	 * @param userPassword
	 * @param userName
	 * @return
	 */
	public boolean updateUserPassword(String userPassword, String userName) {
		return userMapper.updateUserPassword(userPassword, userName);
	}

	/**
	 * 批量增加
	 * 
	 * @param lists
	 * @return
	 */
	public boolean batchAdd(@Param("lists") List<User> lists) {
		return userMapper.batchAdd(lists);
	}

	/**
	 * 根据用户名模糊查询得到列表并根据 order进行排序
	 * 
	 * @param userName
	 *            用户名
	 * @param order
	 *            排序依据
	 * @return
	 */
	public PageInfo<User> queryList(User user, String order) {
		PageHelper.startPage(user.getPageNum(), user.getPageSize());
		List<User> users = userMapper.queryList(user.getUserName(), order);
		// 封装，把list封装成 PageInfo
		PageInfo<User> page = new PageInfo<>(users);
		return page;
	}

	/**
	 * 根据用户的id对用户的状态进行改变
	 * 
	 * @param userId
	 *            用户的id
	 * @param status
	 *            改变后的状态
	 * @return
	 */
	public boolean freeze(Integer userId, Integer status) {
		return userMapper.freeze(userId, status);
	}


}
