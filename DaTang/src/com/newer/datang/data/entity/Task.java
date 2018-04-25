package com.newer.datang.data.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 任务实体类
 * @author zxl
 */
public class Task {
	/**任务编号*/
	private Integer taskId;
	/**任务名称*/
	private String taskName;
	/**开始时间*/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date beginDate;
	/**结束时间*/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	/**实际开始时间*/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date realBeginDate;
	/**实际结束时间*/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date realEndDate;
	/**任务状态*/
	private String status;
	/**实施人*/
	private EmpLoyee implementor;
	/**分配人*/
	private EmpLoyee assigner;
	/**任务描述*/
	private String taskDesc;
	/**关联的计划集合*/
	private Integer planCount;
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
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
	public Date getRealBeginDate() {
		return realBeginDate;
	}
	public void setRealBeginDate(Date realBeginDate) {
		this.realBeginDate = realBeginDate;
	}
	public Date getRealEndDate() {
		return realEndDate;
	}
	public void setRealEndDate(Date realEndDate) {
		this.realEndDate = realEndDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public EmpLoyee getImplementor() {
		return implementor;
	}
	public void setImplementor(EmpLoyee implementor) {
		this.implementor = implementor;
	}
	public EmpLoyee getAssigner() {
		return assigner;
	}
	public void setAssigner(EmpLoyee assigner) {
		this.assigner = assigner;
	}
	public String getTaskDesc() {
		return taskDesc;
	}
	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}
	public Integer getPlanCount() {
		return planCount;
	}
	public void setPlanCount(Integer planCount) {
		this.planCount = planCount;
	}
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Task(Integer taskId, String taskName, Date beginDate, Date endDate, Date realBeginDate, Date realEndDate,
			String status, EmpLoyee implementor, EmpLoyee assigner, String taskDesc, Integer planCount) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.realBeginDate = realBeginDate;
		this.realEndDate = realEndDate;
		this.status = status;
		this.implementor = implementor;
		this.assigner = assigner;
		this.taskDesc = taskDesc;
		this.planCount = planCount;
	}
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", beginDate=" + beginDate + ", endDate=" + endDate
				+ ", realBeginDate=" + realBeginDate + ", realEndDate=" + realEndDate + ", status=" + status
				+ ", implementor=" + implementor + ", assigner=" + assigner + ", taskDesc=" + taskDesc + ", planCount="
				+ planCount + "]";
	}
}
