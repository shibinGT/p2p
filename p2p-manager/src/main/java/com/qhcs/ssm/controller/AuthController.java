package com.qhcs.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.qhcs.ssm.entity.Auth;
import com.qhcs.ssm.service.AuthService;

/**
 * 
 * TODO:权限处理类
 * 
 * @version 2017年9月26日下午5:19:14
 * @author 星哥
 */
@Controller
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private AuthService authService;

	/**
	 * 
	 * TODO:动态查询权限列表
	 * 
	 * @version 2017年9月26日上午9:02:44
	 * @author 星哥
	 * @param auth
	 *            权限对象
	 * @param auth
	 *            权限对象
	 * @param model
	 * @return 返回权限列表页面
	 */
	@RequestMapping("/list")
	public String list(Auth auth, String order, Model model) {
		PageInfo<Auth> pageInfo = authService.queryAuths(auth,order);
		model.addAttribute("pageInfo", pageInfo);
		return "auth-list";
	}

	/**
	 * 
	 * TODO:根据id删除相应的权限及角色权限对应记录
	 * 
	 * @version 2017年9月26日上午9:25:14
	 * @author 星哥
	 * @param id
	 * @param session
	 * @return 返回权限列表页面
	 */
	@RequestMapping("/delAuth/{id}")
	public String del(@PathVariable("id") Integer id, HttpSession session) {
		boolean result = authService.delAuthById(id);
		session.setAttribute("result", result);
		return "redirect:/auth/list";
	}

	/**
	 * 
	 * TODO:批量删除权限
	 * 
	 * @version 2017年9月26日上午11:22:24
	 * @author 星哥
	 * @param auth
	 *            权限对象
	 * @param model
	 *            模型对象
	 * @return 删除成功返回true,失败返回false
	 * @throws InterruptedException
	 */
	@RequestMapping("/batchDelAuths")
	public String batchDelAuths(Auth auth, Model model) {
		boolean result = false;
		System.err.println(auth.getIds() + ";" + auth.getAuthId());
		if (auth != null && auth.getIds().size() > 0) {
			int successCount = authService.batchDelAuths(auth.getIds());
			result = successCount > 0;
		}
		model.addAttribute("result", result);
		return "redirect:/auth/list";
	}

	/**
	 * 
	 * TODO:新增一个权限
	 * 
	 * @version 2017年9月26日上午10:21:53
	 * @author 星哥
	 * @param auth
	 *            权限对象
	 * @param model
	 *            模型对象
	 * @return 添加成功返回权限列表页面，添加失败返回编辑页面
	 */
	@RequestMapping("/addAuth")
	public String addAuth(Auth auth, Model model) {
		boolean result = authService.addAuth(auth);
		model.addAttribute("result", result);
		return "redirect:/auth/list";
	}

	/**
	 * 
	 * TODO:新增一个权限
	 * 
	 * @version 2017年9月26日上午10:21:53
	 * @author 星哥
	 * @param auth
	 *            权限对象
	 * @param model
	 *            模型对象
	 * @return 添加成功返回权限列表页面，添加失败返回编辑页面
	 */
	@RequestMapping("/updateAuth")
	public String updateAuth(Auth auth, Model model) {
		boolean result = authService.updateAuth(auth);
		model.addAttribute("result", result);
		return "redirect:/auth/list";
	}

}
