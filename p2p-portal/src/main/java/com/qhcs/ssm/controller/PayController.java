package com.qhcs.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qhcs.ssm.entity.ClientApply;
import com.qhcs.ssm.service.ClientApplyService;

@Controller
public class PayController {
	@Autowired
	private ClientApplyService clientApplyService;

	private String verifyCode;

	/**
	 * 
	 * 充值页面
	 * 
	 * @version 2017年10月21日上午9:12:46
	 * @author lizongcai
	 * @param clientApply
	 * @return
	 */
	@RequestMapping("/toPay")
	public String toApply(ClientApply clientApply) {
		return "pay";
	}

}
