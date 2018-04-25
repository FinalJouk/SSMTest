package com.newer.datang.data.entity;

import java.util.Date;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 员工 实体类
 * @author zxl
 */
public class EmpLoyee {
	/** 员工编号 */
	private Integer employeeId;
	/**用户名称*/
	@NotEmpty
	private String employeeName;
	/**密码*/
	@NotEmpty
	private String password;
	/**真实姓名*/
	private String realName;
	/**性别*/
	private String sex;
	/**出生年月*/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthDay;
	/**职位信息*/
	private String duty;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	/**入职时间*/
	private Date endrolldDate;
	/**学历信息*/
	private String education;
	/**专业信息*/
	private String major;
	/**行业经验*/
	private String experience;
	/**外键，所属角色，引用角色编号*/
	private Role role;
	/**外键，主管，引用员工编号*/
	private EmpLoyee parent;
	
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public Date getEndrolldDate() {
		return endrolldDate;
	}
	public void setEndrolldDate(Date endrolldDate) {
		this.endrolldDate = endrolldDate;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public EmpLoyee getParent() {
		return parent;
	}
	public void setParent(EmpLoyee parent) {
		this.parent = parent;
	}
	public EmpLoyee(Integer employeeId, String employeeName, String password, String realName, String sex,
			Date birthDay, String duty, Date endrolldDate, String education, String major, String experience, Role role,
			EmpLoyee parent) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.password = password;
		this.realName = realName;
		this.sex = sex;
		this.birthDay = birthDay;
		this.duty = duty;
		this.endrolldDate = endrolldDate;
		this.education = education;
		this.major = major;
		this.experience = experience;
		this.role = role;
		this.parent = parent;
	}
	public EmpLoyee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EmpLoyee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", password=" + password
				+ ", realName=" + realName + ", sex=" + sex + ", birthDay=" + birthDay + ", duty=" + duty
				+ ", endrolldDate=" + endrolldDate + ", education=" + education + ", major=" + major + ", experience="
				+ experience + ", role=" + role + ", parent=" + parent + "]";
	}
}
