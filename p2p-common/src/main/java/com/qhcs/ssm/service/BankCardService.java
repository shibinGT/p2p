package com.qhcs.ssm.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qhcs.ssm.dao.AccountMapper;
import com.qhcs.ssm.dao.BankCardMapper;
import com.qhcs.ssm.dao.TransactionRecordMapper;
import com.qhcs.ssm.entity.Account;
import com.qhcs.ssm.entity.BankCard;
import com.qhcs.ssm.entity.TransactionRecord;

@Service
public class BankCardService {

	@Autowired
	BankCardMapper bankCardMapper;
	@Autowired
	AccountMapper accountMapper;
	@Autowired
	TransactionRecordMapper transactionRecordMapper;

	/**
	 * 
	 * 根据用户id查询可用金额
	 * 
	 * @version 2017年10月22日下午1:14:37
	 * @author lizongcai
	 * @param userId
	 * @return
	 */
	public double queryAccountByUserId(Integer userId) {
		// 查询可用金额
		Account account = accountMapper.queryAccountByUserId(userId);
		// 返回可用金额
		return account.getAccountAvailableCapital();
	}

	/**
	 * 
	 * 添加银行卡号和改变用户可用余额和添加交易记录
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
		// 查询可用金额
		Account account = accountMapper.queryAccountByUserId(userId);
		// 往交易记录表添加数据
		TransactionRecord transactionRecord = new TransactionRecord();
		Date dateTime = new Date();
		transactionRecord.setUserId(userId);
		transactionRecord.setTransactionRecordDate(dateTime);
		transactionRecord.setTransactionRecordType("充值");
		transactionRecord.setTransactionRecordAmount(updateMoney);
		transactionRecord.setTransactionRecordAvailableCapital(account.getAccountAvailableCapital());
		flag = transactionRecordMapper.addSelectiveTransactionRecord(transactionRecord);
		return flag;
	}

	/**
	 * 
	 * 改变用户可用余额和添加交易记录
	 * 
	 * @version 2017年10月21日上午11:00:45
	 * @author lizongcai
	 * @param cardNumber
	 * @return
	 */
	public boolean updateAccountAddTransaction(Double updateMoney, Integer userId) {
		boolean flag = false;
		// 根据用户id修改用户可用余额
		flag = accountMapper.updateAccountByUserId(updateMoney, userId);
		// 查询可用金额
		Account account = accountMapper.queryAccountByUserId(userId);
		// 往交易记录表添加数据
		TransactionRecord transactionRecord = new TransactionRecord();
		Date dateTime = new Date();
		transactionRecord.setUserId(userId);
		transactionRecord.setTransactionRecordDate(dateTime);
		transactionRecord.setTransactionRecordType("提现");
		transactionRecord.setTransactionRecordAmount(updateMoney);
		transactionRecord.setTransactionRecordAvailableCapital(account.getAccountAvailableCapital());
		flag = transactionRecordMapper.addSelectiveTransactionRecord(transactionRecord);
		return flag;
	}

}
