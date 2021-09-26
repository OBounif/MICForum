package com.bounifomar.micforum.business.blinterfaces.forum;


import org.springframework.ui.Model;

public interface IBGetService {
		
		/*
		 * 	This interface is here just for avoiding calling dao layer from controller
		 */
		
		public Boolean getForum(String page_number,String page,Model model);
		
		public Boolean getForumMIC(Model model);
		
		public void getAllForums(String string_like,Model model);
	
}
