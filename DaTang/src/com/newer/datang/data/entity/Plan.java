package com.newer.datang.data.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 计划实体类
 * @author zxl
 */
public class Plan {
	/**计划编号 */
	private Integer planId;
	/**计划名称 */
	private String planName;
	/**计划状态*/
	private String status;
	/**是否反馈 */
	private String isFeedback;
	/**开始时间 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date beginDate;
	/**结束时间 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	/**引用任务 */
	private Task task;
	/**反馈信息 */
	private String feedbackInfo;
	/**计划描述 */
	private String planDesc;
	
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIsFeedback() {
		return isFeedback;
	}
	public void setIsFeedback(String isFeedback) {
		this.isFeedback = isFeedback;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public String getFeedbackInfo() {
		return feedbackInfo;
	}
	public void setFeedbackInfo(String feedbackInfo) {
		this.feedbackInfo = feedbackInfo;
	}
	public String getPlanDesc() {
		return planDesc;
	}
	public void setPlanDesc(String planDesc) {
		this.planDesc = planDesc;
	}
	public Plan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Plan(Integer planId, String planName, String status, String isFeedback, Date beginDate, Date endDate,
			Task task, String feedbackInfo, String planDesc) {
		super();
		this.planId = planId;
		this.planName = planName;
		this.status = status;
		this.isFeedback = isFeedback;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.task = task;
		this.feedbackInfo = feedbackInfo;
		this.planDesc = planDesc;
	}
	@Override
	public String toString() {
		return "Plan [planId=" + planId + ", planName=" + planName + ", status=" + status + ", isFeedback=" + isFeedback
				+ ", beginDate=" + beginDate + ", endDate=" + endDate + ", task=" + task + ", feedbackInfo="
				+ feedbackInfo + ", planDesc=" + planDesc + "]";
	}
}
