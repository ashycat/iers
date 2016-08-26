package com.samsung.iers.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.samsung.iers.dao.SampleDAO;

@Service("sampleService")
public class SampleServiceImpl implements SampleService {

	
	Logger log = Logger.getLogger(this.getClass());
    
    @Resource(name="sampleDAO")
    private SampleDAO sampleDAO;
    
	@Override
	public List<Map<String, Object>> selectBoardList(
			Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sampleDAO.selectBoardList(map);
	}

	
	@Override
	public int insertBoard(Map<String, Object> commandMap) throws Exception {
		// TODO Auto-generated method stub
		
		
		sampleDAO.insertBoard(commandMap);
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("TITLE", "");
		sampleDAO.insertBoard(map1);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map1.put("TITLE", "dkfkdk11322312");
		sampleDAO.insertBoard(map2);
		return 1;
	}

}
