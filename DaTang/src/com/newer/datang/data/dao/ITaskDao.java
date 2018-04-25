package com.newer.datang.data.dao;

import java.util.List;
import java.util.Map;

import com.newer.datang.data.entity.Task;
/**
 * 任务Dao层接口
 * @author zxl
 *
 */
public interface ITaskDao {

	/**
	 * 查询所有任务并分页
	 * @param map
	 * @return
	 */
	List<Task> selectAllTask(Map<String,Object> map);

	/**
	 * 查询所有任务的数量
	 * @return
	 */
	int selectCountByTask();
	
	/**
	 * 根据ID查询任务
	 * @param id
	 * @return
	 */
	Task findTaskById(Integer id);
	
	/**
	 * 新增任务
	 * @param task
	 * @return
	 */
	int insertTask(Task task);

	/**
	 * 根据ID删除任务
	 * @param taskId
	 * @return
	 */
	int deleteTaskByTaskId(int taskId);
	
	/**
	 * 查询所有为实施中的任务
	 * @param map
	 * @return
	 */
	List<Task> selectTaskInOperation(Map<String,Object> map);
	
	/**
	 * 查询所有为实施中的任务数量
	 * @return
	 */
	int selectCountTaskInOperation();
	
	/**
	 * 根据任务编号修改任务状态
	 * @param map
	 * @return
	 */
	int updateTaskStutasByTaskId(Map<String,Object> map);
}