package com.samsung.iers.common.utils;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonTemplate {

	public ObjectMapper om = new ObjectMapper();

	protected Log log = LogFactory.getLog(JsonTemplate.class);
	protected void printJSON(Object data) {
		if(log.isDebugEnabled()){
			log.debug("\t data  \t:  " + data);
		}
	}
	
	public String list2Data(Object data) throws JsonGenerationException, JsonMappingException, IOException{
		printJSON(data);
		printJSON(om.writeValueAsString(data));
		
		return om.writeValueAsString(data);
	}
	
	public Object data2List(String queryId, Object params){
//		printQueryId(queryId);
//		return sqlSession.update(queryId, params);
		return null;
	}
	
}
