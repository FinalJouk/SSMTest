package com.newer.datang.data.dao;

import java.util.List;

import com.newer.datang.data.entity.Role;

/**
 * 角色Dao层接口
 * @author zxl
 *
 */
public interface IRoleDao {

	/**
	 * 根据ID修改与删除角色信息
	 * @param role
	 * @return
	 */
	int updateRoleById(Role role);

	/**
	 * 新增角色信息
	 * @param role
	 * @return
	 */
	int insertRole(Role role);

	/**
	 * 根据编号查询角色信息
	 * @param roleId
	 * @return
	 */
	Role selectRoleById(Integer roleId);

	/**
	 * 查询所有角色信息
	 * @return
	 */
	List<Role> selectAllRoles();
	
	/**
	 * 根据ID删除角色
	 * @param roleId
	 * @return
	 */
	int deleteRoleById(Integer roleId);
}