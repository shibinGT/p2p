package com.qhcs.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
/**
 * 
 *TODO:改变用户状态
 *@version:2017年10月20日
 *@aothor：shibin
 * @param userStatus
 * @param userName
 * @return
 */
	public boolean updateUserStatus(Integer userStatus,String userName);
	/**
	 * 
	 *TODO:修改密码
	 *@version:2017年10月21日
	 *@aothor：shibin
	 * @param userPassword
	 * @param userName
	 * @return
	 */
	public boolean updateUserPassword(@Param("userPassword")String userPassword,@Param("userName")String userName);

	/**
	 * 批量增加
	 * 
	 * @param lists
	 * @return
	 */
	public boolean batchAdd(@Param("lists") List<User> lists);

	/**
	 * 根据用户名模糊查询得到列表并根据 order进行排序
	 * 
	 * @param userName
	 *            用户名
	 * @param order
	 *            排序依据
	 * @return
	 */
	public List<User> queryList(@Param("userName") String userName, @Param("order") String order);

	/**
	 * 根据用户的id对用户的状态进行改变
	 * 
	 * @param userId
	 *            用户的id
	 * @param status
	 *            改变后的状态
	 * @return
	 */
	public boolean freeze(@Param("userId") Integer userId, @Param("status") Integer status);
}
