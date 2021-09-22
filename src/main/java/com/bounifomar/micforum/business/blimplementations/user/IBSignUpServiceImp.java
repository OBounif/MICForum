package com.bounifomar.micforum.business.blimplementations.user;

import org.apache.commons.validator.routines.EmailValidator;
import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bounifomar.micforum.business.blexceptions.FormVException;
import com.bounifomar.micforum.business.blexceptions.UnexpectedBehaviorException;
import com.bounifomar.micforum.business.blinterfaces.user.IBSignUpService;
import com.bounifomar.micforum.models.muser.User;
import com.bounifomar.micforum.models.muser.UserRank;
import com.bounifomar.micforum.models.muser.UserRankType;
import com.bounifomar.micforum.repositories.UserDAO;
import com.bounifomar.micforum.repositories.UserRankDAO;


import static com.bounifomar.micforum.business.blimplementations.utility.RequestParsUtility.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


@Service
public class IBSignUpServiceImp implements IBSignUpService {
	
	private final static String DEFAULT_PROF_PIC_PATH = "png.png";
	private final static String DEFAULT_COVER_PIC_PATH = "micLeet.png";

	
	private final static String ENCRYPTION_ALGORITHM = "SHA-256";
	
	private final static String ERROR_ATTRIBUTE = "ERRORS";
	private final static String RESULT_ATTRIBUTE = "RESULT";
	
	private static final String USERNAME_PFIELD = "username";
	private static final String PASSWORD_PFIELD = "password";
	private static final String PASSWORD_CONF_PFIELD = "password_conf";
	private static final String EMAIL_PFIELD ="email";
	
	private static final Integer MAX_USERNAME_LENGTH = 20;
	private static final Integer MAX_PASSWORD_LENGTH = 20;
	
	private static final Integer MIN_USERNAME_LENGTH = 6;
	private static final Integer MIN_PASSWORD_LENGTH = 6;
	
	@Autowired
	private UserDAO userRep;
	
	@Autowired 
	UserRankDAO rankRep;

	@Override
	public User signUp(HttpServletRequest request,Model model)throws UnexpectedBehaviorException {
		
		Map<String,String> errors = new HashMap<String,String>();

		model.addAttribute(ERROR_ATTRIBUTE, errors);

		
		String username = getFieldValue(request, USERNAME_PFIELD);
		String password = getFieldValue(request, PASSWORD_PFIELD);
		String passwordConf = getFieldValue(request, PASSWORD_CONF_PFIELD);
		String email = getFieldValue(request, EMAIL_PFIELD);
		
		User user = new User();
		
		this.processUsername(username, user,errors);
		this.processEmail(email, user,errors);
		this.processPassword(password, user,errors);
		
		user.setUser_passwordConf(passwordConf);
		
		if(errors.isEmpty())
		{
			/*Check if password fields are equal*/
			if(user.checkPassword())
			{
				ConfigurablePasswordEncryptor passwordEncry = new ConfigurablePasswordEncryptor();
				passwordEncry.setAlgorithm(ENCRYPTION_ALGORITHM);
				passwordEncry.setPlainDigest(false);
				
				user.setUser_password(passwordEncry.encryptPassword(user.getUser_password()));
				
				user.setUser_pic_path(DEFAULT_PROF_PIC_PATH);
				user.setUser_coverpic_path(DEFAULT_COVER_PIC_PATH);
				
				
				UserRank rank = rankRep.findUserRankByRankType(UserRankType.NEWBIE);
				
				if(rank == null)
					throw new UnexpectedBehaviorException("[SINGUP SERVICE] RANK == NULL");
					
				
				user.setUser_regdate(new Date());
				user.setUser_lastlogon(new Date());
				user.setUser_currRank(rank);
				
				
				try {
					userRep.save(user);
				} catch (Exception e) {
					e.printStackTrace();
					model.addAttribute(RESULT_ATTRIBUTE,"Échec de la création .");
					errors.put(RESULT_ATTRIBUTE, "Échec de la création .");
					
					return user;
				}
				
				model.addAttribute(RESULT_ATTRIBUTE,"Votre compte a été créer avec succès .");
			}
			else
			{	
				model.addAttribute(RESULT_ATTRIBUTE,"Les mots de passe ne correspondent pas .");
				errors.put(RESULT_ATTRIBUTE, "Les mots de passe ne correspondent pas.");
			}
		}
		else
			model.addAttribute(RESULT_ATTRIBUTE,"Échec de la création .");	
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
	
	private void processEmail(String email,User user,Map<String,String> errors)
	{
		try {
			this.checkEmail(email);
		} catch (FormVException e) {
			errors.put(EMAIL_PFIELD, e.getMessage());
		}
		user.setUser_email(email);
	}
	
	private void checkUsername(String username)throws FormVException
	{
			if(username != null)
			{
				if(username.length() < MIN_USERNAME_LENGTH )
					throw new FormVException("Username doit contenire au moins " + MIN_USERNAME_LENGTH+" caractères .");
				if(username.length() > MAX_USERNAME_LENGTH )
					throw new FormVException("Username ne doit pas dépasser " +MAX_USERNAME_LENGTH+" caractères .");
				
				User user = userRep.findUserByUsername(username);
						
				if(user!=null)
					throw new FormVException("Username que vous avez saisie existe déja .");		

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
			throw new FormVException("Veuillez saisire votre username .");
	}
	
	private void checkEmail(String email)throws FormVException
	{	
		if(email != null)
		{
			boolean valid = EmailValidator.getInstance().isValid(email);
			if(valid)
			{
			/*
			 *  Check if the email exist in the persistence unit 
			 */
				User user = userRep.findUserByEmail(email);
				
				if(user != null)
					throw new FormVException("L'email que vous avez saisie existe déja .");		
			}
			else
				throw new FormVException("Veuillez  saisire un email valid .");
		}
		else
			throw new FormVException("Veuillez saisire votre adresse mail");
	}
	
}
