package com.newer.datang.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.newer.datang.data.entity.Task;

/**
 * 主管 服务层接口
 * @author zxl
 *
 */
public interface IManagerService {

	/**
	 * 查询所有任务  分页
	 * @param request
	 * @return
	 */
	String queryAllTask(HttpServletRequest request);

	/**
	 * 管理任务 （查询任务并查询所关联的计划）
	 * @param request
	 * @param session
	 * @return
	 */
	String managementTaskService(HttpServletRequest request, HttpSession session);

	/**
	 * 根据计划编号查询
	 * @param request
	 * @param session
	 * @return
	 */
	String managerSelectPlanByIdService(HttpServletRequest request, HttpSession session);

	/**
	 * 新增任务准备
	 * @param modle
	 * @return
	 */
	String managerInputAddTaskService(Model modle);

	/**
	 * 新增任务
	 * @param task
	 * @param request
	 * @return
	 */
	String managementTaskService(Task task, HttpServletRequest request,HttpSession session);

	/**
	 * 调整任务准备
	 * @param request
	 * @return
	 */
	String managerInputTrimTaskService(HttpServletRequest request);

	/**
	 * 根据ID删除任务极其关联的计划
	 * @param request
	 * @return
	 */
	String managerDeleteTaskService(HttpServletRequest request);

	/**
	 * 查看主管下辖所有人员
	 * @param request
	 * @param session
	 * @return
	 */
	String managerSelectAllPersonService(HttpServletRequest request,HttpSession session);

	/**
	 * 根据ID查询员工详细信息
	 * @param request
	 * @return
	 */
	String managerSelectPersonDetailedByIdService(HttpServletRequest request);

	/**
	 * 查询状态为实施中的任务
	 * @param request
	 * @return
	 */
	String managerSelectAllTaskByConditionService(HttpServletRequest request);

	/**
	 * 根据任务编号查询任务详情
	 * @param request
	 * @param session
	 * @return
	 */
	String managerSelectTaskByTaskIdService(HttpServletRequest request,HttpSession session);

	/**
	 * 根据任务编号修改任务状态
	 * @param request
	 * @return
	 */
	String managerUpdateTaskStatusByTaskIdService(HttpServletRequest request);

}
