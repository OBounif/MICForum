package com.bounifomar.micforum.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/forumSetting")
public class ForumSController {

	
	@RequestMapping
	public String forumSetting()
	{
		return "/admin/forumSetting";
	}
	
	
}
