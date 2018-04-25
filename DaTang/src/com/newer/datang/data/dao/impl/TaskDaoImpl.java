package com.newer.datang.data.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.newer.datang.data.dao.IEmployeeDao;
import com.newer.datang.data.dao.ITaskDao;
import com.newer.datang.data.entity.Task;

/**
 * 任务类 Dao层实现类
 * @author zxl
 */

public class TaskDaoImpl extends SqlSessionDaoSupport implements ITaskDao {
	SqlSession session = null;
	
	@Resource
	IEmployeeDao emplopeeDao;
	
	/**
	 * 查询所有任务 分页
	 */
	@Override
	public List<Task> selectAllTask(Map<String,Object> map) {
		session = super.getSqlSession();
		List<Task> all = null;
		try {
			ITaskDao dao = session.getMapper(ITaskDao.class);
			all = dao.selectAllTask(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return all;
	}
	
	/**
	 * 查询所有任务的数量
	 */
	@Override
	public int selectCountByTask() {
		session = super.getSqlSession();
		int count= 0;
		try {
			ITaskDao dao = session.getMapper(ITaskDao.class);
			count =dao.selectCountByTask();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 根据ID查询任务
	 */
	@Override
	public Task findTaskById(Integer id) {
		session = super.getSqlSession();
		Task task = null;
		try {
			ITaskDao dao = session.getMapper(ITaskDao.class);
			task = dao.findTaskById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return task;
	}
	
	/**
	 * 新增任务
	 */
	@Override
	public int insertTask(Task task) {
		session = super.getSqlSession();
		int result = 0;
		try {
			ITaskDao dao = session.getMapper(ITaskDao.class);
			result = dao.insertTask(task);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 根据ID删除任务
	 */
	@Override
	public int deleteTaskByTaskId(int taskId) {
		session = super.getSqlSession();
		int result = 0;
		try {
			ITaskDao dao = session.getMapper(ITaskDao.class);
			result = dao.deleteTaskByTaskId(taskId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 查询所有为实施中的任务
	 */
	@Override
	public List<Task> selectTaskInOperation(Map<String,Object> map) {
		session = super.getSqlSession();
		List<Task> all = null;
		try {
			ITaskDao dao = session.getMapper(ITaskDao.class);
			all = dao.selectTaskInOperation(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return all;
	}

	/**
	 * 查询所有为实施中的任务数量
	 */
	@Override
	public int selectCountTaskInOperation() {
		session = super.getSqlSession();
		int result = 0;
		try {
			ITaskDao dao = session.getMapper(ITaskDao.class);
			result = dao.selectCountTaskInOperation();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 根据任务编号修改任务状态
	 */
	@Override
	public int updateTaskStutasByTaskId(Map<String,Object> map) {
		session = super.getSqlSession();
		int result = 0;
		try {
			ITaskDao dao = session.getMapper(ITaskDao.class);
			result = dao.updateTaskStutasByTaskId(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}





