package com.qhcs.ssm.entity;

import java.util.Date;
import java.util.List;

public class Message extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// id
    private Integer messageId;
	// 消息类型（0公司公告 1个人通知）
	private Integer messageType;
	// 用户ID
    private Integer userId;
	// 消息发布时间
    private Date messageReleaseTime;
	// 消息更新时间
    private Date messageUpdateTime;
	// 消息状态(0未读 1已读)
    private Integer messageStatus;
	// 操作人ID(员工ID)
    private Integer messageEmployeeId;
	// 最后修改时间
    private Date messageModificationTime;
	// 消息内容
    private String messageContent;
	// ids
	private List<Integer> lists;

	public List<Integer> getLists() {
		return lists;
	}

	public void setLists(List<Integer> lists) {
		this.lists = lists;
	}

	public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }


	public Integer getMessageType() {
		return messageType;
	}

	public void setMessageType(Integer messageType) {
		this.messageType = messageType;
	}

	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getMessageReleaseTime() {
        return messageReleaseTime;
    }

    public void setMessageReleaseTime(Date messageReleaseTime) {
        this.messageReleaseTime = messageReleaseTime;
    }

    public Date getMessageUpdateTime() {
        return messageUpdateTime;
    }

    public void setMessageUpdateTime(Date messageUpdateTime) {
        this.messageUpdateTime = messageUpdateTime;
    }

    public Integer getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(Integer messageStatus) {
        this.messageStatus = messageStatus;
    }

    public Integer getMessageEmployeeId() {
        return messageEmployeeId;
    }

    public void setMessageEmployeeId(Integer messageEmployeeId) {
        this.messageEmployeeId = messageEmployeeId;
    }

    public Date getMessageModificationTime() {
        return messageModificationTime;
    }

    public void setMessageModificationTime(Date messageModificationTime) {
        this.messageModificationTime = messageModificationTime;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent == null ? null : messageContent.trim();
    }

}