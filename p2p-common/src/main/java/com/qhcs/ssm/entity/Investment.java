package com.qhcs.ssm.entity;

import java.util.Date;

/**
 * 
* @Description: 投资实体类 
* @author wwx
* @date 2017年10月19日 下午2:54:15 
*
 */
public class Investment extends BaseEntity{
	private static final long serialVersionUID = 1L;
	//投资id
    private Integer investmentId;
    //对应的投资人id
    private Integer userId;
    //投资时间
    private Date investmentDate;
    //对应的项目id
    private Integer projectId;
    //投资状态
    private Integer investmentStatus;
    //投资金额
    private Double investmentMoney;
    //投资收益
    private Double investmentEarning;

    public Integer getInvestmentId() {
        return investmentId;
    }

    public void setInvestmentId(Integer investmentId) {
        this.investmentId = investmentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getInvestmentDate() {
        return investmentDate;
    }

    public void setInvestmentDate(Date investmentDate) {
        this.investmentDate = investmentDate;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getInvestmentStatus() {
        return investmentStatus;
    }

    public void setInvestmentStatus(Integer investmentStatus) {
        this.investmentStatus = investmentStatus;
    }

    public Double getInvestmentMoney() {
        return investmentMoney;
    }

    public void setInvestmentMoney(Double investmentMoney) {
        this.investmentMoney = investmentMoney;
    }

    public Double getInvestmentEarning() {
        return investmentEarning;
    }

    public void setInvestmentEarning(Double investmentEarning) {
        this.investmentEarning = investmentEarning;
    }
}