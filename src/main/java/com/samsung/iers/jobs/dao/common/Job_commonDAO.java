package com.samsung.iers.jobs.dao.common;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.samsung.iers.common.dao.AbstractDAO;

@Repository("job_commonDAO")
public class Job_commonDAO extends AbstractDAO {

	public void insertJobtoTaskTable (Map<String, Object> map) {
		// task.selectAllTaskList -> mapper
		 insert ("job_common.insertJobtoTaskTable", map);
    
	}

	
}