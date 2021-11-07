package com.bounifomar.micforum.business.blimplementations.message;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bounifomar.micforum.business.blexceptions.NotificationException;
import com.bounifomar.micforum.business.blexceptions.UnexpectedBehaviorException;
import com.bounifomar.micforum.business.blinterfaces.message.IBNotificationService;
import com.bounifomar.micforum.models.mmessage.Notification;
import com.bounifomar.micforum.models.mmessage.NotificationType;
import com.bounifomar.micforum.models.muser.User;
import com.bounifomar.micforum.repositories.NotificationDAO;

@Service
public class IBNotificationServiceImp implements IBNotificationService {

	/*
	 *	0 -Everything is okay !	 
	 * -1 -User_to not found
	 *  1 -User_from not found
	 * -2 -Note_type == NULL OR INVALID
	 * -3 -save() error
	 */
	

	@Autowired
	private NotificationDAO notRep;
	
	@Override
	public void sendNotification(User from,User user_to,NotificationType note_type,String notification_message) throws UnexpectedBehaviorException,NotificationException {
		
		
		if(from == null)
			throw new NotificationException("[NOTIFICATION] USER_FROM == NULL");
		
		
		if(user_to == null)
			throw new NotificationException("[NOTIFICATION] USER_TO == NULL");
		
		Notification notif = new Notification();
		
		notif.setNotification_date(new Date());
		notif.setNotification_from(from);
		notif.setNotification_owner(user_to);
		notif.setNotification_message(notification_message);
		
		switch (note_type) {
		
			case FRIEND_REQUEST:
				notif.setNotification_type(note_type);
				break;
			case FORUMFOLLOW_POST:
				notif.setNotification_type(note_type);

				break;
			case FRIEND_POST:
				notif.setNotification_type(note_type);

				break;
			case FOLLOW:
				notif.setNotification_type(note_type);
				break;
			case PROMOTION:
				notif.setNotification_type(note_type);
				break;
			case REPLY_THREAD:
				notif.setNotification_type(note_type);
				break;
			case MICMESSAGE:
				notif.setNotification_type(note_type);
				break;
				
			default:
				throw new NotificationException("[NOTIFICATION] NOTE TYPE INVALID");
				
		}
		
		try {
			notRep.save(notif);
		} catch (Exception e) {
			throw new NotificationException("[NOTIFICATION] "+e.getMessage());

		}
		
	}

}
