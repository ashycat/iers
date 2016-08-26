package com.samsung.iers.services.task;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

public interface TaskService {
	@Transactional(value="transactionManager")
	Map<String,Object> selectAllTaskList(Map<String, Object> commandMap) throws Exception;

	@Transactional
	Map<String, Object> selectOneTask(Map<String, Object> commandMap) throws Exception;

	@Transactional
	void updateTaskStatusStart(Map<String, Object> commandMap) throws Exception;

	@Transactional
	void updateTaskStatusEnd(Map<String, Object> commandMap) throws Exception;
	
	@Transactional
	List<Map<String, Object>> selectAssigneeByTaskType(Map<String, Object> map);
	
	@Transactional
	List<Map<String, Object>> selectDptMemberByTaskType(Map<String, Object> map);
	
	@Transactional
	void changeAssignee(Map<String, Object> reqbody);
	
}
