package com.qhcs.ssm.entity;

import java.sql.Date;

/**
 * @author liutianwen
 * @date 2017年10月19日
 * @desc 回款计划实体类
 */
public class ReturnPlan extends BaseEntity {
	// 投资人ID
	private Integer userID;
	// 项目ID
	private Integer projectId;
	// 合约还款日期
	private Date returnedMoneyContractDate;
	// 实际还款日期
	private Date returnedMoneyPracticalDate;
	// 回款日期
	private Double returnedMoneyMoney;
	// 回款状态
	private String returnedMoneyStatus;

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Date getReturnedMoneyContractDate() {
		return returnedMoneyContractDate;
	}

	public void setReturnedMoneyContractDate(Date returnedMoneyContractDate) {
		this.returnedMoneyContractDate = returnedMoneyContractDate;
	}

	public Date getReturnedMoneyPracticalDate() {
		return returnedMoneyPracticalDate;
	}

	public void setReturnedMoneyPracticalDate(Date returnedMoneyPracticalDate) {
		this.returnedMoneyPracticalDate = returnedMoneyPracticalDate;
	}

	public String getReturnedMoneyStatus() {
		return returnedMoneyStatus;
	}

	public void setReturnedMoneyStatus(String returnedMoneyStatus) {
		this.returnedMoneyStatus = returnedMoneyStatus;
	}

	public Double getReturnedMoneyMoney() {
		return returnedMoneyMoney;
	}

	public void setReturnedMoneyMoney(Double returnedMoneyMoney) {
		this.returnedMoneyMoney = returnedMoneyMoney;
	}

	@Override
	public String toString() {
		return "ReturnPlan [userID=" + userID + ", projectId=" + projectId + ", returnedMoneyContractDate="
				+ returnedMoneyContractDate + ", returnedMoneyPracticalDate=" + returnedMoneyPracticalDate
				+ ", returnedMoneyMoney=" + returnedMoneyMoney + ", returnedMoneyStatus=" + returnedMoneyStatus + "]";
	}

}
