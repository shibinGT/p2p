package com.qhcs.ssm.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qhcs.ssm.entity.ClientApply;
import com.qhcs.ssm.service.ClientApplyService;

@Controller
@RequestMapping("/client")
public class ClientApplyController {
	@Autowired
	private ClientApplyService clientApplyService;

	@RequestMapping("/toApply")
	public String toApply(ClientApply clientApply) {
		return "toApply";
	}

	@RequestMapping("/apply")
	public String Apply(@Valid ClientApply clientApply, BindingResult bindingResult, Model model) {
		// 判断申请表不为空且错误为0
		if (clientApply == null && bindingResult.getErrorCount() == -1) {
			// 返回申请页面
			return "toApply";
		}
		Date date = new Date();
		clientApply.setApplyTime(date);
		boolean result = clientApplyService.addClientApply(clientApply);
		model.addAttribute("result", result);
		return "/client/toApply";
	}
}
