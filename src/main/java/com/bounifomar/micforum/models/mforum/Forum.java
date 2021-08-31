package com.bounifomar.micforum.models.mforum;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bounifomar.micforum.models.mmessage.Comment;
import com.bounifomar.micforum.models.mmessage.Topic;


@Entity
@Table(name = "T_FORUM")
public class Forum implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3933998281989160289L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long forum_id;
	
	private String forum_name;
	private String forum_description;
	
	private Integer forum_followers_number;
	private Integer forum_topics_number;
	private Integer forum_view_number;
	private Integer forum_comments_number;

	
	private Date forum_creationDate;
	
	private Boolean forum_isPublic;

	
	@OneToMany(targetEntity = Comment.class,mappedBy = "comment_topic")
	private List<Topic> forum_topics = new ArrayList<Topic>();;
	
	
	public Forum(){/*DEFAULT CONTRUCTOR*/}
	
	public Forum(String forum_name,String forum_description,java.util.Date date,Boolean forum_isPublic)
	{
		this.forum_name = forum_name;
		this.forum_description = forum_description;
		this.forum_creationDate = date;
		this.forum_isPublic = forum_isPublic;
		
		this.forum_followers_number = 0;
		this.forum_topics_number = 0;
		this.forum_view_number = 0;
		this.forum_comments_number = 0;
	}
	
	public Long getForum_id() {
		return forum_id;
	}

	public void setForum_id(Long forum_id) {
		this.forum_id = forum_id;
	}

	public String getForum_name() {
		return forum_name;
	}

	public void setForum_name(String forum_name) {
		this.forum_name = forum_name;
	}

	public String getForum_description() {
		return forum_description;
	}

	public void setForum_description(String forum_description) {
		this.forum_description = forum_description;
	}

	public Integer getForum_followers_number() {
		return forum_followers_number;
	}

	public void setForum_followers_number(Integer forum_followers_number) {
		this.forum_followers_number = forum_followers_number;
	}

	public Integer getForum_topics_number() {
		return forum_topics_number;
	}

	public void setForum_topics_number(Integer forum_topics_number) {
		this.forum_topics_number = forum_topics_number;
	}

	public Integer getForum_view_number() {
		return forum_view_number;
	}

	public void setForum_view_number(Integer forum_view_number) {
		this.forum_view_number = forum_view_number;
	}

	public Integer getForum_comments_number() {
		return forum_comments_number;
	}

	public void setForum_comments_number(Integer forum_comments_number) {
		this.forum_comments_number = forum_comments_number;
	}

	public Date getForum_creationDate() {
		return forum_creationDate;
	}

	public void setForum_creationDate(Date forum_creationDate) {
		this.forum_creationDate = forum_creationDate;
	}

	public Boolean getForum_isPublic() {
		return forum_isPublic;
	}

	public void setForum_isPublic(Boolean forum_isPublic) {
		this.forum_isPublic = forum_isPublic;
	}

	public List<Topic> getForum_topics() {
		return forum_topics;
	}

	public void setForum_topics(List<Topic> forum_topics) {
		this.forum_topics = forum_topics;
	}
	
	
	
}
