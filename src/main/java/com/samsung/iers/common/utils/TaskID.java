package com.samsung.iers.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class TaskID {
	
	private String job_id;
	public TaskID(String job_id) {
		this.job_id = job_id;
	}
	
	public String CreateTaskID() {
		Random r = new Random();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		
		StringBuffer buffer = new StringBuffer();
		
		String chars[] = 
			    "A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z".split(",");
		for (int i = 0; i < 8; i++) {
			buffer.append(chars[r.nextInt(chars.length)]);
		}
		String rString = buffer.toString();
		
		String id = job_id + "_" + rString + "_" + sdf.format(date);
		System.out.println("TaskID " + id);
		return id;
	}
}
