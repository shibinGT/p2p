package com.qhcs.ssm.dao;

import com.qhcs.ssm.entity.User;

/**
 * 
 * @TODO:操作用户mapper
 * @author ：shibin
 * @version:2017年10月19日
 */
public interface UserMapper {
	/**
	 * 
	 * TODO:根据ID查询用户信息
	 * 
	 * @version:2017年10月19日
	 * @aothor：shibin
	 * @param userId
	 * @return
	 */
	public User queryUserById(Integer userId);

	/**
	 * 
	 * TODO:根据名字查询用户信息
	 * 
	 * @version:2017年10月19日
	 * @aothor：shibin
	 * @param userName
	 * @return
	 */
	public User queryUserByName(String userName);
	/**
	 * 
	 * TODO:根据手机号查询用户信息
	 * 
	 * @version:2017年10月19日
	 * @aothor：shibin
	 * @param userName
	 * @return
	 */
	public User queryUserByPhone(String userPhone);
	
	/**
	 * 
	 * TODO:添加用户
	 * 
	 * @version:2017年10月19日
	 * @aothor：shibin
	 * @param user
	 * @return
	 */
	public boolean addUser(User user);

}
