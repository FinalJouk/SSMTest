package com.newer.datang.data.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 计划高级查询工具类
 * @author zxl
 *
 */
public class PlanDTO {
	/**任务编号*/
	private Integer taskId;
	/**开始时间（起始时间）*/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date beginDateBefore;
	/**开始时间（结束时间）*/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date beginDateAfter;
	/**完成时间（起始时间）*/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDateBefore;
	/**完成时间（结束时间）*/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDateAfter;
	/**是否反馈*/
	private String isFeedback;
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public Date getBeginDateBefore() {
		return beginDateBefore;
	}
	public void setBeginDateBefore(Date beginDateBefore) {
		this.beginDateBefore = beginDateBefore;
	}
	public Date getBeginDateAfter() {
		return beginDateAfter;
	}
	public void setBeginDateAfter(Date beginDateAfter) {
		this.beginDateAfter = beginDateAfter;
	}
	public Date getEndDateBefore() {
		return endDateBefore;
	}
	public void setEndDateBefore(Date endDateBefore) {
		this.endDateBefore = endDateBefore;
	}
	public Date getEndDateAfter() {
		return endDateAfter;
	}
	public void setEndDateAfter(Date endDateAfter) {
		this.endDateAfter = endDateAfter;
	}
	public String getIsFeedback() {
		return isFeedback;
	}
	public void setIsFeedback(String isFeedback) {
		this.isFeedback = isFeedback;
	}
	public PlanDTO() {
		super();
	}
	public PlanDTO(Integer taskId, Date beginDateBefore, Date beginDateAfter, Date endDateBefore, Date endDateAfter,
			String isFeedback) {
		super();
		this.taskId = taskId;
		this.beginDateBefore = beginDateBefore;
		this.beginDateAfter = beginDateAfter;
		this.endDateBefore = endDateBefore;
		this.endDateAfter = endDateAfter;
		this.isFeedback = isFeedback;
	}
	@Override
	public String toString() {
		return "PlanDTO [taskId=" + taskId + ", beginDateBefore=" + beginDateBefore + ", beginDateAfter="
				+ beginDateAfter + ", endDateBefore=" + endDateBefore + ", endDateAfter=" + endDateAfter
				+ ", isFeedback=" + isFeedback + "]";
	}
}
