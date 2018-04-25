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

import com.newer.datang.data.dao.ITaskDao;
import com.newer.datang.data.entity.EmpLoyee;
import com.newer.datang.data.entity.Task;
/**
 * 任务dao层实现类测试
 * @author zxl
 *
 */
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TaskDaoTest {
	@Resource
	ITaskDao taskDao;
	
	@SuppressWarnings("deprecation")
	@Test
	public void taskTest() {
		/**
		 * 查询操作测试
		 */
//		Map<String, Object> map = new HashMap<String, Object>(10);
//		map.put("startIndex", 1);
//		map.put("endIndex", 2);
//		List<Task> list = taskDao.selectAllTask(map);
//		System.out.println("查询所有任务并分页结果："+list);
//		
//		int count = taskDao.selectCountByTask();
//		System.out.println("查询所有任务数量："+count);
//		
//		Task task = taskDao.findTaskById(2);
//		System.out.println("查询编号为2的任务详情："+task);
//
//		List<Task> selectTaskInOperation = taskDao.selectTaskInOperation(null);
//		System.out.println("查询所有状态在实施中的任务："+selectTaskInOperation);
//		
//		int selectCountTaskInOperation = taskDao.selectCountTaskInOperation();
//		System.out.println("查询实施中状态的任务数："+selectCountTaskInOperation);
		
		/**
		 * 增删改操作测试
		 */
		Task task1 = new Task();
		task1.setTaskName("任务8");
		task1.setBeginDate(null);
		task1.setEndDate(null);
		task1.setRealBeginDate(null);
		task1.setRealEndDate(null);
		task1.setStatus("未实施");
		EmpLoyee emp = new EmpLoyee();
		emp.setEmployeeId(7);
		task1.setImplementor(emp);
		emp.setEmployeeId(8);
		task1.setAssigner(emp);
		task1.setTaskDesc("ss");
		int insertTask = taskDao.insertTask(task1);
		System.out.println("新增任务结果："+insertTask);
//		
//		int deleteTaskByTaskId = taskDao.deleteTaskByTaskId(28);
//		System.out.println("删除任务的结果："+deleteTaskByTaskId);
//		
//		Map<String, Object> map3 = new HashMap<String, Object>(10);
//		map3.put("taskId", 7);
//		map3.put("status", "实施中");
//		int updateTaskStutasByTaskId = taskDao.updateTaskStutasByTaskId(map3);
//		System.out.println("修改任务状态结果："+updateTaskStutasByTaskId);
	}
}
