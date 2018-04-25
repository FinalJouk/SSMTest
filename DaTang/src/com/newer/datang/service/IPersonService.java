package com.newer.datang.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.newer.datang.data.entity.Plan;
import com.newer.datang.data.entity.PlanDTO;

/**
 * 员工 服务层接口
 * @author zxl
 *
 */
public interface IPersonService {

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
	String managementTaskService(HttpServletRequest request,HttpSession session);

	/**
	 * 根据计划ID删除计划
	 * @param request
	 * @return
	 */
	String deletePlansByIdService(HttpServletRequest request);

	/**
	 * 添加计划
	 * @param plan
	 * @param session
	 * @return
	 */
	String addPlanByTaskIdService(Plan plan, HttpSession session);

	/**
	 * 高级查询计划准备
	 * @param model
	 * @return
	 */
	String inputSelectTaskService(Model model);

	/**
	 * 高级查询计划
	 * @param model
	 * @param dto
	 * @param request
	 * @return
	 */
	String queryTaskAdvService(Model model,PlanDTO dto,HttpServletRequest request);

	/**
	 * 根据计划编号查询计划
	 * @param request
	 * @return
	 */
	String queryPlanByIdService(HttpServletRequest request);

	/**
	 * 修改计划
	 * @param plan
	 * @param request
	 * @return
	 */
	String updatePlanByIdService(Plan plan, HttpServletRequest request);

}