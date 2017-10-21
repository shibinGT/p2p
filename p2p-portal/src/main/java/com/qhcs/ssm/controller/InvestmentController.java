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
 * @Description: Ͷ��ģ����Ʋ㴦����
 * @author wwx
 * @date 2017��10��19�� ����6:29:59
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
	 * @Description:��ѯ��Ŀ�б�,��ͷ����"��ҪͶ��"�������
	 * @author��wwx
	 * @param:��Ŀʵ��
	 * @return����ת����Ŀ�б�ҳ��
	 */
	@RequestMapping("/projectList")
	public String queryProjects(Project project, Model model) {
		// ��ѯ��Ŀ�б�
		PageInfo<Project> projects = projectService.getList(project);
		model.addAttribute("projects", projects);
		return "project-list";
	}

	/**
	 * 
	 * @Description:��ת����Ŀ����ҳ�棬��ѯ��Ŀ��ϸ��Ϣ��
	 * @author��wwx
	 * @param:projectId ��Ŀid
	 * @return��
	 */
	@RequestMapping("/projectDetails")
	public String projectDetails(Integer projectId, Model model) {
		// ������Ŀid��ѯ��Ŀ��ϸ��Ϣ
		if (projectId != null) {
			Project project = projectService.queryProjectByProjectId(projectId);
			model.addAttribute("project", project);
			//����Ŀ�ĳ����(����ܶ�)
			Double projectRaiseMoney=project.getProjectRaiseMoney();
			//����Ŀ�Ľ������
			Integer projectRaiseDeadline=project.getProjectRaiseDeadline();
			//����Ŀ��������
			Double projectRate=project.getProjectRate();
			//�������Ŀ�ı�Ϣ(����+����*�������*����)
			Double principalAndInterest=projectRaiseMoney+projectRaiseMoney*(projectRaiseDeadline/30*projectRate/12/12);
			//ȡ��������
			Double principalAndInter=Math.floor(principalAndInterest);
			model.addAttribute("principalAndInter", principalAndInter);
			//��ѯ����Ŀ��Ӧ�Ľ����Ϣ
			BorrowMoney borrowMoney=projectService.queryBorrowMoneyByProjectId(projectId);
			model.addAttribute("borrowMoney", borrowMoney);
			//��ȡ����Ŀ��Ŀǰλ��ʵ��Ͷ�ʽ��
			Double projectInvestmentMoney=borrowMoney.getBorrowMoneySum();
			//���Ͷ�����(����Ŀ��ʵ��Ͷ�ʽ��/����Ŀ�ĳ����)
			Double tenderSchedule=projectInvestmentMoney/projectRaiseMoney*100;
			model.addAttribute("tenderSchedule", tenderSchedule);
			//�������Ŀʣ���Ͷ�ʽ��
			Double remainingInvestmentAmount=projectRaiseMoney-projectInvestmentMoney;
			model.addAttribute("remainingInvestmentAmount", remainingInvestmentAmount);
			//������Ŀid��ȡ����Ŀ��Ͷ���б�
			PageInfo<Investment> investments = investmentService.queryInvestmentsByProjectId(projectId);
			model.addAttribute("investments", investments);
		}
		return "project-details";
	}

}
