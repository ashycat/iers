package com.samsung.iers.services.job;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

public interface JobService {

	
	@Transactional
	void deleteTestDBCol(Map<String, Object> commandMap) throws Exception;

	@Transactional
	void insertTestDBCol(Map<String, Object> commandMap) throws Exception;

}
