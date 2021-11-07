package com.bounifomar.micforum.business.blinterfaces.message;

import com.bounifomar.micforum.models.mforum.Forum;
import com.bounifomar.micforum.models.mmessage.Topic;
import com.bounifomar.micforum.models.muser.User;


public interface IBCommentService {
	
	
	public Boolean regComment(Forum forum,User user,Topic topic,String comment);
	public Boolean delComment(Long comment_id);
	
}
