package com.bounifomar.micforum.business.blimplementations.forum;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bounifomar.micforum.business.blexceptions.FormVException;
import com.bounifomar.micforum.business.blinterfaces.forum.IBRegForum;
import com.bounifomar.micforum.models.mforum.Forum;
import com.bounifomar.micforum.repositories.ForumDAO;

import static com.bounifomar.micforum.business.blimplementations.utility.RequestParsUtility.*;

import java.util.HashMap;
import java.util.Map;;

@Service
public class IBRegForumImp implements IBRegForum{
	
	private final static String FORUMFATHER_PFIELD = "forum_father";
	private final static String FORUMTITLE_PFIELD = "forum_title";
	private final static String FORUMDESCRIPTION_PFIELD = "forum_description";
	private final static String FORUMVISIBILITY_PFIELD = "forum_visibility";
	
	private final static Integer MAX_FORUMTITLE_LENGTH = 20;
	private final static Integer MAX_FORUMDESCRIPTION_LENGTH = 255;
	
	
	@Autowired
	private ForumDAO forumRep;
	
	
	@Override
	public Boolean regForum(HttpServletRequest request, Model model) {
		
		Map<String,String> errors = new HashMap<String,String>();
		
		String forum_title = getFieldValue(request, FORUMTITLE_PFIELD);
		String forum_description = getFieldValue(request, FORUMDESCRIPTION_PFIELD);
		String forum_visibility = getFieldValue(request, FORUMVISIBILITY_PFIELD);
		String forum_father = getFieldValue(request, FORUMFATHER_PFIELD);
		
		Forum forum=new Forum();
		
		this.processForumDescription(forum_description, forum, errors);
		this.processForumTitle(forum_title, forum, errors);
		this.processForumVisibility(forum_visibility, forum, errors);
		
		if(errors.isEmpty())
		{
			Forum forum_f = forumRep.findByForum_title(forum_father);
			
			if(forum_f  == null)
				errors.put(FORUMFATHER_PFIELD, "Forum parent n'éxiste pas.");
			
			forum.setForum_f_id(forum_f);
			
			forumRep.save(forum);
			
			return true;
		}
		return false;
	}
	
	
	private void processForumTitle(String forum_title,Forum forum,Map<String,String> errors)
	{
		try {
			this.checkForumTitle(forum_title);
		} catch (FormVException e) {
			errors.put(FORUMTITLE_PFIELD, e.getMessage());
		}
		forum.setForum_title(forum_title);
	}
	
	private void processForumDescription(String forum_description,Forum forum,Map<String,String> errors)
	{
		try {
			this.checkForumDescription(forum_description);
			
		} catch (FormVException e) {
			errors.put(FORUMDESCRIPTION_PFIELD, e.getMessage());
		}
	}
	
	private void processForumVisibility(String forum_visibility,Forum forum,Map<String,String> errors)
	{
		try {
			this.checkForumVisibility(forum_visibility);
			
			switch(forum_visibility)
			{
				case "private":
					forum.setForum_isPublic(false);
					break;
				case "public":
					forum.setForum_isPublic(true);
					break;
			}
		} catch (FormVException e) {
			errors.put(FORUMVISIBILITY_PFIELD, e.getMessage());
		}

	}
	
	private void checkForumVisibility(String forum_visibility)
	{
		if(forum_visibility != null)
		{
			if(!forum_visibility.equals("public") && !forum_visibility.equals("private"))
			{
				throw new FormVException("Visibilité inconnue.");
			}
		}
		else
			throw new FormVException("Veuillez specifier la visibilité du forum.");

	}
	
	
	private void checkForumTitle(String forum_title)throws FormVException
	{
		if(forum_title != null)
		{
			if(forum_title.length() > MAX_FORUMTITLE_LENGTH)
				throw new FormVException("Le titre du forum ne doit pas dépasser " + MAX_FORUMTITLE_LENGTH + " caractères.");
		}
		else
			throw new FormVException("Veuillez entrer le nom du forum.");
	}
	
	private void checkForumDescription(String forum_description)throws FormVException
	{
		if(forum_description != null)
		{
			if(forum_description.length() > MAX_FORUMTITLE_LENGTH)
				throw new FormVException("La description du forum ne doit pas dépasser " + MAX_FORUMDESCRIPTION_LENGTH + " caractères.");
		}
		else
			throw new FormVException("Veuillez entrer la descirption du forum.");
	}
	
	
}
