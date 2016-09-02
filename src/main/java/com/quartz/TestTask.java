package com.quartz;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.samsung.iers.services.job.JobService;

public class TestTask {
	
	@Resource(name = "jobService")
	private JobService jobService;
	
	public void print() throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("testcol", "testcol111");
		jobService.insertTestDBCol(map );
		
		System.out.println("쿼츠 스케줄러입니다.");
	}
}
