package com.qhcs.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.qhcs.ssm.entity.User;
import com.qhcs.ssm.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/list")
	public String list(User user, String order, Model model) {
		PageInfo<User> pageInfo = userService.queryList(user, order);
		model.addAttribute("pageInfo", pageInfo);
		return "users-list";

	}
	
	@RequestMapping("/freeze/{userId}/{status}")
	public String freeze(@PathVariable("userId") Integer userId, @PathVariable("status") Integer status) {
		userService.freeze(userId, status);
		return "redirect:/users/list";
	}


}
