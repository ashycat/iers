package com.samsung.iers.common.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConvertList {

	public String toHtmlTable(List<Map<String, Object>> list){
		
		if(list.size() == 0){
			return null;
		}

		String htmlTable = "<table margin='20px' border='thin solid black' >";
		String[] keys = null;

		Set<String> keySet = list.get(0).keySet();
		keys = keySet.toArray(new String[keySet.size()]);
		
		htmlTable = htmlTable+"<tr>";
		
		for (int i = 0; i < keys.length; i++) {
			htmlTable = htmlTable+"<td>"+keys[i] + "</td>";
		}
		htmlTable = htmlTable+"</tr>";
		for (int i = 0; i < list.size(); i++) {
			htmlTable = htmlTable+"<tr>";
			for (int j = 0; j < keys.length; j++) {
				htmlTable = htmlTable+"<td>"+list.get(i).get(keys[j])+"</td>";
			}
			htmlTable = htmlTable+"</tr>";
		}
		
		htmlTable = htmlTable+"</table>";
		System.out.println(htmlTable);
		return htmlTable;
	}
}
