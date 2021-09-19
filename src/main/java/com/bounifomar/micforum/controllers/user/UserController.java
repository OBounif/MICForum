package com.bounifomar.micforum.controllers.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bounifomar.micforum.business.blexceptions.UnexpectedBehaviorException;
import com.bounifomar.micforum.business.blinterfaces.user.IBInfChService;



@Controller
@RequestMapping("/user")
public class UserController {
	

	
	@Autowired
	private IBInfChService chS;
	
	@GetMapping("/userSetting")
	public String userSetting_get(HttpSession session)
	{
		return "usersetting";
	}

	@PostMapping("/userSetting")
	public String userSetting_post(HttpServletRequest request,@RequestParam(name = "user_coverpic",required = false)MultipartFile coverpic,@RequestParam(name="user_profpic",required = false)MultipartFile picprof,Model model)
	{
			chS.modUser(request, coverpic, picprof, model);	
			return "usersetting";	
	}
	
	
	@ResponseBody
	@ExceptionHandler(UnexpectedBehaviorException.class)
	public String handler(HttpServletRequest request,Exception ex)
	{
		return ""+ex+"\n"+request.getRequestURL();
	}
}
