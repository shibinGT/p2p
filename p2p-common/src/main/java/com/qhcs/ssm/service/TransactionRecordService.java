package com.qhcs.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qhcs.ssm.dao.TransactionRecordMapper;
import com.qhcs.ssm.entity.TransactionRecord;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
* @Description: 交易记录服务类 
* @author wwx
* @date 2017年10月20日 上午10:10:53
 */
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

	/**
	 * 
	 * @Description:添加一条交易记录
	 * @author：wwx
	 * @param:transactionRecord 交易记录实例
	 * @return：成功返回true
	 */
	public boolean addTransactionRecord(TransactionRecord transactionRecord){
		return transactionRecordMapper.addTransactionRecord(transactionRecord);
	}
	
	/**
	 * 
	 * @Description:动态添加添加一条交易记录
	 * @author：wwx
	 * @param:transactionRecord 交易记录实例
	 * @return：
	 */
	public boolean addSelectiveTransactionRecord(TransactionRecord transactionRecord){
		return transactionRecordMapper.addSelectiveTransactionRecord(transactionRecord);
	}
	
	/**
	 * 
	 * @Description:动态查询交易记录
	 * @author：wwx
	 * @param:transactionRecord
	 * @return：
	 */
	public PageInfo<TransactionRecord> queryTransactionRecords(TransactionRecord transactionRecord){
        PageHelper.startPage(transactionRecord.getPageNum(), transactionRecord.getPageSize());
		
		List<TransactionRecord> transactionRecords = transactionRecordMapper.queryTransactionRecords(transactionRecord);
		//封装，把list封装成 PageInfo
		PageInfo<TransactionRecord> page = new PageInfo<>(transactionRecords);
		return page;
	}
  
    
}
