package com.bounifomar.micforum.controllers.admin;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	//private static final String SESSION_USER_ATTR = "USER_SESS";

	
	@RequestMapping
	@ResponseBody
	public String home(HttpSession session)
	{
		return "";
	}
	
	
}
