package com.qhcs.ssm.dao;
import java.util.List;


import com.qhcs.ssm.entity.TransactionRecord;

/**
 * 
* @Description: 交易记录数据库接口,实现交易记录的新增与查询
* @author wwx
* @date 2017年10月20日 上午10:09:53
 */
public interface TransactionRecordMapper {
	/**
	 * 
	 * @Description:添加一条交易记录
	 * @author：wwx
	 * @param:transactionRecord 交易记录实例
	 * @return：成功返回true
	 */
	public boolean addTransactionRecord(TransactionRecord transactionRecord);
	
	/**
	 * 
	 * @Description:动态添加添加一条交易记录
	 * @author：wwx
	 * @param:transactionRecord 交易记录实例
	 * @return：
	 */
	public boolean addSelectiveTransactionRecord(TransactionRecord transactionRecord);
	
	/**
	 * 
	 * @Description:动态查询交易记录
	 * @author：wwx
	 * @param:transactionRecord
	 * @return：
	 */
	public List<TransactionRecord> queryTransactionRecords(TransactionRecord transactionRecord);
  
    
}