package com.qhcs.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qhcs.ssm.dao.AccountMapper;
import com.qhcs.ssm.entity.Account;
import com.qhcs.ssm.entity.BaseEntity;

/**
 * @author liutianwen
 * @date 2017年10月20日
 * @desc
 */
@Service
public class AccountService extends BaseEntity{
	@Autowired
	private AccountMapper accountMapper;

	/**
	 * 
	 * @author liutianwen
	 * @desc 查询冻结资金
	 * @parm userID 用户ID
	 * @return
	 */
	/*public Double queryAccountFrozenCapital(int userID) {
		return accountMapper.queryAccountFrozenCapital(userID);
	}*/
	
	//根据用户ID查找账户信息
		public Account queryAccountByUserId(int userID){
			return accountMapper.queryAccountByUserId(userID);
		}
	
}
