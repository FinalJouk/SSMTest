package com.newer.datang.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.newer.datang.data.dao.IEmployeeDao;
import com.newer.datang.data.dao.IPlanDao;
import com.newer.datang.data.dao.IRoleDao;
import com.newer.datang.data.dao.ITaskDao;
import com.newer.datang.data.entity.EmpLoyee;
import com.newer.datang.data.entity.Plan;
import com.newer.datang.data.entity.Task;
import com.newer.datang.data.util.PageBean;
import com.newer.datang.service.IManagerService;

/**
 * 主管 服务层实现类
 * 
 * @author zxl
 *
 */
public class ManagerServiceImpl implements IManagerService {
	@Resource
	ITaskDao taskDao;
	@Resource
	IPlanDao planDao;
	@Resource
	IEmployeeDao employeeDao;
	@Resource
	IRoleDao roleDao;
	
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
		return "manager/taskview.jsp";
	}

	/**
	 * 管理任务 （查询任务并查询所关联的计划）
	 */
	@Override
	public String managementTaskService(HttpServletRequest request, HttpSession session) {
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
		return "manager/taskparticular.jsp";
	}

	/**
	 * 根据计划编号查询
	 */
	@Override
	public String managerSelectPlanByIdService(HttpServletRequest request, HttpSession session) {
		Integer id = Integer.parseInt(request.getParameter("planId"));
		Plan plan = planDao.selectPlanByPlanId(id);
		request.setAttribute("plan", plan);
		return "manager/program.jsp";
	}

	/**
	 * 新增任务准备
	 */
	@Override
	public String managerInputAddTaskService(Model modle) {
		List<EmpLoyee> list = employeeDao.selectEmpForRoleIsPerson();
		modle.addAttribute("list", list);
		return "manager/task.jsp";
	}

	/**
	 * 新增任务
	 */
	@Override
	public String managementTaskService(Task task, HttpServletRequest request,HttpSession session) {
		int implementorId = Integer.parseInt(request.getParameter("implementorId"));
		EmpLoyee emp = (EmpLoyee) session.getAttribute("user");
		task.setImplementor(employeeDao.findEmployeeById(implementorId));
		task.setAssigner(emp);
		System.out.println("任务详情："+task);
		taskDao.insertTask(task);
		return "inputAddTask.do";
	}

	/**
	 * 调整任务准备
	 */
	@Override
	public String managerInputTrimTaskService(HttpServletRequest request) {
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
		return "manager/taskundone.jsp";
	}

	/**
	 * 根据ID删除任务极其关联的计划
	 */
	@Override
	public String managerDeleteTaskService(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		planDao.deletePlanByTaskId(id);
		taskDao.deleteTaskByTaskId(id);
		return "inputTrimTask.do";
	}

	/**
	 * 查看主管下辖所有人员
	 */
	@Override
	public String managerSelectAllPersonService(HttpServletRequest request,HttpSession session) {
		EmpLoyee user = (EmpLoyee) session.getAttribute("user");
		
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
		map.put("parentId",user.getEmployeeId());
		List<EmpLoyee> allEmployee =employeeDao.selectEmpLoyeeByParentId(map);
		PageBean<EmpLoyee> myPage = new PageBean<EmpLoyee>();
		myPage.setData(allEmployee);
		myPage.setTotalRecords(employeeDao.selectCountEmpLoyeeByParentId(user.getEmployeeId()));
		myPage.setPageSize(pageSize);
		myPage.setPageNo(pageNo);
		request.setAttribute("pd", myPage);
		return "manager/checkper.jsp";
	}

	/**
	 * 根据ID查询员工详细信息
	 */
	@Override
	public String managerSelectPersonDetailedByIdService(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		EmpLoyee loyee = employeeDao.findEmployeeById(id);
		request.setAttribute("loyee", loyee);
		return "manager/personinfo.jsp";
	}

	/**
	 * 查询状态为实施中的任务
	 */
	@Override
	public String managerSelectAllTaskByConditionService(HttpServletRequest request) {
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
		List<Task> allEmployee =taskDao.selectTaskInOperation(map);
		PageBean<Task> myPage = new PageBean<Task>();
		myPage.setData(allEmployee);
		myPage.setTotalRecords(taskDao.selectCountTaskInOperation());
		myPage.setPageSize(pageSize);
		myPage.setPageNo(pageNo);
		request.setAttribute("pd", myPage);
		return "manager/intendance.jsp";
	}

	/**
	 * 根据任务编号查询任务详情
	 */
	@Override
	public String managerSelectTaskByTaskIdService(HttpServletRequest request,HttpSession session) {
		int taskId;
		try {
			taskId = Integer.parseInt(request.getParameter("taskId"));
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
		return "manager/programinten.jsp";
	}

	/**
	 * 根据任务编号修改任务状态
	 */
	@Override
	public String managerUpdateTaskStatusByTaskIdService(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("taskId"));
		String status = request.getParameter("status");
		Map<String, Object> map = new HashMap<String, Object>(16);
		map.put("taskId", id);
		map.put("status", status);
		taskDao.updateTaskStutasByTaskId(map);
		return "selectAllTaskByCondition.do";
	}
}
