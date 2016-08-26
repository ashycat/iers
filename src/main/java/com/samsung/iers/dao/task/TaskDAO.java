package com.samsung.iers.dao.task;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.samsung.iers.common.dao.AbstractDAO;


@Repository("taskDAO")
public class TaskDAO extends AbstractDAO {
	
	public Map<String, Object> selectAllTaskList(Map<String, Object> map) {
		// task.selectAllTaskList -> mapper
		return (Map<String,Object>)selectPagingList("task.selectAllTaskList", map);
    
	}

	public Map<String, Object> selectOneTask(Map<String, Object> map) {
		// task.selectOneTaskList -> mapper
		return (Map<String, Object>)selectOne("task.selectOneTask", map);
		
	}

	public void updateTaskStatus(Map<String, Object> map) {
		update("task.updateTaskStatus", map);
	}

	public void updateTaskStartDate(Map<String, Object> map) {
		update("task.updateTaskStartDate", map);
		
	}

	public void updateTaskEndDate(Map<String, Object> map) {
		update("task.updateTaskEndDate", map);
		
	}

	public Map<String, Object> countTask(Map<String, Object> commandMap) {
		return (Map<String, Object>) selectOne("task.countTask");
	}

	public List<Map<String, Object>> selectAssigneeByTaskType(Map<String, Object> map) {
		return (List<Map<String, Object>>) selectList("task.selectAssigneeByTaskType", map);
	}

	public List<Map<String, Object>> selectDptMemberByTaskType(
			Map<String, Object> map) {
		return (List<Map<String, Object>>) selectList("task.selectDptMemberByTaskType", map);
	}

	public void deleteAssignee(Map<String, Object> reqbody) {
		delete("task.deleteAssignee",reqbody);

	}
	public void insertAssignee(Map<String, Object> reqbody) {
		insert("task.insertAssignee",reqbody);
		
	}



}
