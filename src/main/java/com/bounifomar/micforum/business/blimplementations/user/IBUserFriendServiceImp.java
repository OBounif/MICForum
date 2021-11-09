package com.bounifomar.micforum.business.blimplementations.user;

import java.util.Date;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bounifomar.micforum.business.blexceptions.ActivityException;
import com.bounifomar.micforum.business.blexceptions.NotificationException;
import com.bounifomar.micforum.business.blexceptions.QueryException;
import com.bounifomar.micforum.business.blexceptions.UnexpectedBehaviorException;
import com.bounifomar.micforum.business.blinterfaces.message.IBActivityService;
import com.bounifomar.micforum.business.blinterfaces.message.IBNotificationService;
import com.bounifomar.micforum.business.blinterfaces.user.IBUserFriendService;
import com.bounifomar.micforum.models.mmessage.ActivityType;
import com.bounifomar.micforum.models.mmessage.NotificationType;
import com.bounifomar.micforum.models.muser.User;
import com.bounifomar.micforum.models.muser.UserFinvitation;
import com.bounifomar.micforum.models.muser.UserFriend;
import com.bounifomar.micforum.repositories.UserDAO;
import com.bounifomar.micforum.repositories.UserFinvitationDAO;
import com.bounifomar.micforum.repositories.UserFriendDAO;


@Service
public class IBUserFriendServiceImp implements IBUserFriendService {
	
	private static final Integer MIN_USERNAME_LENGTH = 6;
	private static final Integer MAX_USERNAME_LENGTH = 20;
	
	@Autowired
	private UserFinvitationDAO userFinRep;
	
	
	@Autowired
	private UserFriendDAO userFriendRep;
	
	@Autowired
	private UserDAO userRep;
	
	
	@Autowired
	private IBNotificationService notifService;
	
	@Autowired
	private IBActivityService activityService;
	
	
	
	
	@Override
	public void sendFriendRequest(User from, String to) throws QueryException{
		
		if(from == null)
			throw new UnexpectedBehaviorException("[USER INVITATION SERVICE IM] User == NULL");
		
		
		if(to.length() > MAX_USERNAME_LENGTH || to.length() < MIN_USERNAME_LENGTH )
			throw new QueryException("Veuillez entrer un nom d'utilisateur valide .");
		
		User user_to = userRep.findUserByUsername(to);
		
		
		if(user_to == null)
			throw new QueryException("Utilisiteur  "+to+" n'existe pas.");

		if(user_to.getUser_name().equals(from.getUser_name()))
			throw new QueryException("Vous ne pouvez pas effectuer cette action.");
		
		
		Optional<UserFinvitation> userInv  =  userFinRep.getUserInvitation(user_to.getUser_id(),from.getUser_id());
		
		
		if(!userInv.isEmpty())
			throw new QueryException("Vous avez déja envoyer une demande d'amitié");
		
		
		Optional<UserFinvitation> userInvOtherway  =  userFinRep.getUserInvitation(from.getUser_id(),user_to.getUser_id());

		
		if(!userInvOtherway.isEmpty())
			throw new QueryException(user_to.getUser_name()+" vous a déja envoyer une demande d'amitié");
		
		
		
		Optional<UserFriend> userFr = userFriendRep.getUserFriend(from.getUser_id(),user_to.getUser_id());
		
		if(!userFr.isEmpty())
			throw new QueryException("Vous êtes déja amis avec " + user_to.getUser_name());

		
		
		
		UserFinvitation userInvitation = new UserFinvitation();
		userInvitation.setUserfinv_from(from);
		userInvitation.setUserfinv_to(user_to);
		
		
		try {
			userFinRep.save(userInvitation);
			notifService.sendNotification(from, user_to, NotificationType.FRIEND_REQUEST, null);
			
			
		}catch (NotificationException e) {
			System.out.println(e.getMessage());
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
			throw new QueryException("Erreur Interne veuillez réessayer ultérieurement");
		}
	}

	@Override
	public void acceptFriendRequest(User uu, String userFriend) {
		
		
		if(uu == null)
			throw new UnexpectedBehaviorException("[USERFRIEND] User == NULL");
		
		if(userFriend.length() > MAX_USERNAME_LENGTH || userFriend.length() < MIN_USERNAME_LENGTH )
			throw new QueryException("Veuillez entrer un nom d'utilisateur valide .");
		
		
		User user = userRep.findUserByUsername(userFriend);
		
		if(user == null)
			throw new QueryException("Utilisiteur  "+userFriend+" n'existe pas.");		
		
		if(user.getUser_name().equals(uu.getUser_name()))
			throw new QueryException("Vous ne pouvez pas effectuer cette action.");
		
		Optional<UserFinvitation> finvitation =   userFinRep.getUserInvitation(uu.getUser_id(),user.getUser_id());
		
		if(finvitation.isEmpty())
			throw new QueryException(user.getUser_name() +  "n'a pas envoyé une invitation .");
		
		
		UserFinvitation invite = finvitation.get();
		
		try
		{
			Date date_of_friendShip = new Date();
			
			UserFriend uf = new UserFriend();
			uf.setUserFriend_user(uu);
			uf.setUserFriend_userFr(user);
			uf.setUserFriend_dateOfFriendship(date_of_friendShip);
		
			userFriendRep.save(uf);
			
			uf = new UserFriend();
			uf.setUserFriend_user(user);
			uf.setUserFriend_userFr(uu);
			uf.setUserFriend_dateOfFriendship(date_of_friendShip);
			
			userFriendRep.save(uf);
			userFinRep.delete(invite);
		
			
			
			activityService.pushActivity(user, ActivityType.USER_NEWFRIEND,date_of_friendShip, uu.getUser_name());
			activityService.pushActivity(uu, ActivityType.USER_NEWFRIEND,date_of_friendShip, user.getUser_name());
			
			notifService.sendNotification(uu, user, NotificationType.ACCEPT_FRIENDREQUEST, null);
	
		}catch (ActivityException | NotificationException e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			throw new QueryException("Erreur Interne veuillez réessayer ultérieurement");
		}
		
		
		
	}
	
	@Override
	public void rejectFriendRequest(User user_sess, String userFriend) {
			
		
		
		
		if(user_sess == null)
			throw new UnexpectedBehaviorException("[USERFRIEND] User == NULL");
		
		
		if(userFriend.length() > MAX_USERNAME_LENGTH || userFriend.length() < MIN_USERNAME_LENGTH )
			throw new QueryException("Veuillez entrer un nom d'utilisateur valide .");
		
		
		User user = userRep.findUserByUsername(userFriend);
		
		if(user == null)
			throw new QueryException("Utilisiteur  "+userFriend+" n'existe pas.");	
		
		if(user.getUser_name().equals(user_sess.getUser_name()))
			throw new QueryException("Vous ne pouvez pas effectuer cette action.");
		
		
		
		Optional<UserFinvitation> finvitation =   userFinRep.getUserInvitation(user_sess.getUser_id(),user.getUser_id());

		if(finvitation.isEmpty())
			throw new QueryException(user.getUser_name() +  "n'a pas envoyé une invitation .");

		UserFinvitation invitation = finvitation.get();
		
		try {
			userFinRep.delete(invitation);
		} catch (Exception e) {
			throw new QueryException("Erreur Interne veuillez réessayer ultérieurement");
		}
		
	}
	
	
	

	@Override
	public void cancelFriendRequest(User user_f, String user_t) {
		
		
	

		if(user_f == null)
			throw new UnexpectedBehaviorException("[USER INVITATION SERVICE IMP] User == NULL");
		
		if(user_t.length() > MAX_USERNAME_LENGTH || user_t.length() < MIN_USERNAME_LENGTH )
			throw new QueryException("Veuillez entrer un nom d'utilisateur valide .");
		
		
		User user_to = userRep.findUserByUsername(user_t);
		
		if(user_to == null)
			throw new QueryException("Utilisiteur  "+user_t+" n'existe pas.");		
		
		if(user_to.getUser_name().equals(user_f.getUser_name()))
			throw new QueryException("Vous ne pouvez pas effectuer cette action.");
		
		
		
		Optional<UserFinvitation> finvitation =   userFinRep.getUserInvitation(user_to.getUser_id(),user_f.getUser_id());
		

		if(finvitation.isEmpty())
			return;
		
		UserFinvitation invite = finvitation.get();
		
		try {
			userFinRep.delete(invite);

		} catch (Exception e) {
			throw new QueryException("Erreur Interne veuillez réessayer ultérieurement");
		}
	
	}

	

	@Override
	public void removeFriend(User from, String user_t) {
		
		if(from == null)
			throw new UnexpectedBehaviorException("[USERFRIEND] User == NULL");
		
		if(user_t.length() > MAX_USERNAME_LENGTH || user_t.length() < MIN_USERNAME_LENGTH )
			throw new QueryException("Veuillez entrer un nom d'utilisateur valide .");
		
		
		
		
		User user_to = userRep.findUserByUsername(user_t);
		 
		if(user_to == null)
			throw new QueryException("Utilisiteur  "+user_t+" n'existe pas.");
		
		if(user_to.getUser_name().equals(from.getUser_name()))
			throw new QueryException("Vous ne pouvez pas effectuer cette action.");
		
		
		Optional<UserFriend> uf = userFriendRep.getUserFriend(from.getUser_id(), user_to.getUser_id());
		Optional<UserFriend> uff = userFriendRep.getUserFriend(user_to.getUser_id(), from.getUser_id());
		
		if(uf.isEmpty())
			throw new QueryException(user_t+" n'est pas votre amis");
		
		if(uff.isEmpty())
			throw new UnexpectedBehaviorException("[USERFRIEND SERVICE] UserFriend one way constraint violation");
		
	
		
		try {
			userFriendRep.delete(uf.get());
			userFriendRep.delete(uff.get());
		} catch (Exception e) {
			throw new QueryException("Erreur Interne veuillez réessayer ultérieurement");
		}
	}



	
	
}
