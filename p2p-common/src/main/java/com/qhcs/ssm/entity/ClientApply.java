package com.qhcs.ssm.entity;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 用户申请表
 * 
 * @author Administrator
 *
 */
public class ClientApply extends BaseEntity {
	/**
	 * 序列化号
	 */
	private static final long serialVersionUID = 1L;
	// 申请表id
	private Integer applyId;
	// 申请人真实名称
	@NotEmpty
	private String applyName;
	// 申请人电话
	// @NotEmpty
	// @Pattern(regexp = "正则")
	private String applyCall;
	// 申请金额
	// @NumberFormat(pattern = "#,###.##")
	private Double applyMoney;
	// 申请期限（单位为天）
	// @Pattern(regexp = "正则表达式,flag=标志的模式")
	private Integer applyDeadline;
	// 申请人所在地区
	@NotEmpty
	private String applyLocation;
	// 申请状态：默认为0表示没有处理；1表示处理中；2表示已完成处理
	private Integer applyStatus;
	// 提交申请时间
	private Date applyTime;
	// 最后操作员工的id
	private Integer applyOptatorId;
	// 最后修改操作的时间
	private Date applyOpetatorChangeTime;

	public Integer getApplyId() {
		return applyId;
	}

	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}

	public String getApplyName() {
		return applyName;
	}

	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}

	public String getApplyCall() {
		return applyCall;
	}

	public void setApplyCall(String applyCall) {
		this.applyCall = applyCall;
	}

	public Double getApplyMoney() {
		return applyMoney;
	}

	public void setApplyMoney(Double applyMoney) {
		this.applyMoney = applyMoney;
	}

	public Integer getApplyDeadline() {
		return applyDeadline;
	}

	public void setApplyDeadline(Integer applyDeadline) {
		this.applyDeadline = applyDeadline;
	}

	public String getApplyLocation() {
		return applyLocation;
	}

	public void setApplyLocation(String applyLocation) {
		this.applyLocation = applyLocation;
	}

	public Integer getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(Integer applyStatus) {
		this.applyStatus = applyStatus;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public Integer getApplyOptatorId() {
		return applyOptatorId;
	}

	public void setApplyOptatorId(Integer applyOptatorId) {
		this.applyOptatorId = applyOptatorId;
	}

	public Date getApplyOpetatorChangeTime() {
		return applyOpetatorChangeTime;
	}

	public void setApplyOpetatorChangeTime(Date applyOpetatorChangeTime) {
		this.applyOpetatorChangeTime = applyOpetatorChangeTime;
	}

	@Override
	public String toString() {
		return "ClientApply [applyId=" + applyId + ", applyName=" + applyName + ", applyCall=" + applyCall
				+ ", applyMoney=" + applyMoney + ", applyDeadline=" + applyDeadline + ", applyLocation=" + applyLocation
				+ ", applyStatus=" + applyStatus + ", applyTime=" + applyTime + ", applyOptatorId=" + applyOptatorId
				+ ", applyOpetatorChangeTime=" + applyOpetatorChangeTime + "]";
	}

}
