package com.bounifomar.micforum.business.blimplementations.user;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bounifomar.micforum.business.blexceptions.FormVException;
import com.bounifomar.micforum.business.blinterfaces.user.IBAuthService;
import com.bounifomar.micforum.models.muser.User;
import com.bounifomar.micforum.repositories.UserDAO;


import static com.bounifomar.micforum.business.blimplementations.utility.RequestParsUtility.*;


@Service
public class IBAuthServiceImp implements IBAuthService{
	
	private static String ENCRYPTION_ALGORITHM = "SHA-256";
	
	private static String ERROR_ATTRIBUTE = "ERRORS";
	private static String RESULT_ATTRIBUTE = "RESULT";

	
	private static final String USERNAME_PFIELD = "username";
	private static final String PASSWORD_PFIELD = "password";
	
	private static final Integer MAX_USERNAME_LENGTH = 30;
	private static final Integer MAX_PASSWORD_LENGTH = 30;
	
	private static final Integer MIN_USERNAME_LENGTH = 6;
	private static final Integer MIN_PASSWORD_LENGTH = 6;

	
	@Autowired
	private UserDAO userRep;
	
	
	
	
	/*
	 * Every persistence object will be in managed state because the code below is wrapped into a transaction.So every changes on persistence objects 
	 * will be populated the the database.
	 */
	@Transactional
	@Override
	public User signIn(HttpServletRequest request,Model model) {
		
		Map<String,String> errors = new HashMap<String,String>();
		
		model.addAttribute(ERROR_ATTRIBUTE, errors);
		
		User user = new User();
		
		String username = getFieldValue(request, USERNAME_PFIELD);
		String password = getFieldValue(request, PASSWORD_PFIELD);
		
		
	
		
		this.processPassword(password, user,errors);
		this.processUsername(username, user,errors);


		
		if(errors.isEmpty())
		{
			ConfigurablePasswordEncryptor passwordEncry = new ConfigurablePasswordEncryptor();
			passwordEncry.setAlgorithm(ENCRYPTION_ALGORITHM);
			passwordEncry.setPlainDigest(false);
			
			User tmp = userRep.findUserByUsername(username);
			
			if( tmp == null || !passwordEncry.checkPassword(password, tmp.getUser_password()))
			{
				errors.put(RESULT_ATTRIBUTE, "x");
				model.addAttribute(RESULT_ATTRIBUTE, "Username ou mot de passe incorrecte.");	
			}
			else
			{
				user = tmp;
				user.setUser_lastlogon(new Date());
			}

		}
		else
			model.addAttribute(RESULT_ATTRIBUTE, "Échec de la connexion.");
		
		return user;
	}
	
	private void processUsername(String username,User user,Map<String,String> errors)
	{
		try {
			this.checkUsername(username);
		} catch (FormVException e) {
			errors.put(USERNAME_PFIELD, e.getMessage());
		}
		
		user.setUser_name(username);
	}
	
	private void processPassword(String password,User user,Map<String,String> errors)
	{
		try {
			this.checkPassword(password);

		} catch (FormVException e) {
			errors.put(PASSWORD_PFIELD, e.getMessage());
		}
		user.setUser_password(password);

	}
	
	private void checkUsername(String username)throws FormVException
	{		
			if(username != null)
			{
				if(username.length() < MIN_USERNAME_LENGTH )
					throw new FormVException("Username doit contenire au moins" + MIN_USERNAME_LENGTH+" caractères .");
				
				
				if(username.length() > MAX_USERNAME_LENGTH )
					throw new FormVException("Username ne doit pas dépasser" +MAX_USERNAME_LENGTH+" caractères .");
			
			}
			else
				throw new FormVException("Veuillez saisire votre username .");
	}
	
	private void checkPassword(String password)throws FormVException
	{
	
		if(password != null)
		{
			if(password.length() < MIN_PASSWORD_LENGTH )
				throw new FormVException("Mot de passe doit contenire au moins " + MIN_USERNAME_LENGTH+" caractères .");
			
			
			if(password.length() > MAX_PASSWORD_LENGTH )
				throw new FormVException("Mot de passe ne doit pas dépasser " +MAX_USERNAME_LENGTH+" caractères .");
			
		}
		else
			throw new FormVException("Veuillez saisire votre Mot de passe .");
	}
	

}
