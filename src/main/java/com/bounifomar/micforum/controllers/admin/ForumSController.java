package com.bounifomar.micforum.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bounifomar.micforum.business.blinterfaces.forum.IBRegForum;

@Controller
@RequestMapping("/admin/forumSetting")
public class ForumSController {
	
	private final static String FORUMFATHER_PFIELD = "forum_father";
	private final static String FORUMTITLE_PFIELD = "forum_title";
	private final static String FORUMDESCRIPTION_PFIELD = "forum_description";
	private final static String FORUMVISIBILITY_PFIELD = "forum_visibility";
	
	@Autowired 
	IBRegForum forumS;
	
	@GetMapping
	public String forumSetting_get()
	{
		return "/admin/forumSetting";
	}
	
	@PostMapping("/add_forum")
	public String forumSetting_getForums(@RequestParam(FORUMTITLE_PFIELD) String forum_title ,@RequestParam(FORUMDESCRIPTION_PFIELD)String forum_description
			,@RequestParam(name = FORUMVISIBILITY_PFIELD) String forum_visibility,@RequestParam(FORUMFATHER_PFIELD) String forum_father,Model model )
	{
		forumS.regForum(forum_title,forum_description,forum_visibility,forum_father,model);
		
		return "/admin/forumSetting";
	}
	
	@PostMapping("/change_forum")
	public String forumSetting_postadd()
	{
		return "/admin/forumSetting";
	}
	
	
}
