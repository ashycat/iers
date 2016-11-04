package com.samsung.iers.controllers.task;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.samsung.iers.services.task.TaskLogService;

@Controller 
public class TaskLogController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "taskLogService")
	private TaskLogService taskLogService;
	
	//select All Task List
	@RequestMapping(value="/api/tasks/log/all", method=RequestMethod.GET)
	@ResponseBody
    public ModelAndView openTaskAllList(@RequestParam Map<String,Object> commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("/task/taskList");
         
        System.out.println(commandMap.toString());
        
        Map<String,Object> resultMap = taskLogService.selectAllTaskList(commandMap);
        System.out.println(resultMap.toString());
        mv.addObject("code","200");
        mv.addObject("total_count",resultMap.get("TOTAL_COUNT"));
        mv.addObject("contents", resultMap.get("result"));
        mv.setViewName("jsonView");
        return mv;
    }

	
}
