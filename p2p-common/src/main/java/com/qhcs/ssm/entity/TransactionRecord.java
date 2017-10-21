package com.qhcs.ssm.entity;

import java.sql.Date;

/**
 * 
* @Description: 交易记录实体类：表示账户资金所有流水，包括投资记录，充值，提现记录等
* @author wwx
* @date 2017年10月20日 上午9:45:26
 */
public class TransactionRecord extends BaseEntity{
	private static final long serialVersionUID = 1L;
	//交易记录id
    private Integer transactionRecordId;
    //用户id
    private Integer userId;
    //交易时间
    private Date transactionRecordDate;
    //交易类型
    private String transactionRecordType;
    //交易金额
    private Double transactionRecordAmount;
    //账户可用资金
    private Double transactionRecordAvailableCapital;
    //备注
    private String transactionRecordComment;

    public Integer getTransactionRecordId() {
        return transactionRecordId;
    }

    public void setTransactionRecordId(Integer transactionRecordId) {
        this.transactionRecordId = transactionRecordId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getTransactionRecordDate() {
        return transactionRecordDate;
    }

    public void setTransactionRecordDate(Date transactionRecordDate) {
        this.transactionRecordDate = transactionRecordDate;
    }

    public String getTransactionRecordType() {
        return transactionRecordType;
    }

    public void setTransactionRecordType(String transactionRecordType) {
        this.transactionRecordType = transactionRecordType == null ? null : transactionRecordType.trim();
    }

    public Double getTransactionRecordAmount() {
        return transactionRecordAmount;
    }

    public void setTransactionRecordAmount(Double transactionRecordAmount) {
        this.transactionRecordAmount = transactionRecordAmount;
    }

    public Double getTransactionRecordAvailableCapital() {
        return transactionRecordAvailableCapital;
    }

    public void setTransactionRecordAvailableCapital(Double transactionRecordAvailableCapital) {
        this.transactionRecordAvailableCapital = transactionRecordAvailableCapital;
    }

    public String getTransactionRecordComment() {
        return transactionRecordComment;
    }

    public void setTransactionRecordComment(String transactionRecordComment) {
        this.transactionRecordComment = transactionRecordComment == null ? null : transactionRecordComment.trim();
    }
}
