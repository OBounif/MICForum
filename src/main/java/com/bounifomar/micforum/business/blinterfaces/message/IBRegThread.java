package com.bounifomar.micforum.business.blinterfaces.message;

import org.springframework.ui.Model;

import com.bounifomar.micforum.models.mforum.Forum;
import com.bounifomar.micforum.models.muser.User;

public interface IBRegThread {

	
	public void regThread(String threadContext,String threadTitle,String threadText,User user,Forum forum,Model model);
	
	
}
