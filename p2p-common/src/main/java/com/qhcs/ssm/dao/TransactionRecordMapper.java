package com.qhcs.ssm.dao;

import java.util.List;

import com.qhcs.ssm.entity.TransactionRecord;

public interface TransactionRecordMapper {
	/**
	 * 
	 * @author liutianwen
	 * @desc 根据用户ID查找交易记录
	 * @parm userId 用户ID
	 * @return 返回资金交易实体类
	 */
	public List<TransactionRecord> queryTransactionRecordByUserId(int userId);
}
