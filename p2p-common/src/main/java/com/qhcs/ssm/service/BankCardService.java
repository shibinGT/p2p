package com.qhcs.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qhcs.ssm.dao.AccountMapper;
import com.qhcs.ssm.dao.BankCardMapper;
import com.qhcs.ssm.entity.BankCard;

@Service
public class BankCardService {

	@Autowired
	BankCardMapper bankCardMapper;
	@Autowired
	AccountMapper accountMapper;

	/**
	 * 
	 * 添加银行卡号和改变用户可用余额
	 * 
	 * @version 2017年10月21日上午11:00:45
	 * @author lizongcai
	 * @param cardNumber
	 * @return
	 */
	public boolean addBankCard(BankCard bankCard, Double updateMoney, Integer userId) {
		boolean flag = false;
		// 添加银行卡号
		flag = bankCardMapper.addBankCard(bankCard);
		// 获取银行卡号id
		int bankCardId = bankCard.getBankCardId();
		// 根据用户id修改用户可用余额
		flag = accountMapper.updateAccountByUserId(updateMoney, userId);
		// 把用户id和银行卡id传入关联表
		flag = bankCardMapper.addUserBankId(userId, bankCardId);
		return flag;
	}

}
