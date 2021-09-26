package com.bounifomar.micforum.business.blimplementations.forum;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bounifomar.micforum.business.blexceptions.FormVException;
import com.bounifomar.micforum.business.blinterfaces.forum.IBRegForum;
import com.bounifomar.micforum.models.mforum.Forum;
import com.bounifomar.micforum.repositories.ForumDAO;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;;

@Service
public class IBRegForumImp implements IBRegForum{
	
	private static final String MODEL_FORUM_ATTRIBUTE = "FORUM_MODEL";

	private static String ERROR_ATTRIBUTE = "ERRORS";
	private static String RESULT_ATTRIBUTE = "RESULT";
	
	private final static String FORUMFATHER_PFIELD = "forum_father";
	private final static String FORUMTITLE_PFIELD = "forum_title";
	private final static String FORUMDESCRIPTION_PFIELD = "forum_description";
	private final static String FORUMVISIBILITY_PFIELD = "forum_visibility";
	
	private final static Integer MAX_FORUMTITLE_LENGTH = 20;
	private final static Integer MAX_FORUMDESCRIPTION_LENGTH = 255;
	
	
	@Autowired
	private ForumDAO forumRep;
	
	
	@Override
	public void regForum(String forum_titlep,String forum_descriptionp,String forum_visibilityp,String forum_fatherp,Model model) {
		
		
		
		Map<String,String> errors = new HashMap<String,String>();
		
		model.addAttribute(ERROR_ATTRIBUTE, errors);
		
		String forum_title = (forum_titlep == null || forum_titlep.trim().isEmpty() ) ? null : forum_titlep.trim();
		String forum_description = (forum_descriptionp == null || forum_descriptionp.trim().isEmpty() ) ? null : forum_descriptionp.trim();
		String forum_visibility = (forum_visibilityp == null || forum_visibilityp.trim().isEmpty() ) ? null : forum_visibilityp.trim();
		String forum_father = (forum_fatherp == null || forum_fatherp.trim().isEmpty() ) ? null : forum_fatherp.trim();
		
		
		Forum forum=new Forum();
		
		model.addAttribute(MODEL_FORUM_ATTRIBUTE, forum);
		
		this.processForumDescription(forum_description, forum, errors);
		this.processForumTitle(forum_title, forum, errors);
		this.processForumFatherTitle(forum_father, forum, errors);
		this.processForumVisibility(forum_visibility, forum, errors);
		
		
		if(errors.isEmpty())
		{
				
				if(forum_father.equals("MIC"))
				{
					forum.setForum_f_id(null);
					forum.setForum_creationDate(new Date());
					
					forumRep.save(forum);
					model.addAttribute(RESULT_ATTRIBUTE, forum.getForum_title() + " a été ajouter avec succeès");
					
					return;
				}
				
				Forum forum_f = forumRep.findByForum_title(forum_father);
				
				if(forum_f == null )
					errors.put(FORUMFATHER_PFIELD, "Forum parent n'éxiste pas.");
				else
				{
					forum.setForum_f_id(forum_f);
					forum.setForum_creationDate(new Date());
					forumRep.save(forum);
					model.addAttribute(RESULT_ATTRIBUTE, forum.getForum_title() + " a été ajouter avec succeès");
				}			
		}
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
	
	private void processForumFatherTitle(String forum_father_title,Forum forum,Map<String,String> errors)
	{
		try {
			this.checkForumFather(forum_father_title);
		} catch (FormVException e) {
			errors.put(FORUMFATHER_PFIELD, e.getMessage());
		}
	
	}
	
	private void processForumDescription(String forum_description,Forum forum,Map<String,String> errors)
	{
		try {
			this.checkForumDescription(forum_description);
			
		} catch (FormVException e) {
			errors.put(FORUMDESCRIPTION_PFIELD, e.getMessage());
		}
		forum.setForum_description(forum_description);
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
			
			if(forum_title.equals("MIC"))
				throw new FormVException("Forum title que vous avez saisie existe déja .");

				
			Forum forum = forumRep.findByForum_title(forum_title);
			
			if(forum != null)
				throw new FormVException("Forum title que vous avez saisie existe déja .");
		}
		else
			throw new FormVException("Veuillez entrer le nom du forum.");
	}
	
	private void checkForumFather(String forum_father)throws FormVException
	{
		if(forum_father != null)
		{
			if(forum_father.length() > MAX_FORUMTITLE_LENGTH)
				throw new FormVException("Le titre du forum parent ne doit pas dépasser " + MAX_FORUMTITLE_LENGTH + " caractères.");
		}
		else
			throw new FormVException("Veuillez entrer le nom du forum parent.");
	}
	
	private void checkForumDescription(String forum_description)throws FormVException
	{
		if(forum_description != null)
		{
			if(forum_description.length() > MAX_FORUMDESCRIPTION_LENGTH)
				throw new FormVException("La description du forum ne doit pas dépasser " + MAX_FORUMDESCRIPTION_LENGTH + " caractères.");
		}
		else
			throw new FormVException("Veuillez entrer la description du forum.");
	}
	
	
}
