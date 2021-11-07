package com.bounifomar.micforum.business.blimplementations.message;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bounifomar.micforum.business.blexceptions.UnexpectedBehaviorException;
import com.bounifomar.micforum.business.blinterfaces.forum.IBUpdateForumService;
import com.bounifomar.micforum.business.blinterfaces.generic.IBUpdateService;
import com.bounifomar.micforum.business.blinterfaces.message.IBCommentService;
import com.bounifomar.micforum.models.mforum.Forum;
import com.bounifomar.micforum.models.mmessage.Comment;
import com.bounifomar.micforum.models.mmessage.Topic;
import com.bounifomar.micforum.models.muser.User;
import com.bounifomar.micforum.repositories.CommentDAO;
import com.bounifomar.micforum.repositories.TopicDAO;
import com.bounifomar.micforum.repositories.UserDAO;

@Service
public class IBCommentServiceImp implements IBCommentService {

	@Autowired
	private TopicDAO topicRep;
	
	@Autowired
	private CommentDAO commentRep;
	
	@Autowired
	private UserDAO userRep;
	
	@Autowired
	private IBUpdateService<Topic> topicUS;
	
	
	@Autowired
	private IBUpdateForumService forumUS;

	
	public Boolean regComment(Forum forum,User user, Topic topic, String comment) {
		
		
		if(user == null)
			throw new UnexpectedBehaviorException("[THREAD SERVICE] User == null");
		
		String comment_s = (comment == null || comment.trim().isEmpty() ) ? null : comment.trim();
		if(comment_s == null)
			return false;
		
		Comment commentt = new Comment();
		commentt.setComment_date(new Date());
		commentt.setComment_topic(topic);
		commentt.setComment_message(comment_s);
		commentt.setComment_user(user);
		
		try {
			user.setUser_topic_number(user.getUser_topic_number()+1);
			topic.setTopic_reviver(user);
			topic.setTopic_dateOfreviv(new Date());
			
			topicRep.save(topic);
			userRep.save(user);
			commentRep.save(commentt);
			
			forumUS.updateCommentsNumber(forum);
			topicUS.updateCommentsNumber(topic);
			
			
			return true;
			
			
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean delComment(Long comment_id) {
		return null;
	}

}
