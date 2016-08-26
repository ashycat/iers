package com.samsung.iers.services.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.samsung.iers.dao.task.TaskDAO;


@Service("taskService")
public class TaskServiceImpl implements TaskService {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="taskDAO")
	private TaskDAO taskDAO;

	@Override
	public Map<String,Object> selectAllTaskList(
			Map<String, Object> commandMap) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> resultMap = new HashMap<String, Object>();
		resultMap.putAll(taskDAO.countTask(commandMap));
		resultMap.putAll(taskDAO.selectAllTaskList(commandMap));

		return resultMap;
	}

	// task_id로 정보 불러오기
	// task_type으로 department 정보 불러오기
	// 
	@Override
	public Map<String, Object> selectOneTask(
			Map<String, Object> commandMap) throws Exception {
		return taskDAO.selectOneTask(commandMap);
	}
	
	@Override
	public void updateTaskStatusStart(Map<String, Object> commandMap) {
		// TODO Auto-generated method stub
		taskDAO.updateTaskStatus(commandMap);
		taskDAO.updateTaskStartDate(commandMap);
	}

	@Override
	public void updateTaskStatusEnd(Map<String, Object> commandMap) {
		// TODO Auto-generated method stub
		taskDAO.updateTaskStatus(commandMap);
		taskDAO.updateTaskEndDate(commandMap);
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
