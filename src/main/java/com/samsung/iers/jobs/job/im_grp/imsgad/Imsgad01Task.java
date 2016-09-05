package com.samsung.iers.jobs.job.im_grp.imsgad;

import javax.annotation.Resource;

import com.samsung.iers.jobs.services.im_grp.imsgad.Imsgad01Service;


public class Imsgad01Task {

	@Resource(name = "imsgad01Service")
	private Imsgad01Service imsgad01Service;
	
public void gathering() throws Exception {
		
		imsgad01Service.Job_im_000004D_1(null);
		System.out.println("im 스케줄러");
		
	}
	
}
