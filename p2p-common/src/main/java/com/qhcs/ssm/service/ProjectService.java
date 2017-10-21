/*
 * Copyright (C) 2015 ShenZhen QiHangChuangShi Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳起航创势科技有限公司 www.qihcs.com.
 */
package com.qhcs.ssm.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qhcs.ssm.dao.ProjectMapper;
import com.qhcs.ssm.entity.BorrowMoney;
import com.qhcs.ssm.entity.Project;

/**
 * TODO:类功能介绍
 * 
 * @version 2017年9月25日下午9:56:25
 * @author
 */
@Service
public class ProjectService {

	@Autowired
	private ProjectMapper projectMapper;

	/**
	 * 
	 * TODO:查询项目集合
	 * 
	 * @version 202017年10月19日下午14:12:09
	 * @author xms
	 * @return Project
	 */
	public PageInfo<Project> getList(Project project) {
       PageHelper.startPage(project.getPageNum(), project.getPageSize());
		List<Project> projects = projectMapper.getList(project);
		//封装，把list封装成 PageInfo
		PageInfo<Project> page = new PageInfo<>(projects);
		return page;
	}

	/**
	 * 
	 * 根据ID修改项目状态
	 * 
	 * @version 2017年9月25日下午8:48:07
	 * @author xms
	 * @param project
	 *            项目信息
	 * @return 成功返回true，失败返回false
	 */
	public boolean updateStatus(Project project) {
		return projectMapper.updateStatus(project);
	}
	
	
	/**
	 * 
	 * @Description:根据项目id查询项目详细信息
	 * @author：wwx
	 * @param:项目id
	 * @return：返回项目实例
	 */
	public Project queryProjectByProjectId(Integer projectId){
		return projectMapper.queryProjectByProjectId(projectId);
	}
	
	
	/**
	 * 
	 * @Description:根据项目id查询对应的借款信息
	 * @author：wwx
	 * @param:项目id
	 * @return：借款信息实例
	 */
	public BorrowMoney queryBorrowMoneyByProjectId(Integer projectId){
		return projectMapper.queryBorrowMoneyByProjectId(projectId);
	}
}
