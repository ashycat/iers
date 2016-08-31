package com.samsung.iers.controllers;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.impl.StdScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.samsung.iers.services.SampleService;
 
@Controller
public class SampleController {
    Logger log = Logger.getLogger(this.getClass());
    
    @Autowired
    private StdScheduler stdScheduler;
    
    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;
    
    
    
    @Resource(name="sampleService")
    private SampleService sampleService;
     
    @RequestMapping(value="/api/samples/get", method=RequestMethod.GET)
    @ResponseBody
    public ModelAndView openSampleBoardList(Map<String,Object> commandMap) throws Exception{
    	
    	
    	System.out.println( stdScheduler.getTriggerNames(StdScheduler.DEFAULT_GROUP).length);
    	System.out.println( stdScheduler.getTriggerNames(StdScheduler.DEFAULT_GROUP)[0]);
    	
    	CronTrigger cron = (CronTrigger) stdScheduler.getTrigger(
				"cronTrigger", StdScheduler.DEFAULT_GROUP);
		
		System.out.println("trigger "+cron.getJobName() + " : "
				+ cron.getCronExpression() + " : ");
		
		if (cron != null) {
			cron.setCronExpression("0/20 * * * * ?");
			JobDetail job = (JobDetail) stdScheduler.getJobDetail(
					"TestJob", StdScheduler.DEFAULT_GROUP);
		
			if (job != null) {
				System.out.println("job "+ job.getFullName()  +" : " + job.getDescription());
			
				stdScheduler.deleteJob("TestJob", StdScheduler.DEFAULT_GROUP);
				stdScheduler.scheduleJob(job, cron);
			}

		}
		
		if(schedulerFactoryBean.isRunning()){
			schedulerFactoryBean.stop();
		}else {
			schedulerFactoryBean.start();
		}
		
//    	
//    	
    	ModelAndView mv = new ModelAndView("/sample/boardList");
         
//        List<Map<String,Object>> list = sampleService.selectBoardList(commandMap);
//        
//        
//        mv.addObject("code","200");
//        mv.addObject("contents", list);
//        mv.setViewName("jsonView");
        return mv;
    }
    
    @RequestMapping(value="/api/samples/{id}", method=RequestMethod.POST)
    @ResponseBody
    public ModelAndView insertSampleBoard(@PathVariable String id,
    		Map<String,Object> commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("/sample/boardList");
         
        commandMap.put("TITLE", id);
        System.out.println("sksksksksksksksk"+id);
        int list = sampleService.insertBoard(commandMap);
        
        mv.addObject("code","200");
        mv.addObject("contents", list);
        mv.setViewName("jsonView");
        return mv;
    }
//    @RequestMapping(value="/sample/openSampleBoardList.do", method=RequestMethod.GET)
//    public @ResponseBody openSampleBoardList(Map<String,Object> commandMap) throws Exception{
//        ModelAndView mv = new ModelAndView("/sample/boardList");
//         
//        List<Map<String,Object>> list = sampleService.selectBoardList(commandMap);
//        
//        mv.addObject("list", list);
//         
//        return response.;
//    }
    
    
    public void setSchedulerFactoryBean(StdScheduler schedulerFactoryBean)
			throws Exception {

		this.stdScheduler = schedulerFactoryBean;
	}
    
}
