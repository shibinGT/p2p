package com.qhcs.ssm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.qhcs.ssm.entity.Role;
import com.qhcs.ssm.entity.User;
import com.qhcs.ssm.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/list")
	public String list(User user, Model model) {
		PageInfo<User> pageInfo = userService.queryList(user);
		model.addAttribute("pageInfo", pageInfo);
		return "user-list";

	}

	/**
	 * @author liutianwen
	 * @param id需要删除的用户id
	 * @return 返回到list页面
	 */
	@RequestMapping("/del/${id}")
	public String del(@PathVariable("id") Integer id, HttpSession session) {

		boolean operResult = userService.delUserById(id);
		// 把操作结果放入session域中
		session.setAttribute("operResult", operResult);

		return "redirect:/user/list";

	}

	/**
	 * @author liutianwen
	 * @param newPassword
	 *            新密码
	 * @param id
	 *            用户id
	 * @return 返回到用户页面
	 */
/*	@RequestMapping("/changePwd")
	public String changePassword(String newPassword, Integer id, HttpSession session) {
		boolean result = userService.changePassword(newPassword, id);
		userService.session.setAttribute("result", result);
		return "user-list";
	}
*/
	/**
	 * 
	 * 注册
	 * 
	 * @version 2017年9月26日上午11:09:57
	 * @author xuweiping
	 * @param user
	 * @param model
	 * @return 成功返回登录界面，失败返回注册页面
	 */
	@RequestMapping("/register")
	public String register(User user, Model model) {
		if (!StringUtils.isNotBlank(user.getName()) || !StringUtils.isNotBlank(user.getPassword())) {
			model.addAttribute("isRegister", "true");
			return "index";// 失败返回注册页面
		}
		// md5 加密 密码 加密73次用用户名进行加盐
		String hashAlgorithmName = "MD5";
		String credentials = user.getPassword();
		int hashIterations = 73;
		Object salt = user.getName();
		Object obj = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
		// md5 加密 密码 加密73次用用户名进行加盐结束
		user.setPassword(obj.toString());
		boolean addSuccess = userService.addNomalUser(user);
		if (addSuccess) {
			return "redirect:/index";// 失败返回登录页面
		}
		model.addAttribute("isRegister", "true");
		return "index";// 失败返回注册页面
	}

	/**
	 * 
	 * ajax 检查用户名是否存在
	 * 
	 * @version 2017年9月26日下午12:52:47
	 * @author xuweiping
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/checkServlet")
	protected void checkServlet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String value = request.getParameter("value");// 接收发送过来的数据
														// value和method是key，接收value
		int tip = 1;
		if (userService.queryUserByName(value) != null) {
			tip = 0;
		} else {
			tip = 1;
		}
		// 输出String到reponse
		PrintWriter out = response.getWriter();
		out.println(tip);
	}

	@RequestMapping("/toAddAdmin")
	public String toAddAdmin(Model model) {
		List<Role> roles = userService.queryRole();
		model.addAttribute("roles", roles);
		return "admin-add";
	}

	/**
	 * 
	 * 新增管理员
	 * 
	 * @version 2017年9月26日上午11:09:57
	 * @author xuweiping
	 * @param user
	 * @param model
	 * @return 成功返回用户管理界面，失败返回注册页面
	 */
	@RequestMapping("/addAdmin")
	public String addAdmin(User user, Model model) {
		if (!StringUtils.isNotBlank(user.getName()) || !StringUtils.isNotBlank(user.getPassword())) {
			model.addAttribute("isRegister", "true");
			return "redirect:/user/toAddAdmin";// 失败返回注册页面
		}
		System.err.println(user + "123");
		// md5 加密 密码 加密73次用用户名进行加盐
		String hashAlgorithmName = "MD5";
		String credentials = user.getPassword();
		int hashIterations = 73;
		Object salt = user.getName();
		Object obj = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
		// md5
		user.setPassword(obj.toString());
		boolean addSuccess = false;
		addSuccess = userService.addAdmin(user);
		if (addSuccess) {
			for (Integer rid : user.getRoleid()) {
				userService.addAdminRole(user.getId(), rid);
			}
		}
		model.addAttribute("isRegister", "true");
		return "redirect:/user/list";// 失败返回注册页面

	}

}
