package com.newer.datang.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import com.newer.datang.data.dao.IEmployeeDao;
import com.newer.datang.data.entity.EmpLoyee;
import com.newer.datang.data.util.RoleConstant;
import com.newer.datang.service.ILoginService;

/**
 * 登录服务层实现类
 * @author zxl
 *
 */
public class LoginServiceImpl implements ILoginService {
	@Resource
	IEmployeeDao emplopeeDao;
	
	/**
	 * 登录准备工作
	 */
	@Override
	public String inputLoginService(Model model,HttpSession session) {
		session.removeAttribute("user");
		EmpLoyee loyee = new EmpLoyee();
		model.addAttribute("loyee",loyee);
		return "login.jsp";
	}

	/**
	 * 登录验证
	 */
	@Override
	public String loginService(EmpLoyee loyee,BindingResult bingResult,HttpSession session) {
		if(bingResult.hasErrors()){
			return "login.jsp";
		}else{
			String result = null;
			EmpLoyee employee= emplopeeDao.selectEmpLoyeeByNameAndPWD(loyee);
			if(employee!=null){
				String roleName = employee.getRole().getRoleName();
				if(RoleConstant.ADMIN.equals(roleName)){
					result="admin/welcome.jsp";
				}else if(RoleConstant.MANAGER.equals(roleName)){
					result="manager/welcome.jsp";
				}else if(RoleConstant.PERSON.equals(roleName)){
					result="person/welcome.jsp";
				}
				session.setAttribute("user", employee);
				return result;
			}else{
				return "login.jsp";
			}
		}
	}
}
