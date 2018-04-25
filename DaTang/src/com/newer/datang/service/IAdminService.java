package com.newer.datang.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.newer.datang.data.entity.EmpLoyee;
import com.newer.datang.data.util.Radio;

/**
 * 管理员 服务层接口
 * @author zxl
 *
 */
public interface IAdminService {

	/**
	 * 分页查询员工
	 * @param request
	 * @return
	 */
	public String queryEmpLoyeeForPage(HttpServletRequest request);

	/**
	 * 查询所有角色
	 * @param model
	 * @return
	 */
	public String inputPersonService(Model model);

	/**
	 * 新增员工
	 * @param loyee
	 * @param request
	 * @return
	 */
	public String addPersonService(EmpLoyee loyee,HttpServletRequest request);

	/**
	 * 根据ID删除员工
	 * @param radio
	 * @param result
	 * @param model
	 * @return
	 */
	public String deleteEmpLoyeeById(Radio radio,BindingResult result,Model model);

	/**
	 * 根据分页查询所有员工 角色为4的
	 * @param request
	 * @return
	 */
	public String queryPersonForPage(HttpServletRequest request);

	/**
	 * 查询所有角色为主管的员工
	 * @param request
	 * @return
	 */
	public String queryPersonByIdService(HttpServletRequest request);

	/**
	 * 根据编号修改员工所属主管
	 * @param request
	 * @return
	 */
	public String updateParentByIdService(HttpServletRequest request);

}