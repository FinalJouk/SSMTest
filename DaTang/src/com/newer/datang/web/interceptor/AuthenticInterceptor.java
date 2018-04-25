package com.newer.datang.web.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newer.datang.data.entity.EmpLoyee;

/**
 * 权限控制器
 * @author zxl
 *
 */
public class AuthenticInterceptor implements Filter {
	
	private static final String[] URLS={"input_login.do", "myLogin.do", "login.jsp", ".js", ".css", ".jpg",".gif" };
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String path = request.getServletPath();
		HttpSession session = request.getSession();
		for (String string : URLS) {
			if (path.endsWith(string)) {
				chain.doFilter(request, response);
				return;
			}
		}
		EmpLoyee loyee = (EmpLoyee) session.getAttribute("user");
		if(loyee==null){
			response.sendRedirect("input_login.do");
		}else{
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
