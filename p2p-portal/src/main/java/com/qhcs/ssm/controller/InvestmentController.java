package com.qhcs.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @RequestMapping("/projectList")
    public String queryProjects(Project project){
    	
    	return "project-list";
    }
    
}
