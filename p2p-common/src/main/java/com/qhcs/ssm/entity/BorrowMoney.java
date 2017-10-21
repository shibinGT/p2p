package com.qhcs.ssm.entity;

import java.util.Date;

public class BorrowMoney {

	// 借款表id
	private Integer borrowMoneyId;
	// 借款人id (用户ID)
	private Integer userId;
	// 借款信息介绍
	private String borrowMoneyMessage;
	// 借款人工作状况
	private String borrowMoneyWork;
	// 借款类型（0-到期返还本息、1-按月返还本息、2-等额本息）
	private Integer borrowMoneyType;
	// 详细资金用途
	private String borrowMoneyUse;
	// 实际借款金额
	private Double borrowMoneySum;
	// 借款抵押资产
	private String borrowMoneyAsset;
	// 借款用途类型（0-车易贷；2-房易贷；3-赎楼贷；4-债权贷
	private Integer borrowMoneyUseType;
	// 借款日
	private Date borrowMoneyDate;
	// 借款期限
	private Date borrowMoneyDeadline;
	// 最后操作员工的id
	private Integer borrowMoneyOptatorId;
	// 最后修改操作的时间
	private Date borrowMoneyOpetatorChangeTime;
	// 审核人的id
	private Integer borrowMoneyAuditorId;
	// 审核时间
	private Date borrowMoneyAuditorDate;

	public Integer getBorrowMoneyId() {
		return borrowMoneyId;
	}

	public void setBorrowMoneyId(Integer borrowMoneyId) {
		this.borrowMoneyId = borrowMoneyId;
	}

	public Integer getUserId() {
		return userId;
	}

	public Integer getBorrowMoneyUseType() {
		return borrowMoneyUseType;
	}

	public void setBorrowMoneyUseType(Integer borrowMoneyUseType) {
		this.borrowMoneyUseType = borrowMoneyUseType;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getBorrowMoneyMessage() {
		return borrowMoneyMessage;
	}

	public void setBorrowMoneyMessage(String borrowMoneyMessage) {
		this.borrowMoneyMessage = borrowMoneyMessage == null ? null : borrowMoneyMessage.trim();
	}

	public String getBorrowMoneyWork() {
		return borrowMoneyWork;
	}

	public void setBorrowMoneyWork(String borrowMoneyWork) {
		this.borrowMoneyWork = borrowMoneyWork == null ? null : borrowMoneyWork.trim();
	}

	public Integer getBorrowMoneyType() {
		return borrowMoneyType;
	}

	public void setBorrowMoneyType(Integer borrowMoneyType) {
		this.borrowMoneyType = borrowMoneyType;
	}

	public String getBorrowMoneyUse() {
		return borrowMoneyUse;
	}

	public void setBorrowMoneyUse(String borrowMoneyUse) {
		this.borrowMoneyUse = borrowMoneyUse == null ? null : borrowMoneyUse.trim();
	}

	public Double getBorrowMoneySum() {
		return borrowMoneySum;
	}

	public void setBorrowMoneySum(Double borrowMoneySum) {
		this.borrowMoneySum = borrowMoneySum;
	}

	public String getBorrowMoneyAsset() {
		return borrowMoneyAsset;
	}

	public void setBorrowMoneyAsset(String borrowMoneyAsset) {
		this.borrowMoneyAsset = borrowMoneyAsset == null ? null : borrowMoneyAsset.trim();
	}

	public Date getBorrowMoneyDate() {
		return borrowMoneyDate;
	}

	public void setBorrowMoneyDate(Date borrowMoneyDate) {
		this.borrowMoneyDate = borrowMoneyDate;
	}

	public Date getBorrowMoneyDeadline() {
		return borrowMoneyDeadline;
	}

	public void setBorrowMoneyDeadline(Date borrowMoneyDeadline) {
		this.borrowMoneyDeadline = borrowMoneyDeadline;
	}

	public Integer getBorrowMoneyOptatorId() {
		return borrowMoneyOptatorId;
	}

	public void setBorrowMoneyOptatorId(Integer borrowMoneyOptatorId) {
		this.borrowMoneyOptatorId = borrowMoneyOptatorId;
	}

	public Date getBorrowMoneyOpetatorChangeTime() {
		return borrowMoneyOpetatorChangeTime;
	}

	public void setBorrowMoneyOpetatorChangeTime(Date borrowMoneyOpetatorChangeTime) {
		this.borrowMoneyOpetatorChangeTime = borrowMoneyOpetatorChangeTime;
	}

	public Integer getBorrowMoneyAuditorId() {
		return borrowMoneyAuditorId;
	}

	public void setBorrowMoneyAuditorId(Integer borrowMoneyAuditorId) {
		this.borrowMoneyAuditorId = borrowMoneyAuditorId;
	}

	public Date getBorrowMoneyAuditorDate() {
		return borrowMoneyAuditorDate;
	}

	public void setBorrowMoneyAuditorDate(Date borrowMoneyAuditorDate) {
		this.borrowMoneyAuditorDate = borrowMoneyAuditorDate;
	}

	@Override
	public String toString() {
		return "BorrowMoney [borrowMoneyId=" + borrowMoneyId + ", userId=" + userId + ", borrowMoneyMessage="
				+ borrowMoneyMessage + ", borrowMoneyWork=" + borrowMoneyWork + ", borrowMoneyType=" + borrowMoneyType
				+ ", borrowMoneyUse=" + borrowMoneyUse + ", borrowMoneySum=" + borrowMoneySum + ", borrowMoneyAsset="
				+ borrowMoneyAsset + ", borrowMoneyUseType=" + borrowMoneyUseType + ", borrowMoneyDate="
				+ borrowMoneyDate + ", borrowMoneyDeadline=" + borrowMoneyDeadline + ", borrowMoneyOptatorId="
				+ borrowMoneyOptatorId + ", borrowMoneyOpetatorChangeTime=" + borrowMoneyOpetatorChangeTime
				+ ", borrowMoneyAuditorId=" + borrowMoneyAuditorId + ", borrowMoneyAuditorDate="
				+ borrowMoneyAuditorDate + "]";
	}
	
}