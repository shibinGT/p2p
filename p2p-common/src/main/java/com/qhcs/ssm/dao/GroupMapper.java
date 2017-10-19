/*
 * Copyright (C) 2015 ShenZhen QiHangChuangShi Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳起航创势科技有限公司 www.qihcs.com.
 */
package com.qhcs.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qhcs.ssm.entity.Group;

/**
 * 分组的dao层的mapper接口
 * 
 * @version 2017年10月8日下午7:06:36
 * @author xuweiping
 */
public interface GroupMapper {

	/**
	 * 
	 * 根据分组编码模糊查询分组列表
	 * 
	 * @version 2017年10月8日下午7:07:42
	 * @author xuweiping
	 * @param groupCode
	 *            分组编码
	 * @return 分组列表
	 */
	public List<Group> quaryList(@Param("groupCode") String groupCode);

	/**
	 * 
	 * 根据分组id查询分组信息
	 * 
	 * @version 2017年10月8日下午10:47:41
	 * @author xuweiping
	 * @param groupId
	 *            分组id
	 * @return group 分组信息
	 */
	public Group quaryById(Integer groupId);

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
	public int batchDelete(@Param("lists") Integer[] lists);

	/**
	 * 
	 * 增加一个分组信息
	 * 
	 * @version 2017年10月8日下午7:11:33
	 * @author xuweiping
	 * @param group
	 *            分组信息
	 * @return 是否添加成功
	 */
	public boolean addGroup(Group group);

	/**
	 * 
	 * 批量增加一个分组的角色信息
	 * 
	 * @version 2017年10月8日下午8:15:47
	 * @author xuweiping
	 * @param group
	 *            分组信息
	 * @return 是否添加成功
	 */
	public boolean batchAddRoles2(@Param("roleIds") List<Integer> roleIds, @Param("id") Integer id);

	/**
	 * 
	 * 根据分组id删除分组里面的所有角色
	 * 
	 * @version 2017年10月8日下午8:41:26
	 * @author xuweiping
	 * @param groupId
	 *            分组id
	 * @return 是否删除成功
	 */
	public boolean delRoles(Integer groupId);

	/**
	 * 
	 * 批量增加一个分组的用户信息
	 * 
	 * @version 2017年10月8日下午8:30:45
	 * @author xuweiping
	 * @param group
	 *            分组信息
	 * @return 是否添加成功
	 */
	public boolean batchAddUsers(@Param("userIds") List<Integer> userIds, @Param("id") Integer id);

	/**
	 * 
	 * 根据分组id删除分组里面的所有用户
	 * 
	 * @version 2017年10月8日下午8:41:26
	 * @author xuweiping
	 * @param groupId
	 *            分组id
	 * @return 是否删除成功
	 */
	public boolean delUsers(Integer groupId);

	/**
	 * 
	 * 修改一个分组信息
	 * 
	 * @version 2017年10月8日下午7:12:45
	 * @author xuweiping
	 * @param group
	 *            修改后的分组信息
	 * @return 是否修改成功
	 */
	public boolean updateGroup(Group group);

}
