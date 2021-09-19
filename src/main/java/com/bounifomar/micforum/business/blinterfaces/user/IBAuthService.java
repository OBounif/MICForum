package com.bounifomar.micforum.business.blinterfaces.user;


import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.bounifomar.micforum.models.muser.User;

public interface IBAuthService {
	
	public User signIn(HttpServletRequest request,Model model);
}
