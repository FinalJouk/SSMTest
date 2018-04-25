package com.newer.datang.data.dao;

import java.util.List;
import java.util.Map;

import com.newer.datang.data.entity.Plan;
import com.newer.datang.data.entity.PlanDTO;
/**
 * 计划Dao层接口
 * @author zxl
 *
 */
public interface IPlanDao {

	/**
	 * 根据任务编号查询计划 分页
	 * @param map
	 * @return
	 */
	List<Plan> selectPlanByTaskIdForPage(Map<String, Object> map);
	
	/**
	 * 根据任务编号查询计划数量
	 * @param taskId
	 * @return
	 */
	int selectCountPlanByTaskId(int taskId);
	
	/**
	 * 根据计划编号查询计划
	 * @param planId
	 * @return
	 */
	Plan selectPlanByPlanId(int planId);
	
	/**
	 * 根据计划编号删除计划
	 * @param planId
	 * @return
	 */
	int deletePlanByPlanId(int planId);
	
	/**
	 * 根据任务编号删除计划
	 * @param taskId
	 * @return
	 */
	int deletePlanByTaskId(int taskId);
	
	/**
	 * 添加计划
	 * @param plan
	 * @return
	 */
	int insertPlan(Plan plan);
	
	/**
	 * 根据计划编号修改计划
	 * @param plan
	 * @return
	 */
	int updatePlan(Plan plan);
	
	/**
	 * 高级查询计划并分页
	 * @param map
	 * @return
	 */
	List<Plan> selectSeniorPlanForPage(Map<String, Object> map);
	
	/**
	 * 根据高级查询条件查询结果数
	 * @param dto
	 * @return
	 */
	int selectCountSeniorPlanForPage(PlanDTO dto);
}