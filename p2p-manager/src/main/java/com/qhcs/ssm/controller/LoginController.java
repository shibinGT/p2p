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

import com.qhcs.security.cache.RedisManager;
import com.qhcs.ssm.entity.Employee;
import com.qhcs.ssm.service.ManagerIndexService;

@Controller
public class LoginController {

	@Autowired
	private RedisManager redis;
	@Autowired
	private ManagerIndexService managerIndexService;

	@RequestMapping("/login")
	public String login(@Valid Employee employee, BindingResult result, Model model, HttpSession session) {
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
			String credentials = employee.getEmployeePassword();
			int hashIterations = 73;
			Object salt = employee.getEmployeeAccountNumber();
			Object obj = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
			// md5 加密 密码 加密73次用用户名进行加盐结束
			System.err.println(obj.toString());
			employee.setEmployeePassword(obj.toString());
			// 把用户名和密码包装成一个token，UsernamePasswordToken
			UsernamePasswordToken token = new UsernamePasswordToken(employee.getEmployeeAccountNumber(),
					employee.getEmployeePassword());

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
	public String logout(Employee employee) {
		return "index";
	}

	@RequestMapping("/main")
	public String main(Employee employee, Model model) {
		// [["2000-06-05",222],["2000-06-06",129],["2000-06-07",135],["2000-06-08",300],["2000-06-09",73],["2000-06-10",85],["2000-06-11",73],["2000-06-12",68],["2000-06-13",92],["2000-06-14",130],["2000-06-15",245],["2000-06-16",139],["2000-06-17",115],["2000-06-18",111],["2000-06-19",309],["2000-06-20",206],["2000-06-21",137],["2000-06-22",128],["2000-06-23",85],["2000-06-24",94],["2000-06-25",71],["2000-06-26",106],["2000-06-27",84],["2000-06-28",93],["2000-06-29",85],["2000-06-30",73],["2000-07-01",83],["2000-07-02",125],["2000-07-03",107],["2000-07-04",82],["2000-07-05",44],["2000-07-06",72],["2000-07-07",106],["2000-07-08",107],["2000-07-09",66],["2000-07-10",91],["2000-07-11",92],["2000-07-12",113],["2000-07-13",107],["2000-07-14",131],["2000-07-15",111],["2000-07-16",64],["2000-07-17",69],["2000-07-18",88],["2000-07-19",77],["2000-07-20",83],["2000-07-21",111],["2000-07-22",57],["2000-07-23",55],["2000-07-24",60]];
		// redis取出金额人数等数据
		String total = redis.get("aaa");
		// 取出注册人数统计数据
		String jsonStr = managerIndexService.getRegNumByDate();
		model.addAttribute("jsonStr", jsonStr);
		model.addAttribute("total", total);
		return "main";
	}
}
