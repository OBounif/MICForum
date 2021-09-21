package com.bounifomar.micforum.models.mforum;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	
	@Column(unique = true)
	private String forum_title;
	
	private String forum_description;
	
	private Integer forum_followers_number;
	private Integer forum_topics_number;
	private Integer forum_view_number;
	private Integer forum_comments_number;

	
	private Date forum_creationDate;
	
	private Boolean forum_isPublic;
	
	
	
	@Transient
	private List<Topic> forum_topics = new ArrayList<Topic>();
	
	@Transient
	private List<Forum> forum_subforums=new ArrayList<Forum>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "forum_f_id")
	private Forum forum_f_id;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "forum_f_id")
	private List<Forum> forum_childrens;
	

	
	
	public Forum(){/*DEFAULT CONTRUCTOR*/
		this.forum_followers_number = 0;
		this.forum_topics_number = 0;
		this.forum_view_number = 0;
		this.forum_comments_number = 0;
		
		this.forum_isPublic = true;
	}
	
	public Forum(String forum_title,String forum_description,java.util.Date date,Boolean forum_isPublic,Forum forum_f_id)
	{
		this.forum_title = forum_title;
		this.forum_description = forum_description;
		this.forum_creationDate = date;
		this.forum_isPublic = forum_isPublic;
		
		this.forum_followers_number = 0;
		this.forum_topics_number = 0;
		this.forum_view_number = 0;
		this.forum_comments_number = 0;
		this.forum_f_id = forum_f_id;
	}
	
	public Long getForum_id() {
		return forum_id;
	}

	public void setForum_id(Long forum_id) {
		this.forum_id = forum_id;
	}

	

	public String getForum_title() {
		return forum_title;
	}

	public void setForum_title(String forum_title) {
		this.forum_title = forum_title;
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

	public Forum getForum_f_id() {
		return forum_f_id;
	}

	public void setForum_f_id(Forum forum_f_id) {
		this.forum_f_id = forum_f_id;
	}

	public List<Forum> getForum_subforums() {
		return forum_subforums;
	}

	public void setForum_subforums(List<Forum> forum_subforums) {
		this.forum_subforums = forum_subforums;
	}

	public List<Forum> getForum_childrens() {
		return forum_childrens;
	}

	public void setForum_childrens(List<Forum> forum_childrens) {
		this.forum_childrens = forum_childrens;
	}
	
	
	
}
