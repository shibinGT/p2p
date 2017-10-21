package com.qhcs.ssm.entity;

public class BankCard {
	// 自增长银行卡id
	private Integer bankCardId;
	// 银行卡号
	private String bankCardNumber;
	// 状态（1默认 0 其他卡）
	private Integer bankCardState;

	public Integer getBankCardId() {
		return bankCardId;
	}

	public void setBankCardId(Integer bankCardId) {
		this.bankCardId = bankCardId;
	}

	public String getBankCardNumber() {
		return bankCardNumber;
	}

	public void setBankCardNumber(String bankCardNumber) {
		this.bankCardNumber = bankCardNumber == null ? null : bankCardNumber.trim();
	}

	public Integer getBankCardState() {
		return bankCardState;
	}

	public void setBankCardState(Integer bankCardState) {
		this.bankCardState = bankCardState;
	}
}