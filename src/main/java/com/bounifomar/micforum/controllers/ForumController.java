package com.bounifomar.micforum.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bounifomar.micforum.business.blinterfaces.forum.IBGetService;

@Controller
@RequestMapping("/forums")
public class ForumController {
		
	@Autowired
	private IBGetService getS;
	
	@GetMapping("/{forumid}")
	public String forum(@PathVariable(required = false) String forumid,Model model)
	{	
			if(getS.getForum(forumid,String.valueOf(0),model))
				return "forum";
			else
				return "error";
	}
	
	@GetMapping("/{forumid}/page-{pageId}")
	public String forumPage(@PathVariable(required = false) String forumid,@PathVariable(required=false) String pageId,Model model)
	{	
			if(getS.getForum(forumid,pageId,model))
				return "forum";
			else
				return "error";
	}

}
