package com.samsung.iers.services;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

public interface SampleService {

	List<Map<String, Object>> selectBoardList(Map<String, Object> commandMap) throws Exception;
	
	@Transactional
	int insertBoard(Map<String, Object> commandMap) throws Exception;

}
