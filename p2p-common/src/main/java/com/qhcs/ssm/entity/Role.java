package com.qhcs.ssm.entity;

import java.util.List;

public class Role extends BaseEntity {

	private static final long serialVersionUID = 1L;
	// 角色id
	private Integer id;

	// 角色编码
	private String roleCode;
	// 角色描述
	private String roleDesc;
	// 拥有权限
	private List<Integer> auths;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public List<Integer> getAuths() {
		return auths;
	}

	public void setAuths(List<Integer> auths) {
		this.auths = auths;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", roleCode=" + roleCode + ", roleDesc=" + roleDesc + ", auths=" + auths + "]";
	}

}
