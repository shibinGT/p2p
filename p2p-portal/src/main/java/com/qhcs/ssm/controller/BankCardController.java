package com.qhcs.ssm.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qhcs.ssm.entity.BankCard;
import com.qhcs.ssm.entity.User;
import com.qhcs.ssm.service.BankCardService;

@Controller
public class BankCardController {

	@Autowired
	BankCardService bankCardService;

	/**
	 * 
	 * 跳转到安全保障页面
	 * 
	 * @version 2017年10月22日下午1:08:31
	 * @author lizongcai
	 * @return
	 */
	@RequestMapping("/toSafety")
	public String toSafety() {
		return "safety";
	}

	/**
	 * 
	 * 跳转到充值页面
	 * 
	 * @version 2017年10月22日下午1:08:31
	 * @author lizongcai
	 * @return
	 */
	@RequestMapping("/toPay")
	public String toPay() {
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
		// 把充值结果放在session
		session.setAttribute("result", result);
		return "redirect:/toPay";
	}

	/**
	 * 
	 * 跳转到提款页面
	 * 
	 * @version 2017年10月22日下午1:08:31
	 * @author lizongcai
	 * @return
	 */
	@RequestMapping("/toDrawings")
	public String toDrawing(HttpSession session, Model model) {
		// 获取登录用户
		User user = (User) session.getAttribute("loginUser");
		// 取出用户id
		Integer userId = user.getUserId();
		// 返回可用金额
		double usableMoney = bankCardService.queryAccountByUserId(userId);
		model.addAttribute("usableMoney", usableMoney);
		return "drawings";
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
	@RequestMapping("/drawings")
	public String drawing(@Param("cashNumber") String cashNumber, HttpSession session) {
		// 获取登录用户
		User user = (User) session.getAttribute("loginUser");
		// 取出用户id
		Integer userId = user.getUserId();
		// 充值金额转换为double
		Double updateMoney = Double.parseDouble("-" + cashNumber);
		// 修改用户可用余额和添加交易记录
		boolean result = bankCardService.updateAccountAddTransaction(updateMoney, userId);
		// 把充值结果放在session
		session.setAttribute("result", result);
		return "redirect:/toDrawings";
	}
}
