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
import com.qhcs.ssm.dao.RoleMapper;
import com.qhcs.ssm.entity.Role;

/**
 * TODO:类功能介绍
 * 
 * @version 2017年9月25日下午9:56:25
 * @author chengang
 */
@Service
public class RoleService {

	@Autowired
	private RoleMapper roleMapper;

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
		// 删除角色
		boolean result = roleMapper.delete(id);
		// 删除角色对应的权限关联
		return result;
	}

	/**
	 * 批量删除
	 * 
	 * @param ids
	 *            用户id的集合
	 * @return int 返回删除成功的数量
	 */
	public boolean batchDelRole(Integer[] lists) {
		return roleMapper.batchDelRole(lists);
	}

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
	public boolean insert(Role role) {
		return roleMapper.insert(role);
	}

	/**
	 * 添加角色权限关联表
	 * 
	 * @author lijing
	 * @param rid用户id
	 * @param aid角色id
	 * @return
	 */
	public boolean addRoleAuth(Integer rid, Integer aid) {
		return roleMapper.addRoleAuth(rid, aid);
	}

	/**
	 * 
	 * 更新角色
	 * 
	 * @version 2017年9月25日下午8:48:07
	 * @author lizongcai
	 * @param role
	 *            角色
	 * @return 成功返回true，失败返回false
	 */
	public boolean update(Role role) {
		// 更新角色权限对应表--先删除原有的
		roleMapper.deleteRoleAuth(role.getRoleId());
		// 重新从列表中获取，然后插入
		if (role.getAuths().size() > 0) {
			for (Integer aid : role.getAuths()) {
				roleMapper.addRoleAuth(role.getRoleId(), aid);
			}
		} else {
			System.out.println("没有选择任何权限！");
		}
		// 更新角色基本信息
		return roleMapper.update(role);
	}

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
	public Role selectById(Integer id) {
		return roleMapper.selectById(id);
	}

	/**
	 * 
	 * TODO:获取角色列表
	 * 
	 * @version 2017年9月27日下午5:06:37
	 * @author lijing
	 * @param role
	 * @return
	 */
	public PageInfo<Role> queryList(Role role) {
		PageHelper.startPage(role.getPageNum(), role.getPageSize());

		List<Role> roles = roleMapper.queryList(role);
		// 封装，把list封装成 PageInfo
		PageInfo<Role> page = new PageInfo<Role>(roles);
		// PageInfo pageInfo = PageHelper.startPage(1, 10).doSelectPageInfo(();
		return page;
	}

	/**
	 * 根据用户id来查询角色
	 * 
	 * @param id
	 * @return
	 */
	public List<Role> getListByUserId(Integer id) {
		return roleMapper.getListByUserId(id);
	}
}
