package com.qhcs.ssm.entity;

import java.util.List;

public class Auth extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	//权限id
	private Integer id;
	//权限名
	private String authCode;
	//权限描述
	private String authDesc;
	//访问资源
	private String resource;
	//排序
	private Integer sort;
	//权限类型
	private Integer authType;
	//id集合
	private List<Integer> ids;
	public List<Integer> getIds() {
		return ids;
	}
	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	public Integer getAuthType() {
		return authType;
	}
	public void setAuthType(Integer authType) {
		this.authType = authType;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAuthCode() {
		return authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	public String getAuthDesc() {
		return authDesc;
	}
	public void setAuthDesc(String authDesc) {
		this.authDesc = authDesc;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	@Override
	public String toString() {
		return "Auth [id=" + id + ", authCode=" + authCode + ", authDesc=" + authDesc + ", resource=" + resource
				+ ", sort=" + sort + "]";
	}
	
	
	
}
