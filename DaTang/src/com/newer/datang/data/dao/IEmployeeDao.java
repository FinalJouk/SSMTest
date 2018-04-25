package com.newer.datang.data.dao;

import java.util.List;
import java.util.Map;

import com.newer.datang.data.entity.EmpLoyee;
/**
 * 员工Dao层接口
 * @author zxl
 *
 */
public interface IEmployeeDao {

	/**
	 * 根据ID修改所属主管
	 * @param map
	 * @return
	 */
	int updateEmployeeById(Map<String, Object> map);

	/**
	 *  新增员工信息
	 * @param emp
	 * @return
	 */
	int insertEmployee(EmpLoyee emp);

	/**
	 * 查询所有员工记录
	 * @return
	 */
	List<EmpLoyee> selectAllEmployee();

	/**
	 * 根据ID查询员工
	 * @param employeeId
	 * @return
	 */
	EmpLoyee findEmployeeById(Integer employeeId);

	/**
	 * 查询主管下员工数量
	 * @param id
	 * @return
	 */
	int selectCountEmpLoyeeByParentId(int id);
	
	/**
	 *  根据用户名、密码查询员工
	 * @param emp
	 * @return
	 */
	EmpLoyee selectEmpLoyeeByNameAndPWD(EmpLoyee emp);

	
	 /**
	  *  根据分页查询所有员工
	  * @param map
	  * @return
	  */
	List<EmpLoyee> selectAllEmpLoyeeByPage(Map<String, Object> map);
	
	/**
	 * 查询所有员工的数量
	 * @return
	 */
	int selectCountForAllEmp();
	
	/**
	 * 根据ID删除员工
	 * @param id
	 * @return
	 */
	int deleteEmpLoyeeByEmpId(int id);
	
	/**
	 * 根据分页查询所有员工 角色为4的
	 * @param map
	 * @return
	 */
	List<EmpLoyee> selectAllEmpLoyeeByPageWhereRole(Map<String, Object> map);
	
	/**
	 * 查询所有员工角色为员工的数量
	 * @return
	 */
	int selectCountForAllEmpWhereRole();
	
	/**
	 * 查询所有角色为主管的员工
	 * @return
	 */
	List<EmpLoyee> selectEmpForRoleIsManager();
	
	/**
	 * 查询所有角色为员工的员工
	 * @return
	 */
	List<EmpLoyee> selectEmpForRoleIsPerson();
	
	/**
	 * 查询主管下辖所有员工 分页
	 * @param map
	 * @return
	 */
	List<EmpLoyee> selectEmpLoyeeByParentId(Map<String, Object> map);
}