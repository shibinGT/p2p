package com.qhcs.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.qhcs.ssm.entity.Account;
import com.qhcs.ssm.entity.Investment;
import com.qhcs.ssm.entity.ReturnPlan;
import com.qhcs.ssm.entity.TransactionRecord;
import com.qhcs.ssm.entity.User;
import com.qhcs.ssm.service.AccountService;
import com.qhcs.ssm.service.InvestmentService;
import com.qhcs.ssm.service.ReturnPlanService;
import com.qhcs.ssm.service.TransactionRecordService;

/**
 * @author Administrator
 * @date 2017年10月23日
 * @desc
 * 
 */
@Controller
@RequestMapping("/user")
public class UserCenterController {

	@Autowired
	private ReturnPlanService planService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private TransactionRecordService transactionRecordService;

	@Autowired
	private InvestmentService InvestmentService;

	/**
	 * 
	 * @author liutianwen
	 * @desc 个人中心首页
	 * @parm
	 * @return 跳转到个人中心首页
	 */
	@RequestMapping("/userIndex")
	public String userCenter(Model model, HttpServletRequest request) {
		// 用户ID
		User user = (User) request.getSession().getAttribute("loginUser");
		int userID = user.getUserId();
		// int userID=11;
		// 通过用户ID查找出账户信息
		Account account = accountService.queryAccountByUserId(userID);
		// 账户总额
		Double frozen = account.getAccountFrozenCapital();// 冻结金额
		Double Available = account.getAccountAvailableCapital();// 可用金额
		Double sum = frozen + Available;// 总额
		// 待收本息
		Double accountDuePrincipalAndEarnings = account.getAccountDuePrincipal()
				+ account.getAccountAccumulatedEarnings();
		// 把信息加入model中
		model.addAttribute("sum", sum);// 账户总额
		model.addAttribute("accountDuePrincipalAndEarnings", accountDuePrincipalAndEarnings);// 待收本息
		model.addAttribute("account", account);// 账户信息

		// 回款计划
		List<ReturnPlan> returnList = planService.queryReturnList();
		model.addAttribute("returnList", returnList);

		// 资金记录
		List<TransactionRecord> record = transactionRecordService.queryTransactionRecordByUserId(userID);
		model.addAttribute("record", record);

		// 投资记录
		PageInfo<Investment> InvestmentPage = InvestmentService.queryInvestmentsByUserId(userID);
		model.addAttribute("InvestmentPage", InvestmentPage);
		return "userCenterIndex";
	}

	/**
	 * 
	 * @author liutianwen
	 * @desc 显示资金记录
	 * @parm
	 * @return 返回到资金记录页面
	 */
	@RequestMapping("/moneyRecord")
	public String MoneyRecord() {
		return "userCenter-MoneyRecord";

	}

	/**
	 * 
	 * @author liutianwen
	 * @desc 账户设置
	 * @parm
	 * @return 返回到用户设置页面
	 */
	@RequestMapping("/userSettings")
	public String userSettings() {
		return "userCenter-settings";
	}
}
