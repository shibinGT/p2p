package com.qhcs.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qhcs.ssm.dao.InvestmentMapper;
import com.qhcs.ssm.entity.BaseEntity;
import com.qhcs.ssm.entity.Investment;

/**
 * 
* @Description: 投资服务处理类
* @author wwx
* @date 2017年10月19日 下午4:41:26
 */
@Service
public class InvestmentService extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private InvestmentMapper investmentMapper;
	
	/**
	 * 
	 * @Description:添加一条投资记录
	 * @author：wwx
	 * @param: investment 投资实例
	 * @return：成功返回true
	 */
	public boolean addInvestment(Investment investment){
		return investmentMapper.addInvestment(investment);
	}
	
	/**
	 * 
	 * @Description:修改投资状态
	 * @author：wwx
	 * @param: investmentStatus 投资状态
	 * @return：成功返回true
	 */
	public boolean updateInvestmentStatus(Integer investmentStatus){
		return investmentMapper.updateInvestmentStatus(investmentStatus);
	}
	
	/**
	 * 
	 * @Description:根据投资人id查询投资记录
	 * @author：wwx
	 * @param: userId 投资人id
	 * @return：返回投资记录
	 */
	public PageInfo<Investment> queryInvestmentsByUserId(Integer userId){
    PageHelper.startPage(getPageNum(),getPageSize());
		
		List<Investment> investments = investmentMapper.queryInvestmentsByUserId(userId);
		//封装，把list封装成 PageInfo
		PageInfo<Investment> page = new PageInfo<>(investments);
		return page;
	}
	
	
	/**
	 * 
	 * @Description:根据项目id查询投资记录
	 * @author：wwx
	 * @param: projectId 项目id
	 * @return：返回投资记录
	 */
	public PageInfo<Investment> queryInvestmentsByProjectId(Integer projectId){
    PageHelper.startPage(getPageNum(),getPageSize());
		
		List<Investment> investments = investmentMapper.queryInvestmentsByUserId(projectId);
		//封装，把list封装成 PageInfo
		PageInfo<Investment> page = new PageInfo<>(investments);
		return page;
	}
	
	
	/**
	 * 
	 * @Description:根据项目id查询 该项目的投资总额
	 * @author：wwx
	 * @param:项目id
	 * @return：返回投资总额
	 */
	public Double queryTotalMoneyByProjectId(Integer projectId){
		return investmentMapper.queryTotalMoneyByProjectId(projectId);
	}

}
