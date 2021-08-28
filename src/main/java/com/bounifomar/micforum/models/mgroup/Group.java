package com.bounifomar.micforum.models.mgroup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import com.bounifomar.micforum.models.muser.User;

@Entity
@Table(name = "T_GROUP")
public class Group implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7997898226265553413L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long group_id;
	
	
	private String group_name;
	private String group_description;
	
	private Integer group_members_number;
	
	private GroupVisbility group_visibility;

	
	
	@ManyToMany
	@JoinTable(name="T_USER_GROUP",
			   joinColumns = @JoinColumn(name = "group_id"),
	           inverseJoinColumns = @JoinColumn(name = "user_id")
			  )	
	private List<User> group_users = new ArrayList<User>();;
	
	
	

	public Long getGroup_id() {
		return group_id;
	}

	public void setGroup_id(Long group_id) {
		this.group_id = group_id;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	public String getGroup_description() {
		return group_description;
	}

	public void setGroup_description(String group_description) {
		this.group_description = group_description;
	}

	public Integer getGroup_members_number() {
		return group_members_number;
	}

	public void setGroup_members_number(Integer group_members_number) {
		this.group_members_number = group_members_number;
	}

	public GroupVisbility getGroup_visibility() {
		return group_visibility;
	}

	public void setGroup_visibility(GroupVisbility group_visibility) {
		this.group_visibility = group_visibility;
	}

	

	public List<User> getGroup_users() {
		return group_users;
	}

	public void setGroup_users(List<User> group_users) {
		this.group_users = group_users;
	}
	
	
	
}
