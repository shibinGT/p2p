package com.qhcs.ssm.dao;

import org.apache.ibatis.annotations.Param;

import com.qhcs.ssm.entity.Account;

/**
 * @author liutianwen
 * @date 2017年10月20日
 * @desc 账户DAO层
 */
public interface AccountMapper {

	// 根据用户ID查找账户信息
	public Account queryAccountByUserId(int userId);

	// 根据用户ID修改可用资金
	public boolean updateAccountByUserId(@Param("updateMoney") Double updateMoney, @Param("userId") Integer userId);
}
