package com.capgemini.unilever.cec.sapientdcs;

import java.util.Map;

public class ContactUsRecordUtils {

	@SuppressWarnings("unchecked")
	public static String getPhoneValue(Object[] objects) {
		if(objects == null || objects != null && objects.length == 0)
			return "";
		for(Object map : objects){
			Map<String,String> map1 = (Map<String,String>)map;
			 if(map1.containsKey("type") && (map1.get("type").equalsIgnoreCase("phone") 
					 || map1.get("type").equalsIgnoreCase("primary") ))
				 return map1.get("value");
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static String getMobileValue(Object[] objects) {
		if(objects == null || objects != null && objects.length == 0)
			return "";
		for(Object map : objects){
			Map<String,String> map1 = (Map<String,String>)map;
			 if(map1.containsKey("type") && map1.get("type").equalsIgnoreCase("mobile"))
				 return map1.get("value");
		}
		return null;
	}

}
