package com.bounifomar.micforum.business.blinterfaces.forum;


import org.springframework.ui.Model;


public interface IBRegForum {
	
	
	
	public void regForum(String forum_titlep,String forum_descriptionp,String forum_visibilityp,String forum_fatherp,Model model);
	
	
}
