package com.qhcs.ssm.dao;

import java.util.List;

import com.qhcs.ssm.entity.Repayment;

/**
 * 
* @Description:还款表对应的dao 
* @author wwx
* @date 2017年10月21日 下午12:35:04
 */
public interface RepaymentMapper {
  
	/**
	 * 
	 * @Description:根据项目id从还款表中查询对应的还款信息集合
	 * @author：wwx
	 * @param:项目id
	 * @return：返回还款信息集合
	 */
	public List<Repayment> queryRepaymentsByProjectId(Integer projectId);
	
}
