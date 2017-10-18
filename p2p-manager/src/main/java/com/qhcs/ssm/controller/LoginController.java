package com.qhcs.ssm.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qhcs.ssm.entity.User;
import com.qhcs.ssm.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String login(@Valid User user, BindingResult result, Model model, HttpSession session) {
		if (result.getErrorCount() > 0) {
			return "index";
		}

		System.out.println("开始登录...");
		Subject currentUser = SecurityUtils.getSubject();
		String errorMsg = null;
		// 如果没有登录
		if (!currentUser.isAuthenticated()) {

			// md5 加密 密码 加密73次用用户名进行加盐
			String hashAlgorithmName = "MD5";
			String credentials = user.getPassword();
			int hashIterations = 73;
			Object salt = user.getName();
			Object obj = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
			// md5 加密 密码 加密73次用用户名进行加盐结束
			System.err.println(obj.toString());
			user.setPassword(obj.toString());
			// 把用户名和密码包装成一个token，UsernamePasswordToken
			UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword());

			// 记住我
			token.setRememberMe(true);

			try {
				// 进行登录
				currentUser.login(token);

			} catch (UnknownAccountException uae) {
				uae.printStackTrace();
				errorMsg = "没有找到该用户，" + token.getPrincipal();
			} catch (IncorrectCredentialsException ice) {
				ice.printStackTrace();
				errorMsg = "密码错误";
			} catch (LockedAccountException lae) {
				lae.printStackTrace();
				errorMsg = "账号锁定";
			} catch (AuthenticationException ae) {
				// unexpected condition? error?
				ae.printStackTrace();
				errorMsg = "认证失败";
			}

		}

		if (errorMsg != null) {
			model.addAttribute("errorMsg", errorMsg);
			return "index";
		}

		return "redirect:/main";
	}

	@RequestMapping("/index")
	public String logout(User user) {
		return "index";
	}

	@RequestMapping("/main")
	public String main(User user) {
		return "main";
	}

}
