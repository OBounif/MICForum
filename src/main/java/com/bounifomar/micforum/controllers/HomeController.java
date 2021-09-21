package com.bounifomar.micforum.controllers;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bounifomar.micforum.business.blexceptions.UnexpectedBehaviorException;
import com.bounifomar.micforum.business.blinterfaces.forum.IBGetService;
import com.bounifomar.micforum.business.blinterfaces.user.IBAuthService;
import com.bounifomar.micforum.business.blinterfaces.user.IBSignUpService;
import com.bounifomar.micforum.models.muser.User;

@Controller
@RequestMapping("/")



public class HomeController {

		private static final String SESSION_USER_ATTR = "USER_SESS";
		private static final String MODEL_USER_ATTRIBUTE = "USER_MODEL";
		
		
		private static final String ERROR_ATTRIBUTE = "ERRORS";
		
		@Autowired
		private IBAuthService authS;
		
		@Autowired
		private IBSignUpService SupS;
		
		
		@Autowired
		private IBGetService getS;
	
	/*	
		@RequestMapping("{id}")
		public String test(@PathVariable String id)
		{
			return id;
		}*/
		
		
		@RequestMapping(path = {"/","/home"})
		public String home(Model model)
		{
			if(getS.getForum(model))
				return "home";
			else
				return "error";
		}
		
		@RequestMapping(path = "/signUp",method = RequestMethod.GET)
		public String signUp(HttpSession session)
		{
			if(session.getAttribute(SESSION_USER_ATTR) == null)
				return "signUp";
			else
				return "redirect:/home";	
		}
		
		@SuppressWarnings("unchecked")
		@RequestMapping(path = "/signUp",method = RequestMethod.POST)
		public String signUp_P(HttpServletRequest request,Model model)
		{			
			
			User user = SupS.signUp(request, model);
			Map<String,String> map = (Map<String,String>)model.getAttribute(ERROR_ATTRIBUTE);
			
			if(map.isEmpty())
			{
				HttpSession session = request.getSession();
				
				session.setAttribute(SESSION_USER_ATTR, user);
				return "redirect:/home";
			}
			else
			{
				model.addAttribute(MODEL_USER_ATTRIBUTE, user);
				return "signUp";
			}
		}
		
		
		
		@RequestMapping(path = "/signIn",method = RequestMethod.GET)
		public String signIn(HttpSession session)
		{
			if(session.getAttribute(SESSION_USER_ATTR) == null)
				return "signIn";
			else
				return "redirect:/home";
			
		}
		
		
		@SuppressWarnings("unchecked")
		@RequestMapping(path = "/signIn",method = RequestMethod.POST)
		public String signIn_P(HttpServletRequest request,Model model)
		{
				User user = authS.signIn(request, model);
				Map<String,String> map = (Map<String,String>)model.getAttribute(ERROR_ATTRIBUTE);
				
			
				if(map.isEmpty())
				{
					HttpSession session = request.getSession();	
					session.setAttribute(SESSION_USER_ATTR, user);
					
					return "redirect:/home";
				}
				else
				{
					model.addAttribute(MODEL_USER_ATTRIBUTE, user);
					return "signIn";	
				}
		}
		
		
		@RequestMapping("/logout")
		public String logout(HttpSession session)
		{
			if(session.getAttribute(SESSION_USER_ATTR) == null)
				return "error";
			else
			{
				session.invalidate();
				return "redirect:/home";
			}
		}
		
	
		@ResponseBody
		@ExceptionHandler(UnexpectedBehaviorException.class)
		public String handler(HttpServletRequest request,Exception ex)
		{
			return ""+ex+"\n"+request.getRequestURL();
		}
		
	
}
