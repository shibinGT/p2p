package com.qhcs.ssm.entity;

import java.util.Date;

public class RiskAssessment {

	// 风险评估ID
	private Integer riskAssessmentId;
	// 调查
	private String riskAssessmentSurvey;
	// 抵押物
	private String riskAssessmentPawn;
	// 担保
	private String riskAssessmentGuarantee;
	// 结论
	private String riskAssessmentConclusion;
	// 权证
	private String riskAssessmentWarrant;
	// 权证图
	private String riskAssessmentImg;
	// 操作人ID
	private Integer riskAssessmentEmployeeId;
	// 最后修改时间
	private Date riskAssessmentModificationTime;

	public Integer getRiskAssessmentId() {
		return riskAssessmentId;
	}

	public void setRiskAssessmentId(Integer riskAssessmentId) {
		this.riskAssessmentId = riskAssessmentId;
	}

	public String getRiskAssessmentSurvey() {
		return riskAssessmentSurvey;
	}

	public void setRiskAssessmentSurvey(String riskAssessmentSurvey) {
		this.riskAssessmentSurvey = riskAssessmentSurvey == null ? null : riskAssessmentSurvey.trim();
	}

	public String getRiskAssessmentPawn() {
		return riskAssessmentPawn;
	}

	public void setRiskAssessmentPawn(String riskAssessmentPawn) {
		this.riskAssessmentPawn = riskAssessmentPawn == null ? null : riskAssessmentPawn.trim();
	}

	public String getRiskAssessmentGuarantee() {
		return riskAssessmentGuarantee;
	}

	public void setRiskAssessmentGuarantee(String riskAssessmentGuarantee) {
		this.riskAssessmentGuarantee = riskAssessmentGuarantee == null ? null : riskAssessmentGuarantee.trim();
	}

	public String getRiskAssessmentConclusion() {
		return riskAssessmentConclusion;
	}

	public void setRiskAssessmentConclusion(String riskAssessmentConclusion) {
		this.riskAssessmentConclusion = riskAssessmentConclusion == null ? null : riskAssessmentConclusion.trim();
	}

	public String getRiskAssessmentWarrant() {
		return riskAssessmentWarrant;
	}

	public void setRiskAssessmentWarrant(String riskAssessmentWarrant) {
		this.riskAssessmentWarrant = riskAssessmentWarrant == null ? null : riskAssessmentWarrant.trim();
	}

	public String getRiskAssessmentImg() {
		return riskAssessmentImg;
	}

	public void setRiskAssessmentImg(String riskAssessmentImg) {
		this.riskAssessmentImg = riskAssessmentImg == null ? null : riskAssessmentImg.trim();
	}

	public Integer getRiskAssessmentEmployeeId() {
		return riskAssessmentEmployeeId;
	}

	public void setRiskAssessmentEmployeeId(Integer riskAssessmentEmployeeId) {
		this.riskAssessmentEmployeeId = riskAssessmentEmployeeId;
	}

	public Date getRiskAssessmentModificationTime() {
		return riskAssessmentModificationTime;
	}

	public void setRiskAssessmentModificationTime(Date riskAssessmentModificationTime) {
		this.riskAssessmentModificationTime = riskAssessmentModificationTime;
	}
}