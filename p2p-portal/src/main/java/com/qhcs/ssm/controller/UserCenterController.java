package com.qhcs.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qhcs.ssm.dao.AccountMapper;
import com.qhcs.ssm.entity.Account;
import com.qhcs.ssm.entity.ReturnPlan;
import com.qhcs.ssm.entity.TransactionRecord;
import com.qhcs.ssm.entity.User;
import com.qhcs.ssm.service.AccountService;
import com.qhcs.ssm.service.ReturnPlanService;
import com.qhcs.ssm.service.TransactionRecordService;

@Controller
@RequestMapping("/user")
public class UserCenterController {
	
	@Autowired
	private ReturnPlanService planService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private TransactionRecordService transactionRecordService;
	/**
	 * 
	 * @author liutianwen
	 * @desc 个人中心首页
	 * @parm
	 * @return 跳转到个人中心首页
	 */
	@RequestMapping("/userIndex")
	public String userCenter(Model model,HttpServletRequest request){
		
		//用户ID
		User user = (User)request.getSession().getAttribute("loginUser");
		//int userID=user.getId();
		int userID=1;
		//通过用户ID查找出账户信息
		Account account=accountService.queryAccountByUserId(userID);
		//账户总额
		Double sum=account.getAccountFrozenCapital()+account.getAccountAvailableCapital();
		//待收本息
		Double accountDuePrincipalAndEarnings=account.getAccountDuePrincipal()+account.getAccountAccumulatedEarnings();
		//把信息加入model中
		model.addAttribute("sum",sum);//账户总额
		model.addAttribute("accountDuePrincipalAndEarnings",accountDuePrincipalAndEarnings);//待收本息
		model.addAttribute("account", account);//账户信息
		
		//回款计划
		List<ReturnPlan> returnList= planService.queryReturnList();
		model.addAttribute("returnList", returnList);
		
		//交易记录
		List<TransactionRecord> record=transactionRecordService.queryTransactionRecordByUserId(userID);
		model.addAttribute("record", record);
		
		return "userCenterIndex";
	}
}
