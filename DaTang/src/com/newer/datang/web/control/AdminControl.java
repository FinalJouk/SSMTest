package com.newer.datang.web.control;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newer.datang.data.dao.IRoleDao;
import com.newer.datang.data.entity.EmpLoyee;
import com.newer.datang.data.util.Radio;
import com.newer.datang.service.IAdminService;

/**
 * 系统管理员控制器
 * @author zxl
 *
 */
@Controller
public class AdminControl {
	
	@Resource
	IAdminService adminService;
	@Resource
	IRoleDao roleDao;
	
	/**
	 * 查询所有员工记录
	 * @param request
	 * @return
	 */
	@RequestMapping("selectEmpLoyeeByPage.do")
	public String queryEmpLoyeeByPage(HttpServletRequest request) {
		return adminService.queryEmpLoyeeForPage(request);
	}
	
	@RequestMapping("input_addperson.do")
	public String inputAddPerson(Model model) {
		return adminService.inputPersonService(model);
	}
	
	/**
	 * 添加员工
	 * @param loyee
	 * @param request
	 * @return
	 */
	@RequestMapping("addPerson.do")
	public String addPerson(EmpLoyee loyee,HttpServletRequest request) {
		return adminService.addPersonService(loyee,request);
	}
	
	/**
	 * 查询所有员工进行管理
	 * @param request
	 * @return
	 */
	@RequestMapping("empadminQuery.do")
	public String empadminQuery(HttpServletRequest request) {
		adminService.queryEmpLoyeeForPage(request);
		return "admin/empadmin.jsp";
	}
	
	/**
	 * 删除员工
	 * @param radio
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping("deleteEmpLoyee.do")
	public String deleteEmpLoyee(@Valid Radio radio,BindingResult result,Model model) {
		return adminService.deleteEmpLoyeeById(radio,result,model);
	}
	
	/**
	 * 查询所有身份为员工
	 * @param request
	 * @return
	 */
	@RequestMapping("queryPersonForPage.do")
	public String selectAllPserson(HttpServletRequest request) {
		return adminService.queryPersonForPage(request);
	}
	
	/**
	 * 根据编号查询员工
	 * @param request
	 * @return
	 */
	@RequestMapping("queryPersonById.do")
	public String queryPersonById(HttpServletRequest request) {
		return adminService.queryPersonByIdService(request);
	}
	
	/**
	 * 根据编号修改员工所属主管
	 * @param request
	 * @return
	 */
	@RequestMapping("updateParentById.do")
	public String updateParentById(HttpServletRequest request) {
		return adminService.updateParentByIdService(request);
	}
}











