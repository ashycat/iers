package com.samsung.iers.common.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseToJson {

	@SuppressWarnings("null")
	public ResponseToJson(String code, List<Map<String,Object>> list) {
		// TODO Auto-generated constructor stub
		Map<String, List<Map<String,Object>>> tmp = null;
//		tmp.put("code", code);
		tmp.put("contents", list);
	}
	
}
