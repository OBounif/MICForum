package com.bounifomar.micforum.business.blinterfaces.message;


import com.bounifomar.micforum.models.mmessage.NotificationType;
import com.bounifomar.micforum.models.muser.User;

public interface IBNotificationService {
	
	
	public void sendNotification(User from,User user_to,NotificationType note_type,String notification_message);
	
	
}
