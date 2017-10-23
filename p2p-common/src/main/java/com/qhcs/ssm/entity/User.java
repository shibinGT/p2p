package com.qhcs.ssm.entity;
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
	private Integer userId;
	// 用户名称
	@NotEmpty
	private String userName;
	// 密码
	@NotEmpty
	private String userPassword;
	//推荐人
	private String userReferrer;
	//真实姓名
	private String userRealName;
	//身份证
	private String userIdCard;
	//邮箱
	private String userEmail;
	//手机号
	private String userPhone;
	//用户状态
	private String userStatus;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserReferrer() {
		return userReferrer;
	}
	public void setUserReferrer(String userReferrer) {
		this.userReferrer = userReferrer;
	}
	public String getUserRealName() {
		return userRealName;
	}
	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}
	public String getUserIdCard() {
		return userIdCard;
	}
	public void setUserIdCard(String userIdCard) {
		this.userIdCard = userIdCard;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public User(Integer userId, String userName, String userPassword, String userReferrer, String userRealName,
			String userIdCard, String userEmail, String userPhone, String userStatus) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userReferrer = userReferrer;
		this.userRealName = userRealName;
		this.userIdCard = userIdCard;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userStatus = userStatus;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userReferrer=" + userReferrer + ", userRealName=" + userRealName + ", userIdCard=" + userIdCard
				+ ", userEmail=" + userEmail + ", userPhone=" + userPhone + ", userStatus=" + userStatus + "]";
	}
	

}
