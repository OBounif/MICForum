package com.bounifomar.micforum.models.mmessage;

import java.io.Serializable;
import java.util.Date;

//import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.bounifomar.micforum.models.muser.User;

//@Entity
public class PrivateMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1388323563578058318L;

	@Id
	private Long id;
	
	private String message_text;
	private Date message_date;
	
	
	
	
	@OneToOne
	@JoinColumn(name="from_userid")
	private User message_from;
	
	@OneToOne
	@JoinColumn(name = "to_userid")
	private User message_to;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage_text() {
		return message_text;
	}

	public void setMessage_text(String message_text) {
		this.message_text = message_text;
	}

	public Date getMessage_date() {
		return message_date;
	}

	public void setMessage_date(Date message_date) {
		this.message_date = message_date;
	}

	public User getMessage_from() {
		return message_from;
	}

	public void setMessage_from(User message_from) {
		this.message_from = message_from;
	}

	public User getMessage_to() {
		return message_to;
	}

	public void setMessage_to(User message_to) {
		this.message_to = message_to;
	}
	
	
	
	
	
}
