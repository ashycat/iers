package com.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class TestJob1 extends QuartzJobBean {

	private TestTask1 tj;
	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		// TODO Auto-generated method stub
		tj.print();

	}
	
	
	 public void setTestTask1(TestTask1 testTask) {
	        this.tj = testTask;
	       
	 }
	 
	 
	 
}
