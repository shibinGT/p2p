/*
 * Copyright (C) 2015 ShenZhen QiHangChuangShi Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳起航创势科技有限公司 www.qihcs.com.
 */
package com.qhcs.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qhcs.ssm.dao.ProjectMapper;
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
	public List<Project> getList(Project project) {
		return projectMapper.getList(project);
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

}
