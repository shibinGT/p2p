package com.qhcs.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qhcs.ssm.dao.ReturnPlanMapper;
import com.qhcs.ssm.entity.ReturnPlan;
@Service
public class ReturnPlanService {
	
	@Autowired
	private ReturnPlanMapper planMapper;
	
	public List<ReturnPlan> queryReturnList(){
		return planMapper.queryReturnList();
		
	}
}
