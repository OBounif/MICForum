package com.bounifomar.micforum.models.mmessage;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bounifomar.micforum.models.muser.User;

@Entity
@Table(name="T_CHATBOX")
public class ChatBox implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7667283911646295358L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer chat_id;
	private Date chat_date;
	
	private Boolean chat_isDeleted;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "chat_userid")
	private User chat_user;
	
	public Integer getChat_id() {
		return chat_id;
	}

	public void setChat_id(Integer chat_id) {
		this.chat_id = chat_id;
	}

	public Date getChat_date() {
		return chat_date;
	}

	public void setChat_date(Date chat_date) {
		this.chat_date = chat_date;
	}

	public Boolean getChat_isDeleted() {
		return chat_isDeleted;
	}

	public void setChat_isDeleted(Boolean chat_isDeleted) {
		this.chat_isDeleted = chat_isDeleted;
	}

	public User getChat_user() {
		return chat_user;
	}

	public void setChat_user(User chat_user) {
		this.chat_user = chat_user;
	}
	
	
	

}
