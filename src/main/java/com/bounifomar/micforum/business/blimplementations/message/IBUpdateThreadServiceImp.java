package com.bounifomar.micforum.business.blimplementations.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bounifomar.micforum.business.blinterfaces.generic.IBUpdateService;
import com.bounifomar.micforum.models.mmessage.Topic;
import com.bounifomar.micforum.repositories.TopicDAO;


@Service
public class IBUpdateThreadServiceImp implements IBUpdateService<Topic> {

	
	@Autowired
	private TopicDAO topicRep;
	
	@Override
	public void updateViewNumber(Topic topic) {
		
		try {
			topic.setTopic_view_number(topic.getTopic_view_number() + 1);
			topicRep.save(topic);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateCommentsNumber(Topic topic) {

		try {
			topic.setTopic_comments_number(topic.getTopic_comments_number() + 1 );
			topicRep.save(topic);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}



	
	
	

}
