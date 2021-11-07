package com.bounifomar.micforum.business.blimplementations.message;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bounifomar.micforum.business.blexceptions.FormVException;
import com.bounifomar.micforum.business.blexceptions.UnexpectedBehaviorException;
import com.bounifomar.micforum.business.blinterfaces.forum.IBUpdateForumService;
import com.bounifomar.micforum.business.blinterfaces.generic.IBUpdateService;
import com.bounifomar.micforum.business.blinterfaces.message.IBRegThread;
import com.bounifomar.micforum.models.mforum.Forum;
import com.bounifomar.micforum.models.mmessage.Comment;
import com.bounifomar.micforum.models.mmessage.Topic;
import com.bounifomar.micforum.models.muser.User;
import com.bounifomar.micforum.repositories.CommentDAO;
import com.bounifomar.micforum.repositories.TopicDAO;


@Service
public class IBRegThreadImp implements IBRegThread {
	
	private static String ERROR_ATTRIBUTE = "ERRORS";
	private static final String RESULT_ATTRIBUTE = "RESULT";

	
	private static final  Integer MAX_THREAD_TEXT_SIZE = 1000;
	private static final  Integer MAX_THREADCONTEXT_SIZE  = 15;
	private static final Integer MAX_THREADTITLE_SIZE = 30;
	
	private final static String TOPICCONTEXT_PFIELD = "topic_context";
	private final static String TOPICTITLE_PFIELD = "topic_title";
	private final static String TOPICTEXT_PFIELD = "topic_text";
	
	

	@Autowired
	private CommentDAO commentRep;
	
	@Autowired
	private TopicDAO topicRep;
	
	
	@Autowired
	private IBUpdateService<Topic> topicUS;
	
	
	@Autowired
	private IBUpdateForumService forumUS;

	
	@Override
	public void regThread(String threadContext, String threadTitle, String threadText,User user,Forum forum,Model model) {
		
		
		if(user == null)
			throw new UnexpectedBehaviorException("[THREAD SERVICE] User == null");
		
		
		Map<String,String> errors = new HashMap<String,String>();
		
		model.addAttribute(ERROR_ATTRIBUTE,errors);
		
		String threadContext_s = (threadContext == null || threadContext.trim().isEmpty() ) ? null : threadContext.trim();
		String threadTitle_s = (threadTitle == null || threadTitle.trim().isEmpty() ) ? null : threadTitle.trim();
		String threadText_s = (threadText == null || threadText.trim().isEmpty() ) ? null : threadText.trim();
		
		
		
		
		Topic topic = new Topic();
		topic.setTopic_creationDate(new Date());
		topic.setTopic_owner(user);
		
		this.processTopicContext(threadContext_s,topic , errors);
		this.processTopicTilte(threadTitle_s, topic, errors);
		this.processTopicText(threadText_s, errors);
		
		if(errors.isEmpty())
		{	
			
			Comment comment = new Comment();
			comment.setComment_user(user);
			comment.setComment_message(threadText_s);
			comment.setComment_isTopicMessage(true);
			comment.setComment_date(new Date());
			comment.setComment_topic(topic);
			
			
			topic.setTopic_forum(forum);
			topic.setTopic_reviver(user);
			topic.setTopic_dateOfreviv(new Date());
			
			
			topicUS.updateCommentsNumber(topic);
			forumUS.updateCommentsNumber(forum);
			forumUS.updateTopicNumber(forum);
			
			try {
				topicRep.save(topic);
				commentRep.save(comment);
			} catch (Exception e) {
				errors.put(RESULT_ATTRIBUTE, "Une erreur inattendue est survenu réessayer ultérieurement");
			}
		}
		
		
	}

	
	private void processTopicText(String topicText,Map<String,String> errors)
	{
		try {
			this.checkTopicText(topicText);
		} catch (FormVException e) {
			errors.put(TOPICTEXT_PFIELD, e.getMessage());
		}
	}
	
	
	private void processTopicContext(String topicContext,Topic topic,Map<String,String> errors)
	{
		try {
			this.checkTopicContext(topicContext);
			
			if( topicContext.length() > 1)
				topic.setTopic_logodec(topicContext.toUpperCase().charAt(0) + topicContext.substring(1));
			else
				topic.setTopic_logodec(topicContext.toUpperCase());
			
		} catch (FormVException e) {
			errors.put(TOPICCONTEXT_PFIELD, e.getMessage());
		}
		topic.setTopic_logodec(topicContext);
	}
	
	private void processTopicTilte(String topicTitle,Topic topic,Map<String,String> errors)
	{ 
		try {
			this.checkTopicTitle(topicTitle);
			
			Optional<Byte>  checkTest = topicRep.topicIsExist(topicTitle);
			
			if(checkTest.isPresent())
				errors.put(TOPICTITLE_PFIELD, "Le titre de la topic existe déja");
			
		} catch (FormVException e) {
			errors.put(TOPICTITLE_PFIELD, e.getMessage());
		}
		
		topic.setTopic_title(topicTitle);
	}
	
	
	private void checkTopicContext(String topicContext)throws FormVException
	{
		if(topicContext!=null)
		{
			if(topicContext.length() > MAX_THREADCONTEXT_SIZE)
				throw new FormVException("Topic contexte ne doit pas dépasser "+MAX_THREADCONTEXT_SIZE+" caractères.");
		}
		else
			throw new FormVException("Veuillez spécifier le contexte du thread.");
	}
	
	private void checkTopicText(String topicText)throws FormVException
	{
		if(topicText!=null)
		{
			if(topicText.length() > MAX_THREAD_TEXT_SIZE)
				throw new FormVException("Le contenu de la topic ne doit pas dépasser "+MAX_THREADCONTEXT_SIZE+" caractères.");
		}
		else
			throw new FormVException("Veuillez saisire le contenu de la topic.");
	}
	
	
	
	private void checkTopicTitle(String topicTitle)throws FormVException
	{
		if(topicTitle!=null)
		{
			if(topicTitle.length() > MAX_THREADTITLE_SIZE)
				throw new FormVException("Titre de la topic ne doit pas dépasser "+MAX_THREADTITLE_SIZE+" caractères.");

		}else
			throw new FormVException("Veuillez spécifier le titre du topic.");
		
	}
	
	
}
