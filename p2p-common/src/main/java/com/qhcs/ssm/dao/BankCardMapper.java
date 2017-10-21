package com.qhcs.ssm.dao;

import org.apache.ibatis.annotations.Param;

import com.qhcs.ssm.entity.BankCard;

/**
 * @author liutianwen
 * @date 2017年10月20日
 * @desc 账户DAO层
 */
public interface BankCardMapper {

	/**
	 * 
	 * 添加银行卡号
	 * 
	 * @version 2017年10月21日上午11:00:45
	 * @author lizongcai
	 * @param cardNumber
	 * @return
	 */
	public boolean addBankCard(BankCard bankCard);

	/**
	 * 
	 * 添加银行卡id和用户id
	 * 
	 * @version 2017年10月21日上午11:58:41
	 * @author lizongcai
	 * @param userId
	 * @param BankId
	 * @return
	 */
	public boolean addUserBankId(@Param("userId") Integer userId, @Param("BankId") Integer BankId);
}
