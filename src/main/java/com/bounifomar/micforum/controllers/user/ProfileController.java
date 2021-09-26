package com.bounifomar.micforum.controllers.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/profile")
public class ProfileController {
	
	
	
	
	@RequestMapping("${user_name}")
	public String getProfile(HttpSession session,@PathVariable String user_name,Model model)
	{
		
		return "profile";
	}
}
