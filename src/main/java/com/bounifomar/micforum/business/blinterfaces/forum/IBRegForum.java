package com.bounifomar.micforum.business.blinterfaces.forum;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface IBRegForum {
	
	
	
	public Boolean regForum(HttpServletRequest request,Model model);
	
	
}
