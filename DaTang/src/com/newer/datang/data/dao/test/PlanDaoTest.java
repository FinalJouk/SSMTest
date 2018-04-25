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

import com.newer.datang.data.dao.IPlanDao;
import com.newer.datang.data.entity.Plan;
import com.newer.datang.data.entity.PlanDTO;
import com.newer.datang.data.entity.Task;
/**
 * 计划dao层实现类测试
 * @author zxl
 *
 */
@ContextConfiguration(locations={"classpath:applicationContext.xml","classpath:spring-mvc.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class PlanDaoTest {
	@Resource
	IPlanDao planDao;
	
	@SuppressWarnings("deprecation")
	@Test
	public void planTest() {
		/**
		 * 查询操作测试
		 */
		int planCount = planDao.selectCountPlanByTaskId(1);
		System.out.println("任务1关联的计划数："+planCount);
		
		Map<String, Object> map = new HashMap<String,Object>(10);
		map.put("taskId", 1);
		List<Plan> list = planDao.selectPlanByTaskIdForPage(map);
		for (Plan plan : list) {
			System.out.println("任务1关联的计划（不分页）："+plan);
		}
		
		map.put("startIndex", 1);
		map.put("endIndex", 2);
		List<Plan> list1 = planDao.selectPlanByTaskIdForPage(map);
		for (Plan plan : list1) {
			System.out.println("任务1关联的计划（分页）："+plan);
		}
		
		Plan plan = planDao.selectPlanByPlanId(1);
		System.out.println("根据计划编号查询计划："+plan);
		
		PlanDTO dto = new PlanDTO();
		dto.setTaskId(1);
		Map<String, Object> map3 = new HashMap<String, Object>(10);
		map3.put("dto", dto);
		List<Plan> list2 = planDao.selectSeniorPlanForPage(map3);
		for (Plan plan2 : list2) {
			System.out.println("高级查询结果："+plan2);
		}
		
		int i = planDao.selectCountSeniorPlanForPage(dto);
		System.out.println("高级查询条件下符合的数量："+i);
		
		
		int result = planDao.deletePlanByPlanId(14);
		System.out.println("删除数量："+result);
		
		/**
		 * 增删改操作测试
//		 */
		int result1 = planDao.deletePlanByTaskId(3);
		System.out.println("根据任务编号删除计划："+result1);
		
		Plan plan1 = new Plan();
		plan1.setPlanName("as");
		plan1.setBeginDate(new Date("2005/5/5"));
		plan1.setEndDate(new Date("2015/8/8"));
		plan1.setPlanDesc("as");
		Task task = new Task();
		task.setTaskId(3);
		plan1.setTask(task);
		int result2 = planDao.insertPlan(plan1);
		System.out.println("添加计划的结果："+result2);
		
		Plan plan2 = new Plan();
		plan2.setPlanId(52);
		plan2.setStatus("未完成");
		plan2.setIsFeedback("是");
		plan2.setFeedbackInfo("ss");
		int result6 = planDao.updatePlan(plan2);
		System.out.println("修改的结果："+result6);
	}
}
