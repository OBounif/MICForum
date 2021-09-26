package com.bounifomar.micforum.business.blinterfaces.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.bounifomar.micforum.business.blexceptions.UnexpectedBehaviorException;
import com.bounifomar.micforum.models.muser.User;

public interface IBInfChService {
	
		public void modUser(HttpServletRequest request,Model model) throws UnexpectedBehaviorException;
		
		public void modPass(User user,String oldpassword,String newpassword,String newpasswordConf,Model model);
}
