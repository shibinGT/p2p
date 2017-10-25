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
import com.qhcs.ssm.dao.EmployeeMapper;
import com.qhcs.ssm.dao.RoleMapper;
import com.qhcs.ssm.entity.Employee;
import com.qhcs.ssm.entity.Group;
import com.qhcs.ssm.entity.Role;
import com.qhcs.ssm.service.GroupService;

/**
 * 分组的控制层
 * 
 * @version 2017年10月8日下午9:01:01
 * @author xuweiping
 */
@Controller
@RequestMapping("/group")
public class GroupController {

	@Autowired
	private GroupService service;// 装配group的service层
	@Autowired
	private RoleMapper roleMapper;// 装配role的dao层
	@Autowired
	private EmployeeMapper employeeMapper;// 装配employee的dao层

	/**
	 * 去添加分组
	 */
	@RequestMapping("/toAdd")
	public String toAdd(Model model) {
		// 查询角色列表
		List<Role> roles = roleMapper.queryRoles();
		// 查询用户列表
		List<Employee> users = employeeMapper.queryList(new Employee(), null);
		model.addAttribute("roles2", roles);
		model.addAttribute("users", users);
		return "group-add";
	}

	/**
	 * 根据分组id进行删除分组操作
	 */
	@RequestMapping("/delById")
	public String delRoleById(Integer id, Model model) {
		// 删除角色
		boolean operResult = service.delete(id);
		model.addAttribute("operResult", operResult);
		return "redirect:/group/list";
	}

	/**
	 * 批量删除分组
	 */
	@RequestMapping("/batchDel")
	public String batchDelUser(Integer[] lists, Model model) {
		boolean result = false;
		if (lists.length > 0) {
			result = service.batchDelete(lists) > 0;
		}
		model.addAttribute("result", result);
		return "redirect:/group/list";
	}

	/**
	 * 添加一个分组
	 */
	@RequestMapping("/add")
	public String add(Group group, Model model) {

		boolean result = service.addGroup(group);
		model.addAttribute("result", result);
		return "redirect:/group/list";
	}

	/**
	 * 跳转到更新
	 */
	@RequestMapping("/toUpdate")
	public String toUpdata(@RequestParam("id") Integer id, Model model) {
		Group group = service.quaryById(id);// 查询得到分组信息
		// 查询角色列表
		List<Role> roles = roleMapper.queryRoles();
		// 查询用户列表
		List<Employee> users = employeeMapper.queryList(new Employee(), null);
		model.addAttribute("roles", roles);
		model.addAttribute("users", users);
		model.addAttribute("group", group);
		return "group-update";
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
	public String update(Group group, Model model) {
		// 更新角色
		boolean result = service.updateGroup(group);
		model.addAttribute("result", result);
		return "redirect:/group/list";
	}

	/**
	 * 
	 * 处理分组列表
	 * 
	 * @version 2017年10月8日下午9:19:00
	 * @author xuweiping
	 */
	@RequestMapping("/list")
	public String list(Group group, String order, Model model) {
		PageInfo<Group> pageInfo = service.quaryList(group, order);
		model.addAttribute("pageInfo", pageInfo);
		return "group-list";
	}

}
