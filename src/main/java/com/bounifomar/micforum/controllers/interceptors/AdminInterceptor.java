package com.bounifomar.micforum.controllers.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.bounifomar.micforum.models.muser.User;
import com.bounifomar.micforum.models.muser.UserRankType;

public class AdminInterceptor implements HandlerInterceptor {
	
	private static final String SESSION_ADMIN_LOGGED = "USER_ADMIN_SESS";
	private static final String SESSION_USER_ATTR = "USER_SESS";

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
			
		User user =(User)request.getSession().getAttribute(SESSION_USER_ATTR);
		
		if(user == null || user.getUser_currRank() == null ||  user.getUser_currRank().getRank_type() != UserRankType.ADMINISTRATOR)
		{
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return false;
		}
		
		
		Boolean isLogged = (Boolean)request.getSession().getAttribute(SESSION_ADMIN_LOGGED);
		
		if(isLogged == null)
		{
			response.sendRedirect(request.getContextPath()+"/checkAdmin");
			return false;
		}
		
		
		
		return true;
	}

}
