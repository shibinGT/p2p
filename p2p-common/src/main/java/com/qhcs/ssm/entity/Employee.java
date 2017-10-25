package com.qhcs.ssm.entity;

import java.util.List;

public class Employee extends BaseEntity {
	private static final long serialVersionUID = 1L;
	// 员工id
	private Integer employeeId;
	// 员工账号
	private String employeeAccountNumber;
	// 员工密码
	private String employeePassword;
	// 员工真实姓名
	private String employeeRealName;
	// 员工电话
	private String employeePhone;
	// 员工角色id列表
	private List<Integer> roleIds;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeAccountNumber() {
		return employeeAccountNumber;
	}

	public void setEmployeeAccountNumber(String employeeAccountNumber) {
		this.employeeAccountNumber = employeeAccountNumber == null ? null : employeeAccountNumber.trim();
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword == null ? null : employeePassword.trim();
	}

	public String getEmployeeRealName() {
		return employeeRealName;
	}

	public void setEmployeeRealName(String employeeRealName) {
		this.employeeRealName = employeeRealName == null ? null : employeeRealName.trim();
	}

	public String getEmployeePhone() {
		return employeePhone;
	}

	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}

	public List<Integer> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Integer> roleIds) {
		this.roleIds = roleIds;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeAccountNumber=" + employeeAccountNumber
				+ ", employeePassword=" + employeePassword + ", employeeRealName=" + employeeRealName
				+ ", employeePhone=" + employeePhone + ", roleIds=" + roleIds + "]";
	}

}