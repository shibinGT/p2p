package com.qhcs.ssm.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qhcs.ssm.entity.ClientApply;
import com.qhcs.ssm.entity.User;
import com.qhcs.ssm.service.ClientApplyService;

@Controller
@RequestMapping("/client")
public class ClientApplyController {
	@Autowired
	private ClientApplyService clientApplyService;

	private String verifyCode;

	/**
	 * 
	 * 去申请页面
	 * 
	 * @version 2017年10月21日上午9:12:46
	 * @author lizongcai
	 * @param clientApply
	 * @return
	 */
	@RequestMapping("/toApply")
	public String toApply(ClientApply clientApply) {
		return "apply";
	}

	/**
	 * 
	 * 申请表
	 * 
	 * @version 2017年10月20日下午3:47:36
	 * @author lizongcai
	 * @param clientApply
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@RequestMapping("/apply")
	public String Apply(@Valid ClientApply clientApply, BindingResult bindingResult, Model model, HttpSession session) {
		// 判断申请表不为空且错误为0
		if (clientApply == null && bindingResult.getErrorCount() > 0) {
			// 返回申请页面
			return "redirect: /client/toApply";
		}
		// 获取登录用户
		User user = (User) session.getAttribute("loginUser");
		// 取出用户id
		Integer userId = user.getUserId();
		// 获取当前时间
		Date date = new Date();
		clientApply.setApplyTime(date);
		clientApply.setUserId(userId);
		boolean result = clientApplyService.addClientApply(clientApply);
		session.setAttribute("result", result);
		return "redirect:/client/toApply";
	}

	@RequestMapping("/getCode")
	public void getCode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 图片高度
		int img_height = 100;
		// 图片宽度
		int img_width = 40;
		// 验证码长度
		int code_len = 4;
		// 用于绘制图片，设置图片的长宽和图片类型（RGB)
		BufferedImage bi = new BufferedImage(img_height, img_width, BufferedImage.TYPE_INT_RGB);
		// 获取绘图工具
		Graphics graphics = bi.getGraphics();
		graphics.setColor(new Color(224, 255, 255)); // 使用RGB设置背景颜色
		graphics.fillRect(0, 0, 100, 40); // 填充矩形区域
		// 验证码中所使用到的字符
		char[] codeChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456".toCharArray();
		String captcha = ""; // 存放生成的验证码
		Random random = new Random();
		for (int i = 0; i < code_len; i++) { // 循环将每个验证码字符绘制到图片上
			int index = random.nextInt(codeChar.length);
			// 随机生成验证码颜色
			graphics.setColor(new Color(random.nextInt(150), random.nextInt(200), random.nextInt(255)));
			// 将一个字符绘制到图片上，并制定位置（设置x,y坐标）
			graphics.drawString(codeChar[index] + "", (i * 20) + 15, 25);
			captcha += codeChar[index];
		}
		verifyCode = captcha;
		// 将生成的验证码code放入sessoin中
		req.getSession().setAttribute("code", captcha);

		// 通过ImageIO将图片输出
		ImageIO.write(bi, "JPG", resp.getOutputStream());
	}

	/**
	 * 
	 * 验证编码
	 * 
	 * @version 2017年10月20日下午3:39:13
	 * @author lizongcai
	 * @param code
	 * @return
	 */
	@RequestMapping("/verifyCode")
	@ResponseBody
	public String verifyCode(@Param("code") String code) {
		System.out.println(code);
		String result = "100";
		if (StringUtils.isBlank(code)) {
			result = "100";
		} else if (verifyCode.equalsIgnoreCase(code)) {
			result = "200";
		} else {
			result = "300";
		}
		return result;
	}
}
