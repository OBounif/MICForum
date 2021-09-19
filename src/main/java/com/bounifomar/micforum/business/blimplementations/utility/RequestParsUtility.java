package com.bounifomar.micforum.business.blimplementations.utility;

import javax.servlet.http.HttpServletRequest;

public class RequestParsUtility {
		
	
	public static String getFieldValue(HttpServletRequest request,String field)
	{
		String fieldValue = request.getParameter(field);
		
		if(fieldValue == null || fieldValue.trim().length() == 0 )
				return null;
		else
				return fieldValue.trim();
	}
	
	
}
