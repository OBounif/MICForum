package com.bounifomar.micforum.business.blimplementations.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bounifomar.micforum.business.blinterfaces.user.IBGetUsersService;
import com.bounifomar.micforum.models.muser.User;
import com.bounifomar.micforum.repositories.UserDAO;

@Service
public class IBGetUsersServiceImp implements IBGetUsersService {
	
	private final static String USER_R_ATTRIBUTE = "USER_ATTR";
	
	@Autowired
	private UserDAO userRep;
	
//	@Autowired
	//private TopicDAO topicRep;
	
	
	
	@Override
	public Boolean getUser(String user_name, Model model) {
		
		String user_name_s = (user_name == null || user_name.trim().isEmpty() ) ? null : user_name.trim();
		
		if(user_name_s == null)
			return false;
		
		try {
			
			User user = userRep.findUserByUsername(user_name);
			
			if(user == null)
					return false;
			
			model.addAttribute(USER_R_ATTRIBUTE, user);
		} catch (Exception e) {
			System.out.println("[GETUSERS SERVICE] : "+e.getMessage());
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	
	

}
