package com.qhcs.ssm.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.qhcs.ssm.entity.Project;
import com.qhcs.ssm.entity.RegisterCount;

public interface ManagerIndexMapper {
	/**
	 * 
	 * 获取近半个月注册人数
	 * 
	 * @version 2017年10月21日下午2:27:19
	 * @author lijing
	 * @return
	 */
	public List<RegisterCount> getRegNumByDate();

	/**
	 * 
	 * 获取七天内到期的项目列表
	 * 
	 * @version 2017年10月21日下午2:27:40
	 * @author lijing
	 * @return
	 */
	public List<Project> getRepaymentList();

	/**
	 * 
	 * 查询投资的总金额
	 * 
	 * @version 2017年10月23日上午11:02:56
	 * @author lijing
	 * @return
	 */
	public Double getTotalInvestMoney();

	/**
	 * 
	 * 查询今天投资的金额
	 * 
	 * @version 2017年10月23日上午11:03:52
	 * @author lijing
	 * @return
	 */
	public Double getTodayInvestMoney();

}
