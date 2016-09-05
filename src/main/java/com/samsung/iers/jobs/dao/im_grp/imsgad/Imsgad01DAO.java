package com.samsung.iers.jobs.dao.im_grp.imsgad;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.samsung.iers.common.dao.AbstractDAO;

@Repository("imsgad01DAO")
public class Imsgad01DAO extends AbstractDAO {

	public List<Map<String, Object>> Job_im_000004D_1 (Map<String, Object> map) {
		// task.selectAllTaskList -> mapper
		return selectList ("job_im_000004D_1.Job_im_000004D_1", map);
    
	}

	public void insertJob_im_000004D_1toJobTable(Map<String, Object> map) {
		// task.selectAllTaskList -> mapper
		 insert("job_im_000004D_1.insertJob_im_000004D_1toJobTable", map);
		
	}
	
}
