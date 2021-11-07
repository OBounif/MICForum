package com.bounifomar.micforum.business.blinterfaces.message;

import java.util.Date;

import com.bounifomar.micforum.models.mmessage.ActivityType;
import com.bounifomar.micforum.models.muser.User;

public interface IBActivityService {

	
	public void pushActivity(User user,ActivityType activity,Date activityDate,String message);
	
}
