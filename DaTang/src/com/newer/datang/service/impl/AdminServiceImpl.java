package com.newer.datang.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.newer.datang.data.dao.IEmployeeDao;
import com.newer.datang.data.dao.IRoleDao;
import com.newer.datang.data.entity.EmpLoyee;
import com.newer.datang.data.entity.Role;
import com.newer.datang.data.util.PageBean;
import com.newer.datang.data.util.Radio;
import com.newer.datang.data.validate.RadioValidate;
import com.newer.datang.service.IAdminService;

/**
 *系统管理员服务层实现类
 * @author zxl
 *
 */
public class AdminServiceImpl implements IAdminService {
	@Resource
	IEmployeeDao employeeDao;
	@Resource
	IRoleDao roleDao;
	
	/**分页查询员工
	 * @see com.newer.datang.service.impl.IAdminService#queryEmpLoyeeForPage(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public String queryEmpLoyeeForPage(HttpServletRequest request) {
		int pageNo;
		int pageSize;
		try {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		} catch (Exception e) {
			pageNo = 1;
			pageSize = 5;
		}
		
		Map<String, Object> map = new HashMap<String, Object>(10);
		int startIndex = (pageNo - 1)*pageSize + 1;
		int endIndex = pageNo*pageSize;
		map.put("startIndex", startIndex);
		map.put("endIndex", endIndex);
		
		List<EmpLoyee> allEmployee =employeeDao.selectAllEmpLoyeeByPage(map);
		PageBean<EmpLoyee> myPage = new PageBean<EmpLoyee>();
		myPage.setData(allEmployee);
		myPage.setTotalRecords(employeeDao.selectCountForAllEmp());
		myPage.setPageSize(pageSize);
		myPage.setPageNo(pageNo);
		request.setAttribute("pd", myPage);
		return "admin/useradmin.jsp";
	}

    /**
     * 查询所有角色
     */
	@Override
	public String inputPersonService(Model model) {
	   	List<Role> allAddRoles = roleDao.selectAllRoles();
	   	allAddRoles.remove(0);
	    model.addAttribute("allAddRoles", allAddRoles);
		return "admin/personadd.jsp";
	}

	/**
	 * 新增员工
	 */
	@Override
	public String addPersonService(EmpLoyee loyee,HttpServletRequest request) {
		int roleId = Integer.parseInt(request.getParameter("roleId"));
		Role role = roleDao.selectRoleById(roleId);
		loyee.setRole(role);
	    
		int result = employeeDao.insertEmployee(loyee);
		if(result>0){
			return "selectEmpLoyeeByPage.do";
		}
		return "input_addperson.do";
	}

	/**
	 * 根据ID删除员工
	 */
	@Override
	public String deleteEmpLoyeeById(Radio radio,BindingResult result,Model model) {
		RadioValidate validate = new RadioValidate();
		validate.validate(radio, result);
		if(!result.hasErrors()){
			int id = Integer.parseInt(radio.getRadio());
			employeeDao.deleteEmpLoyeeByEmpId(id);
		}
		return "empadminQuery.do";
	}

	/**
	 * 根据分页查询所有员工 角色为4的
	 */
	@Override
	public String queryPersonForPage(HttpServletRequest request) {
		int pageNo;
		int pageSize;
		try {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		} catch (Exception e) {
			pageNo = 1;
			pageSize = 5;
		}
		
		Map<String, Object> map = new HashMap<String, Object>(10);
		int startIndex = (pageNo - 1)*pageSize + 1;
		int endIndex = pageNo*pageSize;
		map.put("startIndex", startIndex);
		map.put("endIndex", endIndex);
		
		List<EmpLoyee> allEmployee =employeeDao.selectAllEmpLoyeeByPageWhereRole(map);
		PageBean<EmpLoyee> myPage = new PageBean<EmpLoyee>();
		myPage.setData(allEmployee);
		myPage.setTotalRecords(employeeDao.selectCountForAllEmpWhereRole());
		myPage.setPageSize(pageSize);
		myPage.setPageNo(pageNo);
		request.setAttribute("pd", myPage);
		return "admin/empdistribute.jsp";
	}

	/**
	 * 查询所有角色为主管的员工
	 */
	@Override
	public String queryPersonByIdService(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("radio"));
		EmpLoyee loyee = employeeDao.findEmployeeById(id);
		System.out.println("人员详情:"+loyee);
		request.setAttribute("person", loyee);
		
		List<EmpLoyee> allEmployee = employeeDao.selectEmpForRoleIsManager();
		request.setAttribute("loyeeList", allEmployee);
		return "admin/persondesc.jsp";
	}

	/**
	 * 根据编号修改员工所属主管
	 */
	@Override
	public String updateParentByIdService(HttpServletRequest request) {
		String parentId = request.getParameter("parent");
		String loyeeId = request.getParameter("id");
		
		Map<String, Object> map = new HashMap<String, Object>(10);
		map.put("parentId", parentId);
		map.put("employeeId", loyeeId);
		employeeDao.updateEmployeeById(map);
		return "queryPersonForPage.do";
	}
}
