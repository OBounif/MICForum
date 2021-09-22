package com.bounifomar.micforum.controllers.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoggedUserInterceptor implements HandlerInterceptor {
	
	private static final String SESSION_USER_ATTR = "USER_SESS";

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
			HttpSession session= request.getSession();
			
			if(session.getAttribute(SESSION_USER_ATTR) == null)
			{
				response.sendRedirect(request.getContextPath()+"/signIn");
				return false;
			}
			
			return true;
	}
	
}
