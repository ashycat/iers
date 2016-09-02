package com.samsung.iers.controllers.scheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class SchedulerController {
    Logger log = Logger.getLogger(this.getClass());
    
//    @Autowired
//    private StdScheduler stdScheduler;
    /** 스케줄러 */
//    @Autowired
//    @Qualifier("schedulerFactoryBean")
//    private SchedulerFactoryBean schedulerFactoryBean;
//
//    @Autowired
//    @Qualifier("schedulerFactoryBean1")
//    private SchedulerFactoryBean schedulerFactoryBean1;
    @Autowired
    private SchedulerFactoryBean[] schedulerFactoryBean;

     
    @RequestMapping(value="/api/schedulers/all", method=RequestMethod.GET)
    @ResponseBody
    public ModelAndView schedulerList(Map<String,Object> commandMap) throws Exception{
    	
    	
    	List<Map<String,Object>> schedulerList = new ArrayList<Map<String,Object>>();

    	
    	for (int i = 0; i < schedulerFactoryBean.length; i++) {
			
        	Scheduler sc = schedulerFactoryBean[i].getScheduler();
        	String schedulerName =	sc.getSchedulerName();
        	String groupName = sc.getTriggerGroupNames()[0];
        	String triggerName = sc.getTriggerNames(groupName)[0];
        	boolean status = schedulerFactoryBean[i].isRunning();
        	
        	CronTrigger cron = (CronTrigger)sc.getTrigger(triggerName, groupName);
        	String jobName = cron.getJobName();
        	String crontab = cron.getCronExpression();  
        	
        	
        	System.out.println("schedulerName : "+ schedulerName);
        	System.out.println("groupName : "+ groupName);
        	System.out.println("triggerName : "+ triggerName);
        	System.out.println("jobName : "+ jobName);
        	System.out.println("crontab : "+ crontab);
        	System.out.println("is running : "+ schedulerFactoryBean[i].isRunning());
		

			Map<String,Object> schedulerMap = new HashMap<String, Object>();
			schedulerMap.put("schedulerName", schedulerName);
			schedulerMap.put("triggerName", triggerName);
			schedulerMap.put("groupName", groupName);
			schedulerMap.put("jobName", jobName);
			schedulerMap.put("crontab", crontab);
			schedulerMap.put("status", status);
			
			schedulerList.add(schedulerMap);
		}
    	
    	
//    	CronTrigger cron = (CronTrigger) stdScheduler.getTrigger(
//				"cronTrigger", StdScheduler.DEFAULT_GROUP);
//		
//		System.out.println("trigger "+cron.getJobName() + " : "
//				+ cron.getCronExpression() + " : ");
//		
//		if (cron != null) {
//			cron.setCronExpression("0/20 * * * * ?");
//			JobDetail job = (JobDetail) stdScheduler.getJobDetail(
//					"TestJob", StdScheduler.DEFAULT_GROUP);
//		
//			if (job != null) {
//				System.out.println("job "+ job.getFullName()  +" : " + job.getDescription());
//			
//				stdScheduler.deleteJob("TestJob", StdScheduler.DEFAULT_GROUP);
//				stdScheduler.scheduleJob(job, cron);
//			}
//
//		}
//		
//		if(schedulerFactoryBean.isRunning()){
//			schedulerFactoryBean.stop();
//		}else {
//			schedulerFactoryBean.start();
//		}
//		
//    	
//    	
    	ModelAndView mv = new ModelAndView("/scheduler/List");
         
        mv.addObject("code","200");
        mv.addObject("contents", schedulerList);
        mv.setViewName("jsonView");
        return mv;
    }

    @RequestMapping(value="/api/schedulers/{schedulerName}/changeStatus", method=RequestMethod.POST)
    @ResponseBody
    public ModelAndView changeSchedulerStatus(@PathVariable String schedulerName,@RequestBody Map<String,Object> requestMap) throws Exception{
    	
//		String schedulerName = (String) requestMap.get("schedulerName");
//    	String triggerName = (String) requestMap.get("triggerName");
//    	String groupName = (String) requestMap.get("groupName");
//    	boolean status =  (boolean) requestMap.get("status");
    	
    	int index = -1;
    	for (int i = 0; i < schedulerFactoryBean.length; i++) {
    		Scheduler sc = schedulerFactoryBean[i].getScheduler();
        		
    		if (sc.getSchedulerName().equals(schedulerName)) {
    			index = i;
    		}
		}
    	
    	if(index != -1) {
    		if(schedulerFactoryBean[index].isRunning() == true) {
    			System.out.println("정지합ㄴ디ㅏ. ");
    			schedulerFactoryBean[index].stop();
    		} else if(schedulerFactoryBean[index].isRunning() == false) {
    			System.out.println("시작합니다.  ");
    			schedulerFactoryBean[index].start();
    		} 
    			
    	}
    	
    	
    	ModelAndView mv = new ModelAndView("/scheduler/List");
    	
    	mv.addObject("code","200");
    	mv.setViewName("jsonView");
    	return mv;
    }
    
  
    
}
