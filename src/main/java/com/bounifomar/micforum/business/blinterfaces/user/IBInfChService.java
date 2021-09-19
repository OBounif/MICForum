package com.bounifomar.micforum.business.blinterfaces.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.bounifomar.micforum.business.blexceptions.UnexpectedBehaviorException;

public interface IBInfChService {
	
		public void modUser(HttpServletRequest request,MultipartFile coverPic,MultipartFile profPic,Model model) throws UnexpectedBehaviorException;
		
}
