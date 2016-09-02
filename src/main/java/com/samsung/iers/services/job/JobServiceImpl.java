package com.samsung.iers.services.job;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.samsung.iers.dao.job.JobDAO;

@Service("jobService")
public class JobServiceImpl implements JobService {

	
	Logger log = Logger.getLogger(this.getClass());
    
    @Resource(name="jobDAO")
    private JobDAO jobDAO;

	@Override
	public void deleteTestDBCol(Map<String, Object> map)
			throws Exception {
		// TODO Auto-generated method stub
		jobDAO.deleteTestDBCol(map);
		
	}

	@Override
	public void insertTestDBCol(Map<String, Object> commandMap)
			throws Exception {
		// TODO Auto-generated method stub
		jobDAO.insertTestDBCol(commandMap);
		jobDAO.deleteTestDBCol(null);
		
	}
    

	

}
