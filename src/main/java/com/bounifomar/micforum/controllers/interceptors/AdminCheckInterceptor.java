package com.bounifomar.micforum.controllers.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.bounifomar.micforum.models.muser.User;
import com.bounifomar.micforum.models.muser.UserRankType;

public class AdminCheckInterceptor implements HandlerInterceptor {
	
	private static final String SESSION_USER_ATTR = "USER_SESS";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
				
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(SESSION_USER_ATTR);
	
		if(user == null || user.getUser_currRank() == null || user.getUser_currRank().getRank_type() != UserRankType.ADMINISTRATOR)
		{
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return false;
		}
			
		return true;
	}
}
