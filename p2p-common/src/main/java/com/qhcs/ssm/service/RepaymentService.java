package com.qhcs.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.qhcs.ssm.dao.RepaymentMapper;
import com.qhcs.ssm.entity.Repayment;

/**
 * 
* @Description: 还款表对应的service
* @author wwx
* @date 2017年10月21日 下午12:36:28
 */
public class RepaymentService {
	@Autowired
	private RepaymentMapper repaymentMapper;
	public List<Repayment> queryRepaymentsByProjectId(Integer projectId){
		return repaymentMapper.queryRepaymentsByProjectId(projectId);
	}

}
