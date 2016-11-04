package com.samsung.iers.dao.task;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.samsung.iers.common.dao.AbstractDAO;


@Repository("taskLogDAO")
public class TaskLogDAO extends AbstractDAO {
	
	public Map<String, Object> selectAllTaskList(Map<String, Object> map) {
		// task.selectAllTaskList -> mapper
		return (Map<String,Object>)selectPagingList("tasklog.selectAllTaskList", map);
    
	}
	public Map<String, Object> countTask(Map<String, Object> commandMap) {
		return (Map<String, Object>) selectOne("tasklog.countTask");
	}

}
