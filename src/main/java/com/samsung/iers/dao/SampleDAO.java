package com.samsung.iers.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.samsung.iers.common.dao.AbstractDAO;

@Repository("sampleDAO")
public class SampleDAO extends AbstractDAO {

	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return (List<Map<String, Object>>)selectList("sample.selectBoardList", map);
    
	}

	public void insertBoard(Map<String, Object> commandMap) {
		// TODO Auto-generated method stub
		insert("sample.insertBoard", commandMap);
	}

}
