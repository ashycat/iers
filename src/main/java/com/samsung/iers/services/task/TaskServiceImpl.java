package com.samsung.iers.services.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.samsung.iers.common.utils.ConvertList;
import com.samsung.iers.dao.task.TaskDAO;
import com.samsung.iers.jobs.dao.common.Job_commonDAO;


@Service("taskService")
public class TaskServiceImpl implements TaskService {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="taskDAO")
	private TaskDAO taskDAO;

	@Resource(name="job_commonDAO")
	private Job_commonDAO job_commonDAO;
	
	@Override
	public Map<String,Object> selectAllTaskList(
			Map<String, Object> commandMap) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> resultMap = new HashMap<String, Object>();
		resultMap.putAll(taskDAO.countTask(commandMap));
		resultMap.putAll(taskDAO.selectAllTaskList(commandMap));
		System.out.println("RESULT MAP : "+resultMap);
		return resultMap;
	}

	// task_id로 정보 불러오기
	// task_type으로 department 정보 불러오기
	// 
	@Override
	public Map<String, Object> selectOneTask(
			Map<String, Object> map) throws Exception {
		
		List<LinkedHashMap<String, Object>> desList = new ArrayList<LinkedHashMap<String, Object>>();
		System.out.println(map.get("table_name"));
		
		desList = job_commonDAO.selectDescriptionRow(map);

		
		
		ConvertList cl = new ConvertList();
		String desRow = cl.toHtmlTable(desList);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap = taskDAO.selectOneTask(map); 
		resultMap.put("descriptionRow", desRow);
		
		return resultMap;
	}
	
	@Override
	public void updateTaskStatus(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
		if(map.get("status").equals("Assigned")) {
			taskDAO.updateTaskStatus(map);
			
		}else if(map.get("status").equals("InProgress")) {
			taskDAO.updateTaskStatus(map);
			taskDAO.updateTaskStartDate(map);
			taskDAO.updateTaskExpectedEndDate(map);

		}else if(map.get("status").equals("Terminated")) {
			taskDAO.updateTaskStatus(map);
			taskDAO.updateTaskEndDate(map);
		}
		
	}

	@Override
	public List<Map<String, Object>> selectAssigneeByTaskType(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return taskDAO.selectAssigneeByTaskType(map);
	}

	@Override
	public List<Map<String, Object>> selectDptMemberByTaskType(
			Map<String, Object> map) {
		// TODO Auto-generated method stub
		return taskDAO.selectDptMemberByTaskType(map);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void changeAssignee(Map<String, Object> reqbody) {
		// TODO Auto-generated method stub
		Map<String, Object> deleteMap = new HashMap<String , Object>();
		deleteMap.put("task_type", reqbody.get("task_type"));
		System.out.println(deleteMap.toString());
		taskDAO.deleteAssignee(deleteMap);

		List<Map<String, Object>> insertList = new ArrayList<Map<String , Object>>();
		insertList = (List<Map<String, Object>>) reqbody.get("body");
		if(insertList.size() != 0) {
			for (int i = 0; i < insertList.size(); i++) {
				insertList.get(i).put("task_type", reqbody.get("task_type"));
				System.out.println(insertList.get(i).toString());
				taskDAO.insertAssignee(insertList.get(i));
				
			}
		}
	}

	

}
