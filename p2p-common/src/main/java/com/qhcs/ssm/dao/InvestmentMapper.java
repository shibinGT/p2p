package com.qhcs.ssm.dao;

import java.util.List;

import com.qhcs.ssm.entity.Investment;

/**
 * 
* @Description:投资处理接口,实现投资相关的数据库操作 
* @author wwx
* @date 2017年10月19日 下午3:44:19
 */
public interface InvestmentMapper {
	/**
	 * 
	 * @Description:添加一条投资记录
	 * @author：wwx
	 * @param: investment 投资实例
	 * @return：成功返回true
	 */
	public boolean addInvestment(Investment investment);
	
	/**
	 * 
	 * @Description:修改投资状态
	 * @author：wwx
	 * @param: investmentStatus 投资状态
	 * @return：成功返回true
	 */
	public boolean updateInvestmentStatus(Integer investmentStatus);
    
	/**
	 * 
	 * @Description:根据投资人id查询投资记录
	 * @author：wwx
	 * @param: userId 投资人id
	 * @return：返回投资记录
	 */
	public List<Investment> queryInvestmentsByUserId(Integer userId);
	
	/**
	 * 
	 * @Description:根据项目id查询投资记录
	 * @author：wwx
	 * @param: userId 投资人id
	 * @return：返回投资记录
	 */
	public List<Investment> queryInvestmentsByProjectId(Integer projectId);
	
	/**
	 * 
	 * @Description:根据项目id查询 该项目的投资总额
	 * @author：wwx
	 * @param:项目id
	 * @return：返回投资总额
	 */
	public Double queryTotalMoneyByProjectId(Integer projectId);
}
