/*
 * Copyright (C) 2015 ShenZhen QiHangChuangShi Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳起航创势科技有限公司 www.qihcs.com.
 */
package com.qhcs.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qhcs.ssm.dao.GroupMapper;
import com.qhcs.ssm.entity.Group;

/**
 * 分组的service层
 * 
 * @version 2017年10月8日下午8:52:55
 * @author xuweiping
 */
@Service
public class GroupService {

	@Autowired
	private GroupMapper dao;

	/**
	 * 
	 * 根据分组编码模糊查询分组列表
	 * 
	 * @version 2017年10月8日下午7:07:42
	 * @author xuweiping
	 * @param group
	 *            分组信息
	 * @return 封装页数的分组列表
	 */
	public PageInfo<Group> quaryList(Group group, String order) {
		PageHelper.startPage(group.getPageNum(), group.getPageSize());
		List<Group> groups = dao.quaryList(group.getGroupCode(), order);
		// 封装，把list封装成 PageInfo
		PageInfo<Group> page = new PageInfo<Group>(groups);
		// PageInfo pageInfo = PageHelper.startPage(1, 10).doSelectPageInfo(();
		return page;
	}

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
	public Group quaryById(Integer groupId) {
		return dao.quaryById(groupId);
	}

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
	public boolean delete(Integer id) {
		return dao.delete(id);
	}

	/**
	 * 批量删除
	 * 
	 * @param ids
	 *            用户id的集合
	 * @return int 返回删除成功的数量
	 */
	public int batchDelete(Integer[] lists) {
		return dao.batchDelete(lists);
	}

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
	public boolean addGroup(Group group) {
		dao.addGroup(group);
		dao.batchAddRoles2(group.getRoleIds(), group.getGroupId());
		return dao.batchAddUsers(group.getUserIds(), group.getGroupId());
	}

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
	public boolean updateGroup(Group group) {
		// 修改分组信息
		dao.updateGroup(group);
		// 删除改组的所有角色
		dao.delRoles(group.getGroupId());
		// 重新添加角色
		dao.batchAddRoles2(group.getRoleIds(), group.getGroupId());
		// 删除改组所有用户
		dao.delUsers(group.getGroupId());
		// 重新添加用户
		return dao.batchAddUsers(group.getUserIds(), group.getGroupId());
	}
}
