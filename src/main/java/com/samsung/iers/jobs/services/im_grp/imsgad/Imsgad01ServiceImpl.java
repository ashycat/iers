package com.samsung.iers.jobs.services.im_grp.imsgad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.samsung.iers.common.utils.TaskID;
import com.samsung.iers.jobs.dao.common.Job_commonDAO;
import com.samsung.iers.jobs.dao.im_grp.imsgad.Imsgad01DAO;

@Service("imsgad01Service")
public class Imsgad01ServiceImpl implements Imsgad01Service {

	
	Logger log = Logger.getLogger(this.getClass());
    
    @Resource(name="imsgad01DAO")
    private Imsgad01DAO imsgad01DAO;

    @Resource(name="job_commonDAO")
    private Job_commonDAO job_commonDAO;



	@Override
	public List<Map<String, Object>> Job_im_000004D_1(
			Map<String, Object> map) throws Exception {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				list = imsgad01DAO.Job_im_000004D_1(map);
		if(list.size() != 0) {
			TaskID t = new TaskID("JOB_IM_000004D_1");
			map = new HashMap<String, Object>();
			map.put("task_id", t.CreateTaskID());
			imsgad01DAO.insertJob_im_000004D_1toJobTable(map);
			job_commonDAO.insertJobtoTaskTable(map);
		}
		return list;
	}

	@Override
	public void insertJob_im_000004D_1toJobTable(Map<String, Object> map)
			throws Exception {

		imsgad01DAO.insertJob_im_000004D_1toJobTable(map);
	}
    

	

}
