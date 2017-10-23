package com.qhcs.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qhcs.ssm.dao.UserMapper;
import com.qhcs.ssm.entity.User;

/**
 * 
 *@TODO:用户对象service
 * @author ：shibin
 *@version:2017年10月19日
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
	public User queryUserById(Integer userId){
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
	public User queryUserByName(String userName){
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
	public boolean addUser(User user){
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
	public User queryUserByPhone(String userPhone){
		return userMapper.queryUserByPhone(userPhone);
	}
	/**
	 * 
	 *TODO:改变用户状态
	 *@version:2017年10月20日
	 *@aothor：shibin
	 * @param userStatus
	 * @param userName
	 * @return
	 */
		public boolean updateUserStatus(Integer userStatus,String userName){
			return userMapper.updateUserStatus(userStatus, userName);
		}
		/**
		 * 
		 *TODO:修改密码
		 *@version:2017年10月21日
		 *@aothor：shibin
		 * @param userPassword
		 * @param userName
		 * @return
		 */
		public boolean updateUserPassword(String userPassword,String userName){
			return userMapper.updateUserPassword(userPassword, userName);
	}
}
