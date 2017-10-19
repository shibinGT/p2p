/*
 * Copyright (C) 2015 ShenZhen QiHangChuangShi Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳起航创势科技有限公司 www.qihcs.com.
 */
package com.qhcs.ssm.entity;

import java.util.List;

/**
 * 分组的实体类
 * 
 * @version 2017年10月8日下午4:37:14
 * @author xuweiping
 */
public class Group extends BaseEntity {

	private static final long serialVersionUID = 1L;
	/**
	 * id
	 */
	private Integer groupId;
	/**
	 * 分组的编码
	 */
	private String groupCode;
	/**
	 * 分组的描述
	 */
	private String groupDesc;
	/**
	 * 分组的用户id的列表
	 */
	private List<Integer> userIds;
	/**
	 * 分组的用户名字的列表
	 */
	private List<String> userNames;
	/**
	 * 分组的角色id列表
	 */
	private List<Integer> roleIds;
	/**
	 * 分组的角色编码的列表
	 */
	private List<String> roleCodes;

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getGroupDesc() {
		return groupDesc;
	}

	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}

	public List<Integer> getUserIds() {
		return userIds;
	}

	public void setUserIds(List<Integer> userIds) {
		this.userIds = userIds;
	}

	public List<Integer> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Integer> roleIds) {
		this.roleIds = roleIds;
	}

	public List<String> getUserNames() {
		return userNames;
	}

	public void setUserNames(List<String> userNames) {
		this.userNames = userNames;
	}

	public List<String> getRoleCodes() {
		return roleCodes;
	}

	public void setRoleCodes(List<String> roleCodes) {
		this.roleCodes = roleCodes;
	}

}
