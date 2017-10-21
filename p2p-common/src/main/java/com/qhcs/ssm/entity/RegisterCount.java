package com.qhcs.ssm.entity;

import java.util.Date;

/**
 * 
 * TODO:统计注册人数
 * 
 * @version 2017年10月20日下午7:03:28
 * @author lijing
 */
public class RegisterCount {

	// 注册日期
	private Date regDate;
	// 注册人数
	private Integer number;

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public RegisterCount() {
		super();
	}

	public RegisterCount(Date regDate, Integer number) {
		super();
		this.regDate = regDate;
		this.number = number;
	}

	@Override
	public String toString() {
		return "RegisterCount [regDate=" + regDate + ", number=" + number + "]";
	}

}
