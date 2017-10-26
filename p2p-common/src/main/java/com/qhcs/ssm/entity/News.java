package com.qhcs.ssm.entity;

import java.util.Date;

/**
 * 
 * @TODO:新闻公告类
 * @author ：shibin
 * @version:2017年10月21日
 */
public class News extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 新闻ID
	private Integer newsId;
	// 模块名称
	private String newsModuleName;
	// 新闻标题
	private String newsTitle;
	// 新闻内容
	private String newsContent;
	// 新闻图片
	private String newsImg;
	// 新闻发布时间
	private Date newsReleaseTime;
	// 新闻更新时间
	private Date newsUpdateTime;
	// 发布状态
	private Integer newsReleaseStatus;
	// 操作人ID
	private Integer newsEmployeeId;
	// 最后修改时间
	private Date newsModificationTime;
	public Integer getNewsId() {
		return newsId;
	}
	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}
	public String getNewsModuleName() {
		return newsModuleName;
	}
	public void setNewsModuleName(String newsModuleName) {
		this.newsModuleName = newsModuleName;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getNewsContent() {
		return newsContent;
	}
	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	public String getNewsImg() {
		return newsImg;
	}
	public void setNewsImg(String newsImg) {
		this.newsImg = newsImg;
	}
	public Date getNewsReleaseTime() {
		return newsReleaseTime;
	}
	public void setNewsReleaseTime(Date newsReleaseTime) {
		this.newsReleaseTime = newsReleaseTime;
	}
	public Date getNewsUpdateTime() {
		return newsUpdateTime;
	}
	public void setNewsUpdateTime(Date newsUpdateTime) {
		this.newsUpdateTime = newsUpdateTime;
	}
	public Integer getNewsReleaseStatus() {
		return newsReleaseStatus;
	}
	public void setNewsReleaseStatus(Integer newsReleaseStatus) {
		this.newsReleaseStatus = newsReleaseStatus;
	}
	public Integer getNewsEmployeeId() {
		return newsEmployeeId;
	}
	public void setNewsEmployeeId(Integer newsEmployeeId) {
		this.newsEmployeeId = newsEmployeeId;
	}
	public Date getNewsModificationTime() {
		return newsModificationTime;
	}
	public void setNewsModificationTime(Date newsModificationTime) {
		this.newsModificationTime = newsModificationTime;
	}
	public News(Integer newsId, String newsModuleName, String newsTitle, String newsContent, String newsImg,
			Date newsReleaseTime, Date newsUpdateTime, Integer newsReleaseStatus, Integer newsEmployeeId,
			Date newsModificationTime) {
		super();
		this.newsId = newsId;
		this.newsModuleName = newsModuleName;
		this.newsTitle = newsTitle;
		this.newsContent = newsContent;
		this.newsImg = newsImg;
		this.newsReleaseTime = newsReleaseTime;
		this.newsUpdateTime = newsUpdateTime;
		this.newsReleaseStatus = newsReleaseStatus;
		this.newsEmployeeId = newsEmployeeId;
		this.newsModificationTime = newsModificationTime;
	}
	public News() {
		super();
	}
	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", newsModuleName=" + newsModuleName + ", newsTitle=" + newsTitle
				+ ", newsContent=" + newsContent + ", newsImg=" + newsImg + ", newsReleaseTime=" + newsReleaseTime
				+ ", newsUpdateTime=" + newsUpdateTime + ", newsReleaseStatus=" + newsReleaseStatus
				+ ", newsEmployeeId=" + newsEmployeeId + ", newsModificationTime=" + newsModificationTime + "]";
	}

}
