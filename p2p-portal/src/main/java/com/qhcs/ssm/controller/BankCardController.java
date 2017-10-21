package com.qhcs.ssm.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qhcs.ssm.entity.BankCard;
import com.qhcs.ssm.entity.User;
import com.qhcs.ssm.service.BankCardService;

@Controller
public class BankCardController {

	@Autowired
	BankCardService bankCardService;

	@RequestMapping("/toPay")
	public String pay() {
		return "pay";
	}

	/**
	 * 
	 * 充值用户可用余额
	 * 
	 * @version 2017年10月21日下午4:17:26
	 * @author lizongcai
	 * @param bankCard
	 * @param money
	 * @param session
	 * @return
	 */
	@RequestMapping("/pay")
	public String pay(BankCard bankCard, @Param("money") String money, HttpSession session) {
		// 获取登录用户
		User user = (User) session.getAttribute("loginUser");
		// 取出用户id
		Integer userId = user.getUserId();
		// 充值金额转换为double
		Double updateMoney = Double.parseDouble(money);
		// 修改用户可用余额
		boolean result = bankCardService.addBankCard(bankCard, updateMoney, userId);
		session.setAttribute("result", result);
		System.out.println("=============" + userId + "=========" + money + bankCard.toString());
		return "redirect:/toPay";
	}
}
