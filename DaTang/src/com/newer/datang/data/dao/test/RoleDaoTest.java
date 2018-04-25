package com.newer.datang.data.dao.test;


import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.newer.datang.data.dao.IRoleDao;
import com.newer.datang.data.entity.Role;

/**
 * 角色dao层实现测试类
 * @author zxl
 *
 */
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class RoleDaoTest {
	@Resource
	IRoleDao roleDao;
	
	@Test
	public void test() {
		/**
		 * 查询操作测试
		 */
		List<Role> roles = roleDao.selectAllRoles();
		System.out.println("测试查询全部"+roles);
		
		/**
		 * 增删改操作测试
		 */
		Role role = new Role();
		role.setRoleId(6);
		role.setRoleName("a");
		role.setRoleDesc("a");
		int insertRole = roleDao.insertRole(role);
		System.out.println("插入结果："+insertRole);
		
		role.setRoleName("6666");
		int updateRoleById = roleDao.updateRoleById(role);
		System.out.println("修改结果："+updateRoleById);
		
		int deleteRoleById = roleDao.deleteRoleById(6);
		System.out.println("删除结果："+deleteRoleById);
	}
}
