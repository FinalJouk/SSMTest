package com.newer.datang.web.control;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.newer.datang.data.entity.EmpLoyee;
import com.newer.datang.service.ILoginService;

/**
 * 登录控制器
 * @author zxl
 *
 */
@Controller
@SessionAttributes("loyee")
public class LoginControl {
	@Resource
	ILoginService loginService;
	
	/**
	 * 登录前准备
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("input_login.do")
	public String inputLogin(Model model,HttpSession session) {
		return loginService.inputLoginService(model,session);
	}
	
	/**
	 * 登录验证
	 * @param loyee
	 * @param result
	 * @param session
	 * @return
	 */
	@RequestMapping("myLogin.do")
	public String myLogin(@Valid @ModelAttribute(value="loyee") EmpLoyee loyee,BindingResult result,HttpSession session) {
		return loginService.loginService(loyee,result,session);
	}
}
