package com.samsung.iers.jobs.job.im_grp.imsgad;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class Imsgad01Job extends QuartzJobBean {

	private Imsgad01Task imsgad01Task; 
	
	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException{
		
			try {
				imsgad01Task.gathering();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
	public void setImsgad01Task(Imsgad01Task imsgad01Task) {
        this.imsgad01Task = imsgad01Task;
       
 }
	

}
