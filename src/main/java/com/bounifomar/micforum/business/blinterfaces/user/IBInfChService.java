package com.bounifomar.micforum.business.blinterfaces.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.bounifomar.micforum.business.blexceptions.UnexpectedBehaviorException;

public interface IBInfChService {
	
		public void modUser(HttpServletRequest request,Model model) throws UnexpectedBehaviorException;
		
}
