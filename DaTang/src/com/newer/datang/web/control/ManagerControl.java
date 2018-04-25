package com.newer.datang.web.control;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
/**
 * 主管 控制器
 * @author zxl
 *
 */
import org.springframework.web.bind.annotation.RequestMapping;

import com.newer.datang.data.entity.Task;
import com.newer.datang.service.IManagerService;
/**
 * 主管模块控制器
 * @author zxl
 *
 */
@Controller
public class ManagerControl {
	@Resource
	IManagerService managerService;

	/**
	 * 查询所有任务
	 * @param request
	 * @return
	 */
	@RequestMapping("queryAllTaskForManager.do")
	public String queryAllTask(HttpServletRequest request) {
		return managerService.queryAllTask(request);
	}
	
	/**
	 * 管理任务 （查询任务并查询所关联的计划）
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("managementTaskManager.do")
	public String  managementTaskManager(HttpServletRequest request,HttpSession session) {
		return managerService.managementTaskService(request,session);
	}
		
	/**
	 * 根据计划编号查询
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("managerSelectPlanById.do")
	public String managerSelectPlanById(HttpServletRequest request,HttpSession session){
		return managerService.managerSelectPlanByIdService(request,session);
	}
	
	/**
	 * 新增任务准备
	 * @param modle
	 * @return
	 */
	@RequestMapping("inputAddTask.do")
	public String inputAddTask(Model modle) {
		return managerService.managerInputAddTaskService(modle);
	}
	
	/**
	 * 新增任务
	 * @param task
	 * @param request
	 * @return
	 */
	@RequestMapping("addTask.do")
	public String addTask(Task task,HttpServletRequest request,HttpSession session) {
		return managerService.managementTaskService(task,request,session);
	}
	
	/**
	 * 调整任务准备
	 * @param request
	 * @return
	 */
	@RequestMapping("inputTrimTask.do")
	public String inputTrimTask(HttpServletRequest request) {
		return managerService.managerInputTrimTaskService(request);
	}
	
	/**
	 * 根据ID删除任务极其关联的计划
	 * @param request
	 * @return
	 */
	@RequestMapping("deleteTask.do")
	public String deleteTask(HttpServletRequest request) {
		return managerService.managerDeleteTaskService(request);
	}
	
	/**
	 * 查看所有人员
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("selectAllPerson.do")
	public String selectAllPerson(HttpServletRequest request,HttpSession session) {
		return managerService.managerSelectAllPersonService(request,session);
	}
	
	/**
	 * 根据ID查询员工详细信息
	 * @param request
	 * @return
	 */
	@RequestMapping("selectPersonDetailedById.do")
	public String selectPersonDetailedById(HttpServletRequest request) {
		return managerService.managerSelectPersonDetailedByIdService(request);
	}
	
	/**
	 * 查询状态为实施中的任务
	 * @param request
	 * @return
	 */
	@RequestMapping("selectAllTaskByCondition.do")
	public String selectAllTaskByCondition(HttpServletRequest request) {
		return managerService.managerSelectAllTaskByConditionService(request);
	}
	
	/**
	 * 根据任务编号查询任务详情
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("selectTaskByTaskId.do")
	public String selectTaskByTaskId(HttpServletRequest request,HttpSession session) {
		return managerService.managerSelectTaskByTaskIdService(request,session);
	}
	
	/**
	 * 根据任务编号修改任务状态
	 * @param request
	 * @return
	 */
	@RequestMapping("updateTaskStatusByTaskId.do")
	public String updateTaskStatusByTaskId(HttpServletRequest request) {
		return managerService.managerUpdateTaskStatusByTaskIdService(request);
	}
	
	
}
