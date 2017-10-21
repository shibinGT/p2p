package com.qhcs.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.qhcs.ssm.entity.BorrowMoney;
import com.qhcs.ssm.entity.Investment;
import com.qhcs.ssm.entity.Project;
import com.qhcs.ssm.service.InvestmentService;
import com.qhcs.ssm.service.ProjectService;

/**
 * 
 * @Description: 投资模块控制层处理类
 * @author wwx
 * @date 2017年10月19日 下午6:29:59
 */
@Controller
@RequestMapping("/investment")
public class InvestmentController {
	@Autowired
	private InvestmentService investmentService;
	@Autowired
	private ProjectService projectService;

	/**
	 * 
	 * @Description:查询项目列表,从头部的"我要投资"点击进入
	 * @author：wwx
	 * @param:项目实例
	 * @return：跳转到项目列表页面
	 */
	@RequestMapping("/projectList")
	public String queryProjects(Project project, Model model) {
		// 查询项目列表
		PageInfo<Project> projects = projectService.getList(project);
		model.addAttribute("projects", projects);
		return "project-list";
	}

	/**
	 * 
	 * @Description:跳转到项目详情页面，查询项目详细信息。
	 * @author：wwx
	 * @param:projectId 项目id
	 * @return：
	 */
	@RequestMapping("/projectDetails")
	public String projectDetails(Integer projectId, Model model) {
		// 根据项目id查询项目详细信息
		if (projectId != null) {
			Project project = projectService.queryProjectByProjectId(projectId);
			model.addAttribute("project", project);
			//该项目的筹款金额(筹款总额)
			Double projectRaiseMoney=project.getProjectRaiseMoney();
			//该项目的借款期限
			Integer projectRaiseDeadline=project.getProjectRaiseDeadline();
			//该项目的年利率
			Double projectRate=project.getProjectRate();
			//算出该项目的本息(本金+本金*借款期限*利率)
			Double principalAndInterest=projectRaiseMoney+projectRaiseMoney*(projectRaiseDeadline/30*projectRate/12/12);
			//取整数部分
			Double principalAndInter=Math.floor(principalAndInterest);
			model.addAttribute("principalAndInter", principalAndInter);
			//查询该项目对应的借款信息
			BorrowMoney borrowMoney=projectService.queryBorrowMoneyByProjectId(projectId);
			model.addAttribute("borrowMoney", borrowMoney);
			//获取该项目到目前位置实际投资金额
			Double projectInvestmentMoney=borrowMoney.getBorrowMoneySum();
			//算出投标进度(该项目的实际投资金额/该项目的筹款金额)
			Double tenderSchedule=projectInvestmentMoney/projectRaiseMoney*100;
			model.addAttribute("tenderSchedule", tenderSchedule);
			//算出该项目剩余的投资金额
			Double remainingInvestmentAmount=projectRaiseMoney-projectInvestmentMoney;
			model.addAttribute("remainingInvestmentAmount", remainingInvestmentAmount);
			//根据项目id获取该项目的投资列表
			PageInfo<Investment> investments = investmentService.queryInvestmentsByProjectId(projectId);
			model.addAttribute("investments", investments);
		}
		return "project-details";
	}

}
