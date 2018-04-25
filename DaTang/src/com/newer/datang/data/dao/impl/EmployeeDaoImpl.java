package com.newer.datang.data.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.newer.datang.data.dao.IEmployeeDao;
import com.newer.datang.data.entity.EmpLoyee;

/**
 * 员工 dao接口实现类
 * @author zxl
 *
 */
public class EmployeeDaoImpl extends SqlSessionDaoSupport implements IEmployeeDao {
	SqlSession session = null;
	
	/**
	 * 根据ID修改员工所属主管
	 */
	@Override
	public int updateEmployeeById(Map<String, Object> map) {
		session = super.getSqlSession();
		int result = 0;
		try {
			IEmployeeDao dao = session.getMapper(IEmployeeDao.class);
			result = dao.updateEmployeeById(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 新增员工信息
	 */
	@Override
	public int insertEmployee(EmpLoyee emp) {
		session = super.getSqlSession();
		int result = 0;
		try {
			IEmployeeDao dao = session.getMapper(IEmployeeDao.class);
			result = dao.insertEmployee(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 查询所有员工记录
	 */
	@Override
	public List<EmpLoyee> selectAllEmployee() {
		session = super.getSqlSession();
		List<EmpLoyee> all = null;
		try {
			IEmployeeDao dao = session.getMapper(IEmployeeDao.class);
			all = dao.selectAllEmployee();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return all;
	}
	
	/**
	 * 根据ID查询员工
	 */
	@Override
	public EmpLoyee findEmployeeById(Integer employeeId) {
		session = super.getSqlSession();
		EmpLoyee emp = null;
		try{
			IEmployeeDao dao = session.getMapper(IEmployeeDao.class);
			emp = dao.findEmployeeById(employeeId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	/**
	 * 查询主管下员工数量
	 */
	@Override
	public int selectCountEmpLoyeeByParentId(int id) {
		session = super.getSqlSession();
		int result = 0;
		try {
			IEmployeeDao dao = session.getMapper(IEmployeeDao.class);
			result = dao.selectCountEmpLoyeeByParentId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 根据用户名、密码查询员工
	 */
	@Override
	public EmpLoyee selectEmpLoyeeByNameAndPWD(EmpLoyee emp) {
		session = super.getSqlSession();
		EmpLoyee employee = null;
		try{
			IEmployeeDao dao = session.getMapper(IEmployeeDao.class);
			employee = dao.selectEmpLoyeeByNameAndPWD(emp);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

	/**
	 * 根据分页查询所有员工
	 */
	@Override
	public List<EmpLoyee> selectAllEmpLoyeeByPage(Map<String, Object> map) {
		session = super.getSqlSession();
		List<EmpLoyee> list = null;
		try{
			IEmployeeDao dao = session.getMapper(IEmployeeDao.class);
			list = dao.selectAllEmpLoyeeByPage(map);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 查询所有员工的数量
	 * @return
	 */
	@Override
	public int selectCountForAllEmp() {
		session = super.getSqlSession();
		int count = 0;
		try{
			IEmployeeDao dao = session.getMapper(IEmployeeDao.class);
			count = dao.selectCountForAllEmp();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 根据ID删除员工
	 */
	@Override
	public int deleteEmpLoyeeByEmpId(int id) {
		session = super.getSqlSession();
		int count = 0;
		try{
			IEmployeeDao dao = session.getMapper(IEmployeeDao.class);
			count = dao.deleteEmpLoyeeByEmpId(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 根据分页查询所有员工 角色为4的
	 */
	@Override
	public List<EmpLoyee> selectAllEmpLoyeeByPageWhereRole(Map<String, Object> map) {
		session = super.getSqlSession();
		List<EmpLoyee> list = null;
		try{
			IEmployeeDao dao = session.getMapper(IEmployeeDao.class);
			list = dao.selectAllEmpLoyeeByPageWhereRole(map);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 查询所有员工角色为员工的数量
	 */
	@Override
	public int selectCountForAllEmpWhereRole() {
		session = super.getSqlSession();
		int count = 0;
		try{
			IEmployeeDao dao = session.getMapper(IEmployeeDao.class);
			count = dao.selectCountForAllEmpWhereRole();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 查询所有角色为主管的员工
	 */
	@Override
	public List<EmpLoyee> selectEmpForRoleIsManager() {
		session = super.getSqlSession();
		List<EmpLoyee> list = null;
		try{
			IEmployeeDao dao = session.getMapper(IEmployeeDao.class);
			list = dao.selectEmpForRoleIsManager();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 查询所有角色为员工的员工
	 */
	@Override
	public List<EmpLoyee> selectEmpForRoleIsPerson() {
		session = super.getSqlSession();
		List<EmpLoyee> list = null;
		try{
			IEmployeeDao dao = session.getMapper(IEmployeeDao.class);
			list = dao.selectEmpForRoleIsPerson();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 查询主管下辖所有员工 分页
	 */
	@Override
	public List<EmpLoyee> selectEmpLoyeeByParentId(Map<String, Object> map) {
		session = super.getSqlSession();
		List<EmpLoyee> list = null;
		try{
			IEmployeeDao dao = session.getMapper(IEmployeeDao.class);
			list = dao.selectEmpLoyeeByParentId(map);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
