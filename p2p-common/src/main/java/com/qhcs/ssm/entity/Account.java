package com.qhcs.ssm.entity;

/**
 * @author liutianwen
 * @date 2017年10月20日
 * @desc 账户实体类
 */

public class Account extends BaseEntity {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	// 用户ID
	private Integer UserId;
	// 冻结资金
	private Double accountFrozenCapital;
	// 可用资金
	private Double accountAvailableCapital;
	// 待回款利息
	private Double accountDueInterest;
	// 待回款本金
	private Double accountDuePrincipal;
	// 累计收益
	private Double accountAccumulatedEarnings;

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
		UserId = userId;
	}

	public Double getAccountFrozenCapital() {
		return accountFrozenCapital;
	}

	public void setAccountFrozenCapital(Double accountFrozenCapital) {
		this.accountFrozenCapital = accountFrozenCapital;
	}

	public Double getAccountAvailableCapital() {
		return accountAvailableCapital;
	}

	public void setAccountAvailableCapital(Double accountAvailableCapital) {
		this.accountAvailableCapital = accountAvailableCapital;
	}

	public Double getAccountDueInterest() {
		return accountDueInterest;
	}

	public void setAccountDueInterest(Double accountDueInterest) {
		this.accountDueInterest = accountDueInterest;
	}

	public Double getAccountDuePrincipal() {
		return accountDuePrincipal;
	}

	public void setAccountDuePrincipal(Double accountDuePrincipal) {
		this.accountDuePrincipal = accountDuePrincipal;
	}

	public Double getAccountAccumulatedEarnings() {
		return accountAccumulatedEarnings;
	}

	public void setAccountAccumulatedEarnings(Double accountAccumulatedEarnings) {
		this.accountAccumulatedEarnings = accountAccumulatedEarnings;
	}

	@Override
	public String toString() {
		return "Account [UserId=" + UserId + ", accountFrozenCapital=" + accountFrozenCapital
				+ ", accountAvailableCapital=" + accountAvailableCapital + ", accountDueInterest=" + accountDueInterest
				+ ", accountDuePrincipal=" + accountDuePrincipal + ", accountAccumulatedEarnings="
				+ accountAccumulatedEarnings + "]";
	}

}
