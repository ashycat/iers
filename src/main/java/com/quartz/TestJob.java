package com.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class TestJob extends QuartzJobBean {

	private TestTask tj;
	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		// TODO Auto-generated method stub
		tj.print();

	}
	
	
	 public void setTestTask(TestTask testTask) {
	        this.tj = testTask;
	       
	 }
	 
	 
	 
}
