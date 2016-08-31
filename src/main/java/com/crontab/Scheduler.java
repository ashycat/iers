package com.crontab;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.samsung.iers.dao.task.TaskDAO;

@Component
public class Scheduler {
	
	
	
	@Autowired
	private TaskDAO dao;
	/**
	 * 1. 오후 05:50:00에 호출이 되는 스케쥴러 
	 */
	@Scheduled(cron = "0 58 17 * * *")
	public void cronTest1(){
		
		
		Map<String, Object> commandMap = new HashMap<String, Object>();
		
		commandMap.putAll( dao.countTask(null));
		System.out.println("오후 01:50:00에 호출이 됩니다. " + commandMap.get("TOTAL_COUNT"));
	}
	
	/**
	 * 2. 오후 05:51:00에 호출이 되는 스케쥴러 
	 */
	@Scheduled(cron = "0 22 10 * * *")
	public void cronTest2(){
		System.out.println("1분마다 돕니다. ");
	}
}