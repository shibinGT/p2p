package com.qhcs.ssm.entity;

import java.util.Date;
import java.util.List;

public class Project extends BaseEntity {

	/**
	 * TODO
	 */
	private static final long serialVersionUID = 1L;
	// 项目表编码/id
	private Integer projectId;
	// 项目标题
	private String projectTitle;
	// 项目发行时间
	private Date projectIssueTime;
	// 项目放款时间
	private Date projectLoanTime;
	// 项目筹款金额
	private Double projectRaiseMoney;
	// 项目筹款期限
	private Integer projectRaiseDeadline;
	// 项目利率
	private Double projectRate;
	// 项目状态：默认为0
	// （0-信息录入中；1-信息录入完成；2-风控通过；3-项目发布；4-满标；5-已放款；6-还款中；7-项目完成；-1-项目失败;-2-流标
	private Integer projectStatus;
	// 最后操作员工的id
	private Integer projectOptatorId;
	// 最后修改操作的时间
	private Date projectOpetatorChangeTime;
	// 审核人的id
	private Integer projectAuditorId;
	// 审核时间
	private Date projectAuditorDate;
	// 申请
	private ClientApply clientApply;
	// 借款
	private BorrowMoney borrowMoney;
	// 投资
	private List<Investment> investments;
	// 还款记录
	private List<Repayment> repayments;
	// 风控
	private RiskAssessment riskAssessment;

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public ClientApply getClientApply() {
		return clientApply;
	}

	public void setClientApply(ClientApply clientApply) {
		this.clientApply = clientApply;
	}

	public BorrowMoney getBorrowMoney() {
		return borrowMoney;
	}

	public void setBorrowMoney(BorrowMoney borrowMoney) {
		this.borrowMoney = borrowMoney;
	}

	
	public List<Investment> getInvestments() {
		return investments;
	}

	public void setInvestments(List<Investment> investments) {
		this.investments = investments;
	}

	public List<Repayment> getRepayments() {
		return repayments;
	}

	public void setRepayments(List<Repayment> repayments) {
		this.repayments = repayments;
	}

	public RiskAssessment getRiskAssessment() { 
		return riskAssessment;
	}

	public void setRiskAssessment(RiskAssessment riskAssessment) {
		this.riskAssessment = riskAssessment;
	}

	public void setProjectStatus(Integer projectStatus) {
		this.projectStatus = projectStatus;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle == null ? null : projectTitle.trim();
	}

	public Date getProjectIssueTime() {
		return projectIssueTime;
	}

	public void setProjectIssueTime(Date projectIssueTime) {
		this.projectIssueTime = projectIssueTime;
	}

	public Date getProjectLoanTime() {
		return projectLoanTime;
	}

	public void setProjectLoanTime(Date projectLoanTime) {
		this.projectLoanTime = projectLoanTime;
	}

	public Double getProjectRaiseMoney() {
		return projectRaiseMoney;
	}

	public void setProjectRaiseMoney(Double projectRaiseMoney) {
		this.projectRaiseMoney = projectRaiseMoney;
	}

	public Integer getProjectRaiseDeadline() {
		return projectRaiseDeadline;
	}

	public void setProjectRaiseDeadline(Integer projectRaiseDeadline) {
		this.projectRaiseDeadline = projectRaiseDeadline;
	}

	public Double getProjectRate() {
		return projectRate;
	}

	public void setProjectRate(Double projectRate) {
		this.projectRate = projectRate;
	}

	public Integer getProjectStatus() {
		return projectStatus;
	}

	public void setProjectState(Integer projectStatus) {
		this.projectStatus = projectStatus;
	}

	public Integer getProjectOptatorId() {
		return projectOptatorId;
	}

	public void setProjectOptatorId(Integer projectOptatorId) {
		this.projectOptatorId = projectOptatorId;
	}

	public Date getProjectOpetatorChangeTime() {
		return projectOpetatorChangeTime;
	}

	public void setProjectOpetatorChangeTime(Date projectOpetatorChangeTime) {
		this.projectOpetatorChangeTime = projectOpetatorChangeTime;
	}

	public Integer getProjectAuditorId() {
		return projectAuditorId;
	}

	public void setProjectAuditorId(Integer projectAuditorId) {
		this.projectAuditorId = projectAuditorId;
	}

	public Date getProjectAuditorDate() {
		return projectAuditorDate;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectTitle=" + projectTitle + ", projectIssueTime="
				+ projectIssueTime + ", projectLoanTime=" + projectLoanTime + ", projectRaiseMoney=" + projectRaiseMoney
				+ ", projectRaiseDeadline=" + projectRaiseDeadline + ", projectRate=" + projectRate + ", projectStatus="
				+ projectStatus + ", projectOptatorId=" + projectOptatorId + ", projectOpetatorChangeTime="
				+ projectOpetatorChangeTime + ", projectAuditorId=" + projectAuditorId + ", projectAuditorDate="
				+ projectAuditorDate + ", clientApply=" + clientApply + ", borrowMoney=" + borrowMoney
				+ ", investments=" + investments + ", repayments=" + repayments + ", riskAssessment=" + riskAssessment
				+ "]";
	}

	public void setProjectAuditorDate(Date projectAuditorDate) {
		this.projectAuditorDate = projectAuditorDate;
	}

	/**
	 * 
	 * 计算当前日期时间和还款日期时间
	 * 
	 * @version 2017年10月21日下午6:15:19
	 * @author lijing
	 * @return
	 */
	public int getDiffDate() {
		// new date - repayment.get()
		Date today = new Date();
		long diff = repayment.getRepaymentContractDate().getTime() - today.getTime();
		int diff1 = (int) (diff / (1000 * 60 * 60 * 24));
		return diff1;
	}
}