package com.bounifomar.micforum.controllers.user;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bounifomar.micforum.business.blexceptions.UnexpectedBehaviorException;
import com.bounifomar.micforum.business.blinterfaces.user.IBInfChService;
import com.bounifomar.micforum.models.muser.User;



@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final String SESSION_USER_ATTR = "USER_SESS";

	private static final String USER_OLD_PASSWORD = "user_oldpass";
	private static final String USER_NEW_PASSWORD = "user_newpass";
	private static final String USER_NEW_CONF_PASSWORD = "user_newpassconf";

	
	private static final String USERCOVERPIC_PFIELD = "user_coverpic";
	private static final String USERPROFPIC_PFIELD = "user_profpic";
	
	@Autowired
	private IBInfChService chS;
	
	@GetMapping("/userSetting")
	public String userSetting_get(HttpSession session)
	{
		return "usersetting";
	}

	@PostMapping("/userSetting")
	public String userSetting_post(HttpServletRequest request,@RequestParam(name = USERCOVERPIC_PFIELD)Part coverpic,
															 @RequestParam(name=USERPROFPIC_PFIELD)Part picprof,
															 Model model)
	{
			chS.modUser(request,model);	
			return "usersetting";	
	}
	

	@PostMapping("/change_password")
	public String userSetting_passwordCh(HttpSession session,@RequestParam(name = USER_OLD_PASSWORD)String old_password,
															@RequestParam(name = USER_NEW_PASSWORD)String new_password,
															@RequestParam(name = USER_NEW_CONF_PASSWORD)String new_passwordConf,
															Model model)
	{	
		User user = (User) session.getAttribute(SESSION_USER_ATTR);
		chS.modPass(user, old_password, new_password, new_passwordConf, model);
		
		return "usersetting";
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:/home";
	}
	
	
	
	@ResponseBody
	@ExceptionHandler(UnexpectedBehaviorException.class)
	public String handler(HttpServletRequest request,Exception ex)
	{
		return ""+ex+"\n"+request.getRequestURL();
	}
	
	
	
}
