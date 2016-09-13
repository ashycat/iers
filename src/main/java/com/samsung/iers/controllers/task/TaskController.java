package com.samsung.iers.controllers.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.samsung.iers.services.task.TaskService;

@Controller 
public class TaskController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "taskService")
	private TaskService taskService;
	
	//select All Task List
	@RequestMapping(value="/api/tasks/all", method=RequestMethod.GET)
	@ResponseBody
    public ModelAndView openTaskAllList(@RequestParam Map<String,Object> commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("/task/taskList");
         
        
        
        System.out.println(commandMap.toString());
        
        Map<String,Object> resultMap = taskService.selectAllTaskList(commandMap);
        System.out.println(resultMap.toString());
        mv.addObject("code","200");
        mv.addObject("total_count",resultMap.get("TOTAL_COUNT"));
        mv.addObject("contents", resultMap.get("result"));
        mv.setViewName("jsonView");
        return mv;
    }

	//select One Task List
	@RequestMapping(value="/api/tasks/{task_id}/{table_name}", method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView openTaskOneList(@PathVariable String task_id,
			@PathVariable String table_name,
			 Map<String,Object> commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/task/taskOne");
		
		log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("task_id", task_id);
		map.put("table_name", table_name);
		
		
		Map<String,Object> result =  taskService.selectOneTask(map);
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list.add(result);
		
		mv.addObject("code","200");
		mv.addObject("contents", list);
		mv.setViewName("jsonView");
		return mv;
	}
	
	//update Task Status
	@RequestMapping(value="/api/tasks/{task_id}/status/{status}", method=RequestMethod.PUT)
	@ResponseBody
	public ModelAndView updateTaskStatus(@PathVariable String task_id,
			@PathVariable String status,	
			Map<String,Object> commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/task/updateTaskStatus");
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("task_id", task_id);
		map.put("status", status);
		System.out.println("taskID, status " + task_id + " : " + status);

		if(status.equals("Assigned")) {
		
			taskService.updateTaskStatusStart(map);
		} else if (status.equals("Terminated")) {
			taskService.updateTaskStatusEnd(map);
		}
		
		mv.addObject("code","200");
//		mv.addObject("contents", list);
		mv.setViewName("jsonView");
		return mv;
	}

	//task_type으로 담당자 조회
	@RequestMapping(value="/api/tasks/types/{task_type}/assignee", method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView selectAssigneeByTaskType(@PathVariable String task_type,
			Map<String,Object> commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/task/selectAssigneeByTaskType");
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("task_type", task_type);
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		result = taskService.selectAssigneeByTaskType(map);
		
		mv.addObject("code","200");
		mv.addObject("contents", result);
		mv.setViewName("jsonView");
		return mv;
	}
	//task_type으로 department에 소속된 담당자 전체 조회
	@RequestMapping(value="/api/tasks/types/{task_type}/dpt_member", method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView selectDptMemberByTaskType(@PathVariable String task_type,
			Map<String,Object> commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/task/selectDptMemberByTaskType");
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("task_type", task_type);
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		result = taskService.selectDptMemberByTaskType(map);
		
		mv.addObject("code","200");
		mv.addObject("contents", result);
		mv.setViewName("jsonView");
		return mv;
	}
	//changeAssignee
	@RequestMapping(value="/api/tasks/types/{task_type}/changeAssignee", method=RequestMethod.POST)
	public ModelAndView changeAssignee(@PathVariable String task_type,
			@RequestBody Map<String,Object> reqbody) throws Exception{
		ModelAndView mv = new ModelAndView("/task/changeAssignee");
		
		System.out.println("reqBody"+reqbody.size());
//		Map<String,Object> map = new HashMap<String, Object>();
//		
//		map.put("task_type", task_type);
//		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
//		result = taskService.selectDptMemberByTaskType(map);
		taskService.changeAssignee(reqbody);
		
		mv.addObject("code","200");
		mv.addObject("contents");
		mv.setViewName("jsonView");
		return mv;
	}
	
}
