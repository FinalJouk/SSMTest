package com.newer.datang.web.control;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newer.datang.data.entity.Plan;
import com.newer.datang.data.entity.PlanDTO;
import com.newer.datang.service.IPersonService;

/***
 * 普通员工控制层
 * @author zxl
 *
 */
@Controller
public class PersonControl {
	@Resource
	IPersonService personService;
	
	/**
	 * 查询所有任务
	 * @param request
	 * @return
	 */
	@RequestMapping("queryAllTask.do")
	public String queryAllTask(HttpServletRequest request) {
		return personService.queryAllTask(request);
	}
	
	/**
	 * 管理任务 （查询任务并查询所关联的计划）
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("managementTask.do")
	public String  managementTask(HttpServletRequest request,HttpSession session) {
		return personService.managementTaskService(request,session);
	}
	
	/**
	 * 根据计划ID删除计划
	 * @param request
	 * @return
	 */
	@RequestMapping("deletePlansById.do")
	public String deletePlansById(HttpServletRequest request) {
		return personService.deletePlansByIdService(request);
	}
	
	/**
	 * 根据任务编号添加计划
	 * @param plan
	 * @param session
	 * @return
	 */
	@RequestMapping("addPlanByTaskId.do")
	public String addPlanByTaskId(Plan plan,HttpSession session) {
		return personService.addPlanByTaskIdService(plan,session);
	}
	
	/**
	 * 高级查询任务准备
	 * @param model
	 * @return
	 */
	@RequestMapping("inputSelectTask.do")
	public String inputSelectTask(Model model) {
		return personService.inputSelectTaskService(model);
	}
	
	/**
	 * 高级查询计划
	 * @param model
	 * @param dto
	 * @param request
	 * @return
	 */
	@RequestMapping("queryTaskAdv.do")
	public String queryTaskAdv(Model model , PlanDTO dto,HttpServletRequest request) {
		return personService.queryTaskAdvService(model,dto,request);
	}
	
	/**
	 * 根据计划编号查询计划
	 * @param request
	 * @return
	 */
	@RequestMapping("queryPlanById.do")
	public String queryPlanById(HttpServletRequest request) {
		return personService.queryPlanByIdService(request);
	}
	
	/**
	 * 根据计划编号修改计划
	 * @param plan
	 * @param request
	 * @return
	 */
	@RequestMapping("updatePlanById.do")
	public String updatePlanById(Plan plan,HttpServletRequest request) {
		return personService.updatePlanByIdService(plan,request);
	}
}
