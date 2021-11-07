package com.bounifomar.micforum.business.blimplementations.message;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bounifomar.micforum.business.blexceptions.ActivityException;
import com.bounifomar.micforum.business.blexceptions.NotificationException;
import com.bounifomar.micforum.business.blinterfaces.message.IBActivityService;
import com.bounifomar.micforum.models.mmessage.Activity;
import com.bounifomar.micforum.models.mmessage.ActivityType;
import com.bounifomar.micforum.models.muser.User;
import com.bounifomar.micforum.repositories.ActivityDAO;

@Service
public class IBActivityServiceImp implements IBActivityService{

	/*
	 * 	-1 User not found;
	 *  -2 Activity == NULL or invalid
	 *  -3 save() error
	 *  -0 everything went well
	 */
	
	@Autowired
	private ActivityDAO activityRep;
	
	public void pushActivity(User user,ActivityType activity_type,Date activityDate,String message)throws ActivityException
	{
			if(user == null )
				throw new ActivityException("[ACTIVITY] USER == NULL");
			
			Activity activity = new Activity();
			activity.setActivity_owner(user);
			activity.setActivity_message(message);
			activity.setActivity_date(activityDate);
			
			switch (activity_type) {
			case FORUM_FOLLOW:
				activity.setActivity_type(activity_type);
				break;
			case THREAD_FEEDBACK:
				activity.setActivity_type(activity_type);
				break;
			case TOPIC_FOLLOW:
				activity.setActivity_type(activity_type);
				break;
				
			case USER_NEWFRIEND:
				activity.setActivity_type(activity_type);

				break;
			case USER_PROMOTION:
				activity.setActivity_type(activity_type);

				break;
			default:
		
				throw new ActivityException("[ACTIVITY] INVALID ACTIVITY TYPE");
			}
			
			try {
				activityRep.save(activity);

			} catch (Exception e) {
				throw new NotificationException("[ACTIVITY] "+e.getMessage());			}
			}
	
}
