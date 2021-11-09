package com.bounifomar.micforum.business.blimplementations.user;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bounifomar.micforum.business.blexceptions.QueryException;
import com.bounifomar.micforum.business.blexceptions.UnexpectedBehaviorException;
import com.bounifomar.micforum.business.blinterfaces.message.IBNotificationService;
import com.bounifomar.micforum.business.blinterfaces.user.IBUserFollowService;
import com.bounifomar.micforum.models.mmessage.NotificationType;
import com.bounifomar.micforum.models.muser.User;
import com.bounifomar.micforum.models.muser.UserFollow;
import com.bounifomar.micforum.repositories.UserDAO;
import com.bounifomar.micforum.repositories.UserFollowDAO;


@Service
public class IBUserFollowServiceImp implements IBUserFollowService {

	private static final Integer MIN_USERNAME_LENGTH = 6;
	private static final Integer MAX_USERNAME_LENGTH = 20;


	@Autowired private UserFollowDAO userFollowRep;
	
	@Autowired private UserDAO userRep;
	
	@Autowired private IBNotificationService notificationService;
		
	
	@Override
	public void follow_user(User user, String user_name)throws UnexpectedBehaviorException,QueryException {
		
		
		
		if(user == null)
			throw new UnexpectedBehaviorException("[FOLLOW SERVICE] User == NULL");
		
		if(user_name.length() > MAX_USERNAME_LENGTH || user_name.length() < MIN_USERNAME_LENGTH )
			throw new QueryException("Veuillez entrer un nom d'utilisateur valide .");

		
		User user_to = userRep.findUserByUsername(user_name);
		
		
		if(user_to == null)
			throw new QueryException("Utilisiteur  "+user_name+" n'existe pas.");
		
		if(user_to.getUser_name().equals(user.getUser_name()))
			throw new QueryException("Vous ne pouvez pas effectuer cette action.");
		
		Optional<UserFollow> uf_optional = userFollowRep.getUserFollow(user_to.getUser_id(), user.getUser_id());
		
		if(!uf_optional.isEmpty())
			throw new QueryException("Vous suivez déja "+user_to.getUser_name());
		
		Date dateof_follow = new Date();
		
		UserFollow uf = new UserFollow();
		uf.setUserFollow_userId(user_to);
		uf.setUserFollow_followerId(user);
		uf.setUserFriend_dateOfFollow(dateof_follow);
		
		try {
			userFollowRep.save(uf);
			notificationService.sendNotification(user, user_to, NotificationType.FOLLOW,null);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new QueryException("Erreur Interne veuillez réessayer ultérieurement");		}
	}
	
	

	@Override
	public void unfollow_user(User user, String user_name) throws UnexpectedBehaviorException,QueryException{
		
		if(user_name.length() > MAX_USERNAME_LENGTH || user_name.length() < MIN_USERNAME_LENGTH )
			throw new QueryException("Veuillez entrer un nom d'utilisateur valide .");
		
		if(user == null)
			throw new UnexpectedBehaviorException("[FOLLOW SERVICE] User == NULL");
		
		
		User user_to = userRep.findUserByUsername(user_name);
		
		
		if(user_to == null)
			throw new QueryException("Utilisiteur  "+user_name+" n'existe pas.");
		
		if(user_to.getUser_name().equals(user.getUser_name()))
			throw new QueryException("Vous ne pouvez pas effectuer cette action.");
		
		Optional<UserFollow> uf_optional = userFollowRep.getUserFollow(user_to.getUser_id(), user.getUser_id());
		
		if(uf_optional.isEmpty())
			throw new QueryException("Vous ne suivez pas "+user_name);
		
		UserFollow uf = uf_optional.get();

		
		try {
			userFollowRep.delete(uf);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new QueryException("Erreur Interne veuillez réessayer ultérieurement");		}
	}

}
