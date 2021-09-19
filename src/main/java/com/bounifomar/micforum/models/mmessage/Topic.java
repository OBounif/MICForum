package com.bounifomar.micforum.models.mmessage;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.bounifomar.micforum.models.mforum.Forum;
import com.bounifomar.micforum.models.muser.User;


@Entity
@Table(name = "T_TOPIC")
public class Topic implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1561734418310726188L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long topic_id;
	
	private String topic_title;
	private String topic_description;
	private String topic_message;
	private String topic_logodec;
	
	private Date topic_creationDate;
	private Integer topic_view_number;
	private Integer topic_comments_number;
	
	private Boolean topic_isLocked;
	private Boolean topic_isClosed;
	private Boolean topic_isDeleted;
	private Boolean topic_isPinned;
	
	private String topic_images_paths;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "topic_ownerid")
	private User topic_owner;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="topic_forumid")
	private Forum topic_forum;
	
	

	@Transient
	private List<Topic> topic_comments = new ArrayList<Topic>();
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="topic_reviver")
	private User topic_reviver;
	
	
	
	
	private Date topic_dateOfreviv;
	
	
	public Topic() {}
	
	
	public Topic(String topic_title,String topic_description,String topic_logodec,Date topic_creationDate,String topic_images_paths,String topic_message)
	{
		this.topic_title = topic_title;
		this.topic_message = topic_message;
		this.topic_description = topic_description;
		this.topic_logodec = topic_logodec;
		this.topic_creationDate = topic_creationDate;
		this.topic_images_paths = topic_images_paths;
		
	}
	
	
	public Long getTopic_id() {
		return topic_id;
	}

	public void setTopic_id(Long topic_id) {
		this.topic_id = topic_id;
	}

	public String getTopic_title() {
		return topic_title;
	}

	public void setTopic_title(String topic_title) {
		this.topic_title = topic_title;
	}

	public String getTopic_description() {
		return topic_description;
	}

	public void setTopic_description(String topic_description) {
		this.topic_description = topic_description;
	}

	public String getTopic_logodec() {
		return topic_logodec;
	}

	public void setTopic_logodec(String topic_logodec) {
		this.topic_logodec = topic_logodec;
	}

	public Date getTopic_creationDate() {
		return topic_creationDate;
	}

	public void setTopic_creationDate(Date topic_creationDate) {
		this.topic_creationDate = topic_creationDate;
	}

	public Integer getTopic_view_number() {
		return topic_view_number;
	}

	public void setTopic_view_number(Integer topic_view_number) {
		this.topic_view_number = topic_view_number;
	}

	public Integer getTopic_comments_number() {
		return topic_comments_number;
	}

	public void setTopic_comments_number(Integer topic_comments_number) {
		this.topic_comments_number = topic_comments_number;
	}

	public Boolean getTopic_isLocked() {
		return topic_isLocked;
	}

	public void setTopic_isLocked(Boolean topic_isLocked) {
		this.topic_isLocked = topic_isLocked;
	}

	public Boolean getTopic_isClosed() {
		return topic_isClosed;
	}

	public void setTopic_isClosed(Boolean topic_isClosed) {
		this.topic_isClosed = topic_isClosed;
	}

	public Boolean getTopic_isDeleted() {
		return topic_isDeleted;
	}

	public void setTopic_isDeleted(Boolean topic_isDeleted) {
		this.topic_isDeleted = topic_isDeleted;
	}

	public Boolean getTopic_isPinned() {
		return topic_isPinned;
	}

	public void setTopic_isPinned(Boolean topic_isPinned) {
		this.topic_isPinned = topic_isPinned;
	}

	public String getTopic_images_paths() {
		return topic_images_paths;
	}

	public void setTopic_images_paths(String topic_images_paths) {
		this.topic_images_paths = topic_images_paths;
	}

	public User getTopic_owner() {
		return topic_owner;
	}

	public void setTopic_owner(User topic_owner) {
		this.topic_owner = topic_owner;
	}

	public Forum getTopic_forum() {
		return topic_forum;
	}

	public void setTopic_forum(Forum topic_forum) {
		this.topic_forum = topic_forum;
	}

	public List<Topic> getTopic_comments() {
		return topic_comments;
	}

	public void setTopic_comments(List<Topic> topic_comments) {
		this.topic_comments = topic_comments;
	}



	public User getTopic_reviver() {
		return topic_reviver;
	}

	public void setTopic_reviver(User topic_reviver) {
		this.topic_reviver = topic_reviver;
	}

	public Date getTopic_dateOfreviv() {
		return topic_dateOfreviv;
	}

	public void setTopic_dateOfreviv(Date topic_dateOfreviv) {
		this.topic_dateOfreviv = topic_dateOfreviv;
	}


	public String getTopic_message() {
		return topic_message;
	}


	public void setTopic_message(String topic_message) {
		this.topic_message = topic_message;
	}
	
	
	
	
}
