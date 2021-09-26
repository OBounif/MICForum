package com.bounifomar.micforum.business.blimplementations.forum;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bounifomar.micforum.business.blinterfaces.forum.IBGetService;
import com.bounifomar.micforum.models.mforum.Forum;
import com.bounifomar.micforum.models.mmessage.Topic;
import com.bounifomar.micforum.repositories.ForumDAO;
import com.bounifomar.micforum.repositories.TopicDAO;

@Service
public class IBGetServiceImp implements IBGetService{
	
	/*
	 * As mentioned in com.bounifomar.micforum.business.blimplementations.forum.IBGetService interface this class is only here for avoiding calling dao layer from controller
	 */
	
	@Autowired
	private ForumDAO forumRep;
	
	@Autowired
	private TopicDAO topicRep;
	
	private static final String FORUM_ATTRIBUTE = "FORUM_ATTR";
	private static final String TOPIC_ATTRIBUTE = "TOPIC_ATTR";
	private static final String PAGES_COUNT = "PAGE_COUNT";
	private static final String CURRENT_PAGE_COUNT = "CURRENT_PAGE_COUNT";

	private static final Integer SPEC_FORUM_PAGE_SIZE = 15;
	private static final Integer HOME_FORUM_PAGE_SIZE = 5;

	@Override
	public Boolean getForum(String forum_title,String page,Model model) {
		
		Forum forum = null;
		Long page_count = null;
		try
		{
			Integer page_int= Integer.valueOf(page);
			
			
			forum = forumRep.findByForum_title(forum_title);
			if( forum == null)
					return false;
			
			page_count = topicRep.topicsCount(forum.getForum_id());
			List<Topic> topicSet = topicRep.getTopics(forum.getForum_id(), PageRequest.of(page_int, SPEC_FORUM_PAGE_SIZE));
			if(topicSet.isEmpty())
				return false;
			
			
			
			forum.setForum_topics(topicSet);
			
			model.addAttribute(PAGES_COUNT, page_count);
			model.addAttribute(CURRENT_PAGE_COUNT,page_count);
			model.addAttribute(FORUM_ATTRIBUTE,forum);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

		return true;
	}

	@Override
	public Boolean getForumMIC(Model model) {
		
		List<Forum> forums = null;
		List<Topic> topics = null;
		try
		{
			forums = forumRep.findByIdEqualsNull();
			topics = topicRep.getTopics(PageRequest.of(0, HOME_FORUM_PAGE_SIZE));
			
			if(forums == null || topics == null)
					return false;
		
			model.addAttribute(TOPIC_ATTRIBUTE,topics);
			model.addAttribute(FORUM_ATTRIBUTE,forums);
		}catch (Exception e) {
			return false;
		}

		return true;
	}

	@Override
	public void getAllForums(String string_like,Model model) {
		
		List<Forum> forums = null;

		try
		{
			forums = forumRep.findByIdEqualsNull();
			
			if(forums == null)
				return;
			
			model.addAttribute(FORUM_ATTRIBUTE,forums);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
