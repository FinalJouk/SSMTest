package com.newer.datang.data.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.newer.datang.data.dao.IPlanDao;
import com.newer.datang.data.dao.ITaskDao;
import com.newer.datang.data.entity.Plan;
import com.newer.datang.data.entity.PlanDTO;

/**
 * 计划DAO层实现类
 * @author zxl
 *
 */
public class PlanDaoImpl extends SqlSessionDaoSupport implements IPlanDao {
	SqlSession session = null;
	
	@Resource
	ITaskDao taskDao;
	
	
	/**
	 * 根据任务编号查询计划 分页
	 */
	@Override
	public List<Plan> selectPlanByTaskIdForPage(Map<String, Object> map){
		session = super.getSqlSession();
		List<Plan> all = null;
		try {
			IPlanDao dao = session.getMapper(IPlanDao.class);
			all = dao.selectPlanByTaskIdForPage(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return all;
	}

	/**
	 * 根据任务编号查询计划数量
	 */
	@Override
	public int selectCountPlanByTaskId(int taskId) {
		session = super.getSqlSession();
		int count = 0;
		try {
			IPlanDao dao = session.getMapper(IPlanDao.class);
			count = dao.selectCountPlanByTaskId(taskId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 根据计划编号查询计划
	 */
	@Override
	public Plan selectPlanByPlanId(int planId) {
		session = super.getSqlSession();
		Plan plan = null;
		try {
			IPlanDao dao = session.getMapper(IPlanDao.class);
			plan = dao.selectPlanByPlanId(planId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return plan;
	}

	/**
	 * 根据计划编号删除计划
	 */
	@Override
	public int deletePlanByPlanId(int planId) {
		session = super.getSqlSession();
		int result = 0;
		try {
			IPlanDao dao = session.getMapper(IPlanDao.class);
			result = dao.deletePlanByPlanId(planId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 根据任务编号删除计划
	 */
	@Override
	public int deletePlanByTaskId(int taskId) {
		session = super.getSqlSession();
		int result = 0;
		try {
			IPlanDao dao = session.getMapper(IPlanDao.class);
			result = dao.deletePlanByTaskId(taskId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 添加计划
	 */
	@Override
	public int insertPlan(Plan plan) {
		session = super.getSqlSession();
		int result = 0;
		try {
			IPlanDao dao = session.getMapper(IPlanDao.class);
			result = dao.insertPlan(plan);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 修改计划
	 */
	@Override
	public int updatePlan(Plan plan) {
		session = super.getSqlSession();
		int result = 0;
		try {
			IPlanDao dao = session.getMapper(IPlanDao.class);
			result = dao.updatePlan(plan);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 高级查询并分页
	 */
	@Override
	public List<Plan> selectSeniorPlanForPage(Map<String, Object> map) {
		session = super.getSqlSession();
		List<Plan> all = null;
		try {
			IPlanDao dao = session.getMapper(IPlanDao.class);
			all = dao.selectSeniorPlanForPage(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return all;
	}

	/**
	 * 根据高级查询条件查询结果数
	 */
	@Override
	public int selectCountSeniorPlanForPage(PlanDTO dto) {
		session = super.getSqlSession();
		int count = 0;
		try {
			IPlanDao dao = session.getMapper(IPlanDao.class);
			count = dao.selectCountSeniorPlanForPage(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
}
