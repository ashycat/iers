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
import com.samsung.iers.dao.task.TaskLogDAO;


@Service("taskLogService")
public class TaskLogServiceImpl implements TaskLogService {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="taskLogDAO")
	private TaskLogDAO taskLogDAO;

	@Override
	public Map<String,Object> selectAllTaskList(
			Map<String, Object> commandMap) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> resultMap = new HashMap<String, Object>();
		resultMap.putAll(taskLogDAO.countTask(commandMap));
		resultMap.putAll(taskLogDAO.selectAllTaskList(commandMap));

		return resultMap;
	}

}
