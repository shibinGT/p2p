/*
 * Copyright (C) 2015 ShenZhen QiHangChuangShi Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳起航创势科技有限公司 www.qihcs.com.
 */
package com.qhcs.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.qhcs.ssm.dao.AuthMapper;
import com.qhcs.ssm.entity.Auth;
import com.qhcs.ssm.entity.Role;
import com.qhcs.ssm.service.RoleService;

/**
 * 角色控制类
 * 
 * @version 2017年9月26日上午10:03:07
 * @author lijing
 */
@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@Autowired
	private AuthMapper authMapper;

	/**
	 * 添加用户角色
	 * 
	 * @param role
	 *            角色信息
	 * @param model
	 * @return
	 */
	@RequestMapping("/toAdd")
	public String toAdd(Model model) {
		List<Auth> auths = authMapper.queryAuths(new Auth(), null);
		model.addAttribute("auths", auths);
		return "role-toAdd";
	}

	/**
	 * 根据角色id删除角色
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/delById")
	public String delRoleById(Integer id, Model model) {
		// 删除角色
		boolean operResult = roleService.delete(id);
		model.addAttribute("operResult", operResult);
		return "redirect:/role/list";
	}

	/**
	 * 批量删除角色
	 * 
	 * @param lists
	 * @param model
	 * @return
	 */
	@RequestMapping("/batchDel")
	public String batchDelUser(Integer[] lists, Model model) {
		boolean result = false;
		if (lists.length > 0) {
			result = roleService.batchDelRole(lists);
		}
		model.addAttribute("result", result);
		return "redirect:/role/list";
	}

	/**
	 * 添加用户角色
	 * 
	 * @param role
	 *            角色信息
	 * @param model
	 * @return
	 */
	@RequestMapping("/add")
	public String add(Role role, Model model) {
		// 添加角色
		boolean result = roleService.insert(role);
		// 添加关联
		if (result) {
			for (Integer aid : role.getAuths()) {
				roleService.addRoleAuth(role.getRoleId(), aid);
			}
		}
		model.addAttribute("result", result);
		return "redirect:/role/list";
	}

	/**
	 * 跳转到更新
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/toUpdate")
	public String toUpdata(@RequestParam("id") Integer id, Model model) {
		Role role = roleService.selectById(id);
		// 权限列表
		List<Auth> auths = authMapper.queryAuths(new Auth(), null);
		model.addAttribute("auths", auths);
		model.addAttribute("role", role);
		return "role-update";
	}

	/**
	 * 
	 * 更新
	 * 
	 * @version 2017年9月27日下午12:31:00
	 * @author chengang
	 * @param role
	 * @param model
	 * @return
	 */
	@RequestMapping("/update")
	public String update(Role role, Model model) {
		// 更新角色
		boolean result = roleService.update(role);

		model.addAttribute("result", result);
		return "redirect:/role/list";
	}

	@RequestMapping("/list")
	public String roleList(Role role, String order, Model model) {
		PageInfo<Role> pageInfo = roleService.queryList(role, order);
		model.addAttribute("pageInfo", pageInfo);
		return "role-list";
	}
}
