package com.qhcs.ssm.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qhcs.ssm.entity.User;
import com.qhcs.ssm.service.UserService;

import redis.clients.jedis.ShardedJedis;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 
	 * TODO:跳转到注册
	 * 
	 * @version:2017年10月19日
	 * @aothor：shibin
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/toregister")
	public String toregister() {
		return "register";
	}

	/**
	 * 
	 * TODO:跳转到登录
	 * 
	 * @version:2017年10月19日
	 * @aothor：shibin
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/tologin")
	public String tologin() {
		return "login";
	}

	/**
	 * 
	 * TODO:登录
	 * 
	 * @version:2017年10月20日
	 * @aothor：shibin
	 * @return
	 */
	@RequestMapping("/login")
	public String login(User user, String jpgVerify, Model model, HttpSession session, HttpServletRequest request) {
		// 一堆判断
		// 是否为空
		if (!StringUtils.isNotBlank(user.getUserName()) || !StringUtils.isNotBlank(user.getUserPassword())
				|| !StringUtils.isNotBlank(jpgVerify)) {
			model.addAttribute("islogin", "登录信息不完整");
			return "login";// 失败返回登录页面
		}
		// 判断数据里有没有
		// 根据用户名查
		User queryuser = userService.queryUserByName(user.getUserName());
		// 把密码加密再比较
		// md5 加密 密码 加密73次用用户名进行加盐
		String hashAlgorithmName = "MD5";
		String credentials = user.getUserPassword();
		Object salt = user.getUserName();
		int hashIterations = 73;
		Object obj = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
		// 比较如果密码一样
		if (queryuser.getUserPassword().equals(obj.toString())) {
			// 把用户丢到session里
			user.setUserPassword(obj.toString());
			session.setAttribute("loginUser", user);
			// 跳转回之前的url
			// 之前的URL，在拦截器中存入
			String str = (String) session.getAttribute("oldURL");
			// 如果是.jsp请求,请求以jsp结尾
			if (str.lastIndexOf(".jsp") == str.length() - 3) {
				return str;
			}
			// 跳转
			return "redirect:" + str;
		} else {
			// 密码不一样
			model.addAttribute("islogin", "用户名或密码不正确");
			return "tologin";
		}

	}

	/**
	 * 
	 * TODO:注册用户
	 * 
	 * @version:2017年10月19日
	 * @aothor：shibin
	 * @return
	 */
	@RequestMapping("/register")
	public String addUser(User user, String repeatPassword, String jpgVerify, String phonVerify, String protocol,
			Model model, HttpSession session) {
		// 判断user名密手机是否为空
		if (!StringUtils.isNotBlank(user.getUserName()) || !StringUtils.isNotBlank(user.getUserPassword())
				|| !StringUtils.isNotBlank(user.getUserPhone())) {
			model.addAttribute("isRegister", "注册信息不完整");
			return "register";// 失败返回注册页面
		}
		// 判断两次密码是否一样
		if (!user.getUserPassword().equals(repeatPassword)) {
			model.addAttribute("isRegister", "两次密码不一样");
			return "register";// 失败返回注册页面
		}
		// 判断验证码，前台把验证码放到redis里，后台拿？
		String sessionJpgVerify = (String) session.getAttribute("code");
		// 判断不区分大小写
		if (!jpgVerify.toLowerCase().equals(sessionJpgVerify.toLowerCase())) {
			model.addAttribute("isRegister", "验证码不正确");
			session.removeAttribute("code");
			return "register";// 失败返回注册页面
		}
		// 判断手机验证
		String sessionPhonVerify = (String) session.getAttribute("sendPhone");
		if (!phonVerify.equals(sessionPhonVerify)) {
			model.addAttribute("isRegister", "手机验证码不正确");
			session.removeAttribute("sendPhone");
			return "register";// 失败返回注册页面
		}
		// md5 加密 密码 加密73次用用户名进行加盐
		String hashAlgorithmName = "MD5";
		String credentials = user.getUserPassword();
		Object salt = user.getUserName();
		int hashIterations = 73;
		Object obj = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
		// 把userPasssword设置为加密后的字符串
		user.setUserPassword(obj.toString());
		boolean addSuccess = false;
		addSuccess = userService.addUser(user);
		if (addSuccess) {
			// 提示消息
			model.addAttribute("isRegister", "成功");
			//把用户名放进Model
			model.addAttribute("userName",user.getUserName());
			// 添加红包
			// 如果有推荐人，往推荐人里加一个红包

			return "registersucceed";// 成功返回注册成功页面
		}
		// 失败返回注册页面
		return "register";
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
	@RequestMapping("/checkUserName")
	protected void checkServlet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");// 接收发送过来的数据														
		if (userService.queryUserByName(userName) != null) {			
			response.getWriter().print(false); 
		} else {
			response.getWriter().print(true); 
		}		
	}
	/**
	 * 
	 * ajax 检查图片验证码是否正确
	 * 
	 * @version 2017年9月26日下午12:52:47
	 * @author xuweiping
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/checkJpgVerify")
	protected void checkJpgVerify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String jpgVerify = request.getParameter("jpgVerify");// 接收发送过来的数据		
		HttpSession session=request.getSession();
		// 判断验证码，
				String sessionJpgVerify = (String) session.getAttribute("code");
				// 判断不区分大小写
				if (!jpgVerify.toLowerCase().equals(sessionJpgVerify.toLowerCase())) {					
					response.getWriter().print(false); 					
				}else{
					response.getWriter().print(true); 		
				}		
	}
	/**
	 * 
	 * ajax 检查手机验证码是否正确
	 * @version 2017年9月26日下午12:52:47
	 * @author xuweiping
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/checkPhonVerify")
	protected void checkPhonVerify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String phonVerify = request.getParameter("phonVerify");// 接收发送过来的数据		
		HttpSession session=request.getSession();
		// 判断验证码
				String sessionPhonVerify = (String) session.getAttribute("sendPhone");
				// 判断不区分大小写
				if (!phonVerify.toLowerCase().equals(sessionPhonVerify.toLowerCase())) {					
					response.getWriter().print(false); 					
				}else{
					response.getWriter().print(true); 		
				}		
	}
	/**
	 * 
	 * ajax 检查手机号是否存在
	 * @version 2017年9月26日下午12:52:47
	 * @author xuweiping
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/checkPhone")
	protected void checkPhone(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userPhone = request.getParameter("userPhone");// 接收发送过来的数据														
		if (userService.queryUserByPhone(userPhone) != null) {			
			response.getWriter().print(false); 
		} else {
			response.getWriter().print(true); 
		}		
			
	}
	/**
	 * 
	 * TODO:生成验证码
	 * 
	 * @version:2017年10月19日
	 * @aothor：shibin
	 * @param seq
	 * @param ser
	 * @throws IOException
	 */
	@RequestMapping("/getCode")
	public void getCode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 图片高度
		int img_height = 100;
		// 图片宽度
		int img_width = 30;
		// 验证码长度
		int code_len = 4;
		// 用于绘制图片，设置图片的长宽和图片类型（RGB)
		BufferedImage bi = new BufferedImage(img_height, img_width, BufferedImage.TYPE_INT_RGB);
		// 获取绘图工具
		Graphics graphics = bi.getGraphics();
		graphics.setColor(new Color(224, 255, 255)); // 使用RGB设置背景颜色
		graphics.fillRect(0, 0, 100, 30); // 填充矩形区域
		// 验证码中所使用到的字符
		char[] codeChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456".toCharArray();
		String captcha = ""; // 存放生成的验证码
		Random random = new Random();
		for (int i = 0; i < code_len; i++) { // 循环将每个验证码字符绘制到图片上
			int index = random.nextInt(codeChar.length);
			// 随机生成验证码颜色
			graphics.setColor(new Color(random.nextInt(150), random.nextInt(200), random.nextInt(255)));
			// 将一个字符绘制到图片上，并制定位置（设置x,y坐标）
			graphics.drawString(codeChar[index] + "", (i * 20) + 15, 20);
			captcha += codeChar[index];
		}
		// 将生成的验证码code放入sessoin中
		req.getSession().setAttribute("code", captcha);
		// 通过ImageIO将图片输出
		ImageIO.write(bi, "JPG", resp.getOutputStream());
	}

	/**
	 * 
	 * TODO:ajax生成手机验证码
	 * 
	 * @version:2017年10月20日
	 * @aothor：shibin
	 * @param request
	 * @param response
	 * @param session
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/getSendPhone")
	public void getSendPhone(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		// 在这里生成验证码
		int x = 1000 + (int) (Math.random() * 10000);
		String data = String.valueOf(x);
		// 放进session
		session.setAttribute("sendPhone", data);
		// 输出String到reponse
		PrintWriter out = response.getWriter();
		out.println(data);
	}
}
