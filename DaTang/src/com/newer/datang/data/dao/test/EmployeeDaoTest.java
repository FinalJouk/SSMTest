package com.newer.datang.data.dao.test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.newer.datang.data.dao.IEmployeeDao;
import com.newer.datang.data.entity.EmpLoyee;
import com.newer.datang.data.entity.Role;

/**
 * 员工Dao层实现类测试
 * @author zxl
 *
 */
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeDaoTest {
	@Resource
	IEmployeeDao employeeDao;
	
	@SuppressWarnings("deprecation")
	@Test
	public void empDaoTest() {
		/**
		 * 查询操作测试
		 */
		List<EmpLoyee> list = employeeDao.selectAllEmployee();
		System.out.println("查询全部员工："+list);
		
		EmpLoyee loyee = employeeDao.findEmployeeById(9);
		System.out.println("根据编号查询员工："+loyee);
		
		int count = employeeDao.selectCountEmpLoyeeByParentId(8);
		System.out.println("查询编号为9的主管下员工数："+count);
		
		EmpLoyee emp = new EmpLoyee();
		emp.setEmployeeName("zhaoliu");
		emp.setPassword("123456");
		EmpLoyee emp1 = employeeDao.selectEmpLoyeeByNameAndPWD(emp);
		System.out.println("模拟登陆的用户详情："+emp1);
		
		Map<String, Object> map = new HashMap<String, Object>(10);
		map.put("startIndex", 1);
		map.put("endIndex", 2);
		List<EmpLoyee> list2 = employeeDao.selectAllEmpLoyeeByPage(map);
		System.out.println("查询员工分页结果："+list2);
		
		int allEmp = employeeDao.selectCountForAllEmp();
		System.out.println("查询所有员工数量："+allEmp);
		
		List<EmpLoyee> list3 = employeeDao.selectAllEmpLoyeeByPageWhereRole(map);
		System.out.println("查询角色为员工的分页结果："+list3);
		
		List<EmpLoyee> list4 = employeeDao.selectEmpForRoleIsManager();
		System.out.println("查询所有角色为主管的结果："+list4);
		
		Map<String, Object> map3 = new HashMap<String, Object>(10);
		map3.put("startIndex", 1);
		map3.put("endIndex", 2);
		map3.put("parentId", 8);
		List<EmpLoyee> list5 = employeeDao.selectEmpLoyeeByParentId(map3);
		System.out.println("查询编号为8的主管下辖所有员工："+list5);
		
		int i = employeeDao.selectCountForAllEmpWhereRole();
		System.out.println("查询所有角色为员工的数量："+i);
		
		List<EmpLoyee> list6 = employeeDao.selectEmpForRoleIsPerson();
		System.out.println("查询所有角色为员工:"+list6);
		
		/**
		 * 增删改操作测试
		 */
		Map<String, Object> map2 = new HashMap<String, Object>(10);
		map2.put("parentId",8);
		map2.put("employeeId",34);
		int update = employeeDao.updateEmployeeById(map2);
		System.out.println("修改的结果数："+update);
		
		EmpLoyee emp2 = new EmpLoyee();
		emp2.setEmployeeName("sss");
		emp2.setRealName("aaa");
		emp2.setPassword("123456");
		emp2.setSex("男");
		emp2.setBirthDay(new Date("2015/5/5"));
		emp2.setDuty("ss");
		emp2.setEducation("ss");
		emp2.setExperience("ss");
		emp2.setMajor("ss");
		emp2.setEndrolldDate(new Date());
		emp2.setRole(new Role(2,null,null));
		emp2.setParent(null);
		int insert = employeeDao.insertEmployee(emp2);
		System.out.println("新增数量为："+insert);
		
		int delete = employeeDao.deleteEmpLoyeeByEmpId(33);
		System.out.println("删除的数量："+delete);
	}
}
