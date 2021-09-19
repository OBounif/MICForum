package com.bounifomar.micforum.business.blinterfaces.user;


import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.bounifomar.micforum.models.muser.User;

public interface IBSignUpService {

		public User signUp(HttpServletRequest request,Model model);
	
}
