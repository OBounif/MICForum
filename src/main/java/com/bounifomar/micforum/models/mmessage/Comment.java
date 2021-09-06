package com.bounifomar.micforum.models.mmessage;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bounifomar.micforum.models.muser.User;


@Entity
@Table(name = "T_COMMENT")
public class Comment implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6354835048815449190L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long comment_id;
	
	private String comment;
	
	private Date comment_date;
	private Date comment_chg_date;
	
	
	private Boolean comment_isDeleted;

	@ManyToOne
	@JoinColumn(name = "comment_topicid")
	private Topic comment_topic;
	
	@ManyToOne
	@JoinColumn(name = "comment_userid")
	private User comment_user;
	
	
	public Long getComment_id() {
		return comment_id;
	}


	public void setComment_id(Long comment_id) {
		this.comment_id = comment_id;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public Date getComment_date() {
		return comment_date;
	}


	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}


	public Date getComment_chg_date() {
		return comment_chg_date;
	}


	public void setComment_chg_date(Date comment_chg_date) {
		this.comment_chg_date = comment_chg_date;
	}


	public Boolean getComment_isDeleted() {
		return comment_isDeleted;
	}


	public void setComment_isDeleted(Boolean comment_isDeleted) {
		this.comment_isDeleted = comment_isDeleted;
	}


	public Topic getComment_topic() {
		return comment_topic;
	}


	public void setComment_topic(Topic comment_topic) {
		this.comment_topic = comment_topic;
	}


	public User getComment_user() {
		return comment_user;
	}


	public void setComment_user(User comment_user) {
		this.comment_user = comment_user;
	}
	
	
	
}
