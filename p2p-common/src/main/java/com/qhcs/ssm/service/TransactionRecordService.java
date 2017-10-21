package com.qhcs.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qhcs.ssm.dao.TransactionRecordMapper;
import com.qhcs.ssm.entity.TransactionRecord;

@Service
public class TransactionRecordService {
	
	@Autowired
	private TransactionRecordMapper transactionRecordMapper;
	/**
	 * 
	 * @author liutianwen
	 * @desc 根据用户ID查找交易记录
	 * @parm userId 用户ID
	 * @return 返回资金交易实体类
	 */
	public List<TransactionRecord> queryTransactionRecordByUserId(int userId){
		return transactionRecordMapper.queryTransactionRecordByUserId(userId);
	}

}
