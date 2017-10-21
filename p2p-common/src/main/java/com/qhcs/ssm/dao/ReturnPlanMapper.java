package com.qhcs.ssm.dao;

import java.util.List;

import com.qhcs.ssm.entity.ReturnPlan;

/**
 * @author liutianwen
 * @date  2017年10月19日
 * @desc  计划还款表
 */
public interface ReturnPlanMapper {
	//查询计划还款列表
	public List<ReturnPlan> queryReturnList();
}
