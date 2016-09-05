package com.samsung.iers.jobs.services.im_grp.imsgad;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

public interface Imsgad01Service {

	
	@Transactional
	List<Map<String, Object>> Job_im_000004D_1(Map<String, Object> commandMap) throws Exception;

	@Transactional
	void insertJob_im_000004D_1toJobTable(Map<String, Object> commandMap) throws Exception;

}
