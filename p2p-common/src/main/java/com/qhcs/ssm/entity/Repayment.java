package com.qhcs.ssm.entity;

import java.util.Date;

public class Repayment {

	// 还款表id
	private Integer repaymentId;
	// 项目id
	private Integer projectId;
	// 合约还款日期
	private Date repaymentContractDate;
	// 利息
	private Double repaymentInterest;
	// 本金
	private Double repaymentPrincipal;
	// 还款状态（0-未还款，1-分期还款中，2-还款完成）
	private Integer repaymentStatus;
	// 分期还款期数
	private Integer repaymentPeriod;
	// 本息
	private Double repaymentInterestAndPrincipal;
	// 实际还款日期
	private Date repaymentPracticalDate;
	// 最后操作员工的id
	private Integer repaymentOptatorId;
	// 最后修改操作的时间
	private Date repaymentOpetatorChangeTime;
	// 审核人的id
	private Integer repaymentAuditorId;
	// 审核时间
	private Date repaymentAuditorDate;
	// 借款人id
	private Integer userId;

	public Integer getRepaymentId() {
		return repaymentId;
	}

	public void setRepaymentId(Integer repaymentId) {
		this.repaymentId = repaymentId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Date getRepaymentContractDate() {
		return repaymentContractDate;
	}

	public void setRepaymentContractDate(Date repaymentContractDate) {
		this.repaymentContractDate = repaymentContractDate;
	}

	public Double getRepaymentInterest() {
		return repaymentInterest;
	}

	public void setRepaymentInterest(Double repaymentInterest) {
		this.repaymentInterest = repaymentInterest;
	}

	public Double getRepaymentPrincipal() {
		return repaymentPrincipal;
	}

	public void setRepaymentPrincipal(Double repaymentPrincipal) {
		this.repaymentPrincipal = repaymentPrincipal;
	}

	public Integer getRepaymentStatus() {
		return repaymentStatus;
	}

	public void setRepaymentStatus(Integer repaymentStatus) {
		this.repaymentStatus = repaymentStatus;
	}

	public Integer getRepaymentPeriod() {
		return repaymentPeriod;
	}

	public void setRepaymentPeriod(Integer repaymentPeriod) {
		this.repaymentPeriod = repaymentPeriod;
	}

	public Double getRepaymentInterestAndPrincipal() {
		return repaymentInterestAndPrincipal;
	}

	public void setRepaymentInterestAndPrincipal(Double repaymentInterestAndPrincipal) {
		this.repaymentInterestAndPrincipal = repaymentInterestAndPrincipal;
	}

	public Date getRepaymentPracticalDate() {
		return repaymentPracticalDate;
	}

	public void setRepaymentPracticalDate(Date repaymentPracticalDate) {
		this.repaymentPracticalDate = repaymentPracticalDate;
	}

	public Integer getRepaymentOptatorId() {
		return repaymentOptatorId;
	}

	public void setRepaymentOptatorId(Integer repaymentOptatorId) {
		this.repaymentOptatorId = repaymentOptatorId;
	}

	public Date getRepaymentOpetatorChangeTime() {
		return repaymentOpetatorChangeTime;
	}

	public void setRepaymentOpetatorChangeTime(Date repaymentOpetatorChangeTime) {
		this.repaymentOpetatorChangeTime = repaymentOpetatorChangeTime;
	}

	public Integer getRepaymentAuditorId() {
		return repaymentAuditorId;
	}

	public void setRepaymentAuditorId(Integer repaymentAuditorId) {
		this.repaymentAuditorId = repaymentAuditorId;
	}

	public Date getRepaymentAuditorDate() {
		return repaymentAuditorDate;
	}

	public void setRepaymentAuditorDate(Date repaymentAuditorDate) {
		this.repaymentAuditorDate = repaymentAuditorDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * 
	 * 计算还款日期与当前日期的天数
	 * 
	 * @version 2017年10月23日下午5:29:52
	 * @author lijing
	 * @return
	 */
	public int getDiffDate() {
		Date today = new Date();
		long diff = repaymentContractDate.getTime() - today.getTime();
		int diff1 = (int) (diff / (1000 * 60 * 60 * 24));
		return diff1;
	}
}