package com.qhcs.ssm.entity;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 用户对象实体类
 * 
 * @author YI
 *
 */
public class User extends BaseEntity {
	/**
	 * TODO
	 */
	private static final long serialVersionUID = 1L;
	// 主键
	private Integer id;
	// 用户名称
	@NotEmpty
	private String name;
	// 密码
	@NotEmpty
	private String password;

	// 拥有角色
	private List<Integer> roleid;

	public List<Integer> getRoleid() {
		return roleid;
	}

	public void setRoleid(List<Integer> roleid) {
		this.roleid = roleid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", roleid=" + roleid + "]";
	}

}
