package com.qhcs.ssm.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 *@TODO:红包类
 * @author ：shibin
 *@version:2017年10月20日
 */
public class RedPacket extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//红包ID
	private Integer redPacketId;
	//红包管理ID
	private Integer redPacketManageId;
	//用户ID
	private Integer userId;
	//领取日期
	
	private Date redPacketGetDate;
	//兑换日期
	
	private Date redPacketExchangeDate;
	//领取状态 0未兑换 1已换 2使用 3过期
	private Integer redPacketStatus;
	//兑换码
    private String redPacketExchangeCode;
	public Integer getRedPacketId() {
		return redPacketId;
	}
	public void setRedPacketId(Integer redPacketId) {
		this.redPacketId = redPacketId;
	}
	public Integer getRedPacketManageId() {
		return redPacketManageId;
	}
	public void setRedPacketManageId(Integer redPacketManageId) {
		this.redPacketManageId = redPacketManageId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Date getRedPacketGetDate() {
		return redPacketGetDate;
	}
	public void setRedPacketGetDate(Date redPacketGetDate) {
		this.redPacketGetDate = redPacketGetDate;
	}
	public Date getRedPacketExchangeDate() {
		return redPacketExchangeDate;
	}
	public void setRedPacketExchangeDate(Date redPacketExchangeDate) {
		this.redPacketExchangeDate = redPacketExchangeDate;
	}
	public Integer getRedPacketStatus() {
		return redPacketStatus;
	}
	public void setRedPacketStatus(Integer redPacketStatus) {
		this.redPacketStatus = redPacketStatus;
	}
	public String getRedPacketExchangeCode() {
		return redPacketExchangeCode;
	}
	public void setRedPacketExchangeCode(String redPacketExchangeCode) {
		this.redPacketExchangeCode = redPacketExchangeCode;
	}
	public RedPacket(Integer redPacketId, Integer redPacketManageId, Integer userId, Date redPacketGetDate,
			Date redPacketExchangeDate, Integer redPacketStatus, String redPacketExchangeCode) {
		super();
		this.redPacketId = redPacketId;
		this.redPacketManageId = redPacketManageId;
		this.userId = userId;
		this.redPacketGetDate = redPacketGetDate;
		this.redPacketExchangeDate = redPacketExchangeDate;
		this.redPacketStatus = redPacketStatus;
		this.redPacketExchangeCode = redPacketExchangeCode;
	}
	public RedPacket() {
		super();
	}
	@Override
	public String toString() {
		return "RedPacket [redPacketId=" + redPacketId + ", redPacketManageId=" + redPacketManageId + ", userId="
				+ userId + ", redPacketGetDate=" + redPacketGetDate + ", redPacketExchangeDate=" + redPacketExchangeDate
				+ ", redPacketStatus=" + redPacketStatus + ", redPacketExchangeCode=" + redPacketExchangeCode + "]";
	}
    
}
