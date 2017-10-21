package com.qhcs.ssm.entity;

import java.sql.Date;

/**
 * 
 * @author Administrator
 * @date 2017年10月20日
 * @desc 交易记录
 * 
 */
public class TransactionRecord extends BaseEntity{

	// 用户ID
	private Integer userId;
	// 交易时间
	private Date transactionRecordDate;
	// 交易类型
	private String transactionRecordType;
	// 交易金额
	private Double transactionRecordAmount;
	// 账户可用资金
	private Double transactionRecordAvailableCapital;
	// 备注
	private String transactionRecordComment;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getTransactionRecordDate() {
		return transactionRecordDate;
	}

	public void setTransactionRecordDate(Date transactionRecordDate) {
		this.transactionRecordDate = transactionRecordDate;
	}

	public String getTransactionRecordType() {
		return transactionRecordType;
	}

	public void setTransactionRecordType(String transactionRecordType) {
		this.transactionRecordType = transactionRecordType;
	}

	public Double getTransactionRecordAmount() {
		return transactionRecordAmount;
	}

	public void setTransactionRecordAmount(Double transactionRecordAmount) {
		this.transactionRecordAmount = transactionRecordAmount;
	}

	public Double getTransactionRecordAvailableCapital() {
		return transactionRecordAvailableCapital;
	}

	public void setTransactionRecordAvailableCapital(Double transactionRecordAvailableCapital) {
		this.transactionRecordAvailableCapital = transactionRecordAvailableCapital;
	}

	public String getTransactionRecordComment() {
		return transactionRecordComment;
	}

	public void setTransactionRecordComment(String transactionRecordComment) {
		this.transactionRecordComment = transactionRecordComment;
	}

	@Override
	public String toString() {
		return "TransactionRecord [userId=" + userId + ", transactionRecordDate=" + transactionRecordDate
				+ ", transactionRecordType=" + transactionRecordType + ", transactionRecordAmount="
				+ transactionRecordAmount + ", transactionRecordAvailableCapital=" + transactionRecordAvailableCapital
				+ ", transactionRecordComment=" + transactionRecordComment + "]";
	}

}
