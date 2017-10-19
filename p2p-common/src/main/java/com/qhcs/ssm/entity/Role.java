package com.qhcs.ssm.entity;

import java.util.List;

public class Role extends BaseEntity {

	private static final long serialVersionUID = 1L;
	// 角色id
	private Integer roleId;
	// 角色名
	private String roleCode;
	// 角色描述
	private String roleDesc;
	// 拥有权限
	private List<Integer> auths;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode == null ? null : roleCode.trim();
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc == null ? null : roleDesc.trim();
	}

	public List<Integer> getAuths() {
		return auths;
	}

	public void setAuths(List<Integer> auths) {
		this.auths = auths;
	}

}
