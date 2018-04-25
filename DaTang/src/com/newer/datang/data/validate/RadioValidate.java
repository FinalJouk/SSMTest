package com.newer.datang.data.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.newer.datang.data.dao.IEmployeeDao;
import com.newer.datang.data.dao.impl.EmployeeDaoImpl;
import com.newer.datang.data.util.Radio;

/**
 * 
 * @author zxl
 *
 */
public class RadioValidate implements Validator {

	IEmployeeDao emplopeeDao = new EmployeeDaoImpl();
	
	@Override
	public boolean supports(Class<?> arg0) {
		return Radio.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object obj, Errors error) {
		Radio radio = (Radio) obj;
		int id = Integer.parseInt(radio.getRadio());
		int result = emplopeeDao.selectCountEmpLoyeeByParentId(id);
		System.out.println("------"+result);
		if(result>0){
			error.rejectValue("radio", "redio.required");
		}
	}
}
