package com.samsung.iers.services.task;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

public interface TaskLogService {
	@Transactional(value="transactionManager")
	Map<String,Object> selectAllTaskList(Map<String, Object> commandMap) throws Exception;

	
}
