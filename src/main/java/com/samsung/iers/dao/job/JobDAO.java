package com.samsung.iers.dao.job;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.samsung.iers.common.dao.AbstractDAO;

@Repository("jobDAO")
public class JobDAO extends AbstractDAO {

	public void deleteTestDBCol(Map<String, Object> map) {
		// task.selectAllTaskList -> mapper
		 delete("job.deleteTestDBCol", map);
    
	}

	public void insertTestDBCol(Map<String, Object> map) {
		// task.selectAllTaskList -> mapper
		 insert("job.insertTestDBCol", map);
		
	}
	
}
