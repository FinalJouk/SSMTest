package com.newer.datang.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.newer.datang.data.dao.IPlanDao;
import com.newer.datang.data.dao.ITaskDao;
import com.newer.datang.data.entity.Plan;
import com.newer.datang.data.entity.PlanDTO;
import com.newer.datang.data.entity.Task;
import com.newer.datang.data.util.PageBean;
import com.newer.datang.service.IPersonService;

/**
 * 员工模块控制器
 * @author zxl
 *
 */
public class PersonServiceImpl implements IPersonService {
	@Resource
	ITaskDao taskDao;
	@Resource
	IPlanDao planDao;
	
	/**
	 * 查询所有任务  分页
	 */
	@Override
	public String queryAllTask(HttpServletRequest request) {
		int pageNo;
		int pageSize;
		try {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		} catch (Exception e) {
			pageNo = 1;
			pageSize = 5;
		}
		
		Map<String, Object> map = new HashMap<String, Object>(16);
		int startIndex = (pageNo - 1)*pageSize + 1;
		int endIndex = pageNo*pageSize;
		map.put("startIndex", startIndex);
		map.put("endIndex", endIndex);
		
		List<Task> list = taskDao.selectAllTask(map);
		PageBean<Task> myPage = new PageBean<Task>();
		myPage.setData(list);
		myPage.setTotalRecords(taskDao.selectCountByTask());
		myPage.setPageSize(pageSize);
		myPage.setPageNo(pageNo);
		request.setAttribute("pd", myPage);
		return "person/task.jsp";
	}

	/**
	 * 管理任务 （查询任务并查询所关联的计划）
	 */
	@Override
	public String managementTaskService(HttpServletRequest request,HttpSession session) {
		int taskId;
		try {
			taskId = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			Task obj = (Task) session.getAttribute("task");
			taskId = obj.getTaskId();
		}
		
		Task task = taskDao.findTaskById(taskId);
		session.setAttribute("task", task);

		int pageNo;
		int pageSize;
		try {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		} catch (Exception e) {
			pageNo = 1;
			pageSize = 5;
		}
		
		Map<String, Object> map = new HashMap<String, Object>(16);
		int startIndex = (pageNo - 1)*pageSize + 1;
		int endIndex = pageNo*pageSize;
		map.put("startIndex", startIndex);
		map.put("endIndex", endIndex);
		map.put("taskId", taskId);
		
		List<Plan> list = planDao.selectPlanByTaskIdForPage(map);
		PageBean<Plan> myPage = new PageBean<Plan>();
		myPage.setData(list);
		myPage.setTotalRecords(planDao.selectCountPlanByTaskId(taskId));
		myPage.setPageSize(pageSize);
		myPage.setPageNo(pageNo);
		request.setAttribute("pd", myPage);
		return "person/taskview.jsp";
	}

	/**
	 * 根据计划ID删除计划
	 */
	@Override
	public String deletePlansByIdService(HttpServletRequest request) {
		String[] list=request.getParameterValues("planId");
		for (int i = 0; i < list.length; i++) {
			int palnId = Integer.parseInt(list[i]);
			planDao.deletePlanByPlanId(palnId);
		}
		return "managementTask.do";
	}

	/**
	 * 添加计划
	 */
	@Override
	public String addPlanByTaskIdService(Plan plan, HttpSession session) {
		Task task = (Task)session.getAttribute("task");
		plan.setTask(task);
		int result = planDao.insertPlan(plan);
		if(result>0){
			Map<String, Object> map = new HashMap<String, Object>(16);
			map.put("status","实施中");
			map.put("taskId",task.getTaskId());
			taskDao.updateTaskStutasByTaskId(map);
		}
		return "managementTask.do";
	}

	/**
	 * 高级查询计划准备
	 */
	@Override
	public String inputSelectTaskService(Model model) {
		List<Task> tasks = taskDao.selectAllTask(null);
		model.addAttribute("tasks", tasks);
		return "person/checkpro.jsp";
	}

	/**
	 * 高级查询计划
	 */
	@Override
	public String queryTaskAdvService(Model model,PlanDTO dto,HttpServletRequest request) {
		int pageNo;
		int pageSize;
		try {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		} catch (Exception e) {
			pageNo = 1;
			pageSize = 5;
		}
		
		Map<String, Object> map = new HashMap<String, Object>(16);
		int startIndex = (pageNo - 1)*pageSize + 1;
		int endIndex = pageNo*pageSize;
		map.put("startIndex", startIndex);
		map.put("endIndex", endIndex);
		map.put("dto", dto);
		
		List<Plan> list = planDao.selectSeniorPlanForPage(map);
		PageBean<Plan> myPage = new PageBean<Plan>();
		myPage.setData(list);
		myPage.setTotalRecords(planDao.selectCountSeniorPlanForPage(dto));
		myPage.setPageSize(pageSize);
		myPage.setPageNo(pageNo);
		request.setAttribute("pd", myPage);
		
		Task superTask = taskDao.findTaskById(dto.getTaskId());
		model.addAttribute("superTask", superTask);
		
		List<Task> tasks = taskDao.selectAllTask(null);
		model.addAttribute("tasks", tasks);
		return "person/checkpro.jsp";
	}

	/**
	 * 根据计划编号查询计划
	 */
	@Override
	public String queryPlanByIdService(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Plan plan = planDao.selectPlanByPlanId(id);
		request.setAttribute("plan", plan);
		return "person/feedback.jsp";
	}

	/**
	 * 修改计划
	 */
	@Override
	public String updatePlanByIdService(Plan plan, HttpServletRequest request) {
		planDao.updatePlan(plan);
		return "inputSelectTask.do";
	}
}
