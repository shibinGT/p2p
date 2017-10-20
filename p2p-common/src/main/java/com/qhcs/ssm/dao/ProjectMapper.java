package com.qhcs.ssm.dao;

import java.util.List;

import com.qhcs.ssm.entity.Project;

/**
 * 
 * TODO:项目处理接口，实现增删改查
 * 
 * @version 2017年10月19日下午14:11:09
 * @author xms
 */
public interface ProjectMapper {
	/**
	 * 
	 * TODO:查询项目集合
	 * 
	 * @version 2017年10月19日下午15:22:07
	 * @author xms
	 * @return Project
	 */
	public List<Project> getList(Project project);

	/**
	 * 
	 * 根据ID修改项目状态
	 * 
	 * @version 2017年10月19日下午15:22:07
	 * @author
	 * @param project
	 *            项目信息
	 * @return 成功返回true，失败返回false
	 */
	public boolean updateStatus(Project project);

}
