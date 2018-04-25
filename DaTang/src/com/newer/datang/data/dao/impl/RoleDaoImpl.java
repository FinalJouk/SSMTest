package com.newer.datang.data.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import com.newer.datang.data.dao.IRoleDao;
import com.newer.datang.data.entity.Role;

/**
 * 角色 dao接口实现类
 * @author zxl
 *
 */
public class RoleDaoImpl extends SqlSessionDaoSupport  implements IRoleDao {
	 SqlSession session = null;
	
	/**
	 * 根据ID修改与删除角色信息
	 */
		@Override
		public int updateRoleById(Role role) {
			session = this.getSqlSession();
			int result = 0;
			try {
				IRoleDao dao = session.getMapper(IRoleDao.class);
				result = dao.updateRoleById(role);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		
		/**
		 * 新增角色信息
		 */
		@Override
		public int insertRole(Role role) {
			session = this.getSqlSession();
			int result = 0;
			try {
				IRoleDao dao = session.getMapper(IRoleDao.class);
				result = dao.insertRole(role);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
	
	/**
	 * 根据编号查询角色信息
	 */
	@Override
	public Role selectRoleById(Integer roleId) {
		session = this.getSqlSession();
		Role role = null;
		try {
			IRoleDao dao = session.getMapper(IRoleDao.class);
			role = dao.selectRoleById(roleId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return role;
	}
	
	/**
	 * 查询所有角色信息
	 */
	@Override
	public List<Role> selectAllRoles() {
		session = super.getSqlSession();
		List<Role> all = null;
		IRoleDao dao = session.getMapper(IRoleDao.class);
		all = dao.selectAllRoles();
		return all;
	}

	/**
	 * 根据编号删除角色
	 */
	@Override
	public int deleteRoleById(Integer roleId) {
		session = this.getSqlSession();
		int result = 0;
		try {
			IRoleDao dao = session.getMapper(IRoleDao.class);
			result = dao.deleteRoleById(roleId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
