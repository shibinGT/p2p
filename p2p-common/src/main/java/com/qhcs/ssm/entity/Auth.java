package com.qhcs.ssm.entity;

import java.util.List;

public class Auth extends BaseEntity {

	private static final long serialVersionUID = 1L;
	// 权限id
	private Integer authId;
	// 权限名
	private String authCode;
	// 权限描述
	private String authDesc;
	// 权限访问资源
	private String authResource;
	// 权限优先级
	private Integer authSort;
	// 权限类型
	private Integer authType;
	// id集合
	private List<Integer> ids;

	public Integer getAuthId() {
		return authId;
	}

	public void setAuthId(Integer authId) {
		this.authId = authId;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode == null ? null : authCode.trim();
	}

	public String getAuthDesc() {
		return authDesc;
	}

	public void setAuthDesc(String authDesc) {
		this.authDesc = authDesc == null ? null : authDesc.trim();
	}

	public String getAuthResource() {
		return authResource;
	}

	public void setAuthResource(String authResource) {
		this.authResource = authResource == null ? null : authResource.trim();
	}

	public Integer getAuthSort() {
		return authSort;
	}

	public void setAuthSort(Integer authSort) {
		this.authSort = authSort;
	}

	public Integer getAuthType() {
		return authType;
	}

	public void setAuthType(Integer authType) {
		this.authType = authType;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

}
