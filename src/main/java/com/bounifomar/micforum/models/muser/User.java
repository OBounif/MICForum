package com.bounifomar.micforum.models.muser;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.bounifomar.micforum.models.mgroup.Group;
import com.bounifomar.micforum.models.mmessage.Comment;
import com.bounifomar.micforum.models.mmessage.Topic;


@Entity
@Table(name = "T_USERS")

public class User implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2572537090663462967L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;
	
	private String 	user_fname;
	private String 	user_lname;
	
	@Column(unique = true)
	private String 	user_email;
	
	private String 	user_address;
	private String  user_country;
	private String	user_city;
	private String	user_pic_path;
	private String	user_coverpic_path;
	private String 	user_signature;
	
	@Column( unique = true)
	private String user_name;
	private String user_password;
	
	@Transient
	private String user_passwordConf;

	
	private UserGender user_gender;
	
	private Date	user_birthdate;
	private Date	user_regdate;
	private Date	user_lastlogon;
	
	@Transient
	private Integer user_age;
	
	private Integer	user_followers_number;
	private Integer user_friends_number;
	private Integer user_topic_number;
	
	
	
	private Boolean user_isBanned;
	private Boolean user_isDeactivated;
	private Boolean user_isDeleted;
	
	
	private String 	user_fburl;
	private String 	user_twitterurl;
	private String 	user_githuburl;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="T_USER_GROUP",
			   joinColumns = @JoinColumn(name = "user_id"),
			   inverseJoinColumns = @JoinColumn(name = "group_id")
			  )
	private List<Group> user_groups = new ArrayList<Group>();

	

	@Transient
	private List<Topic> user_topics = new ArrayList<Topic>();
	
	
	@Transient
	private List<Comment> user_comments= new ArrayList<Comment>();
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name="T_USER_RANKS",
			   joinColumns = @JoinColumn(name = "user_id"),
			   inverseJoinColumns = @JoinColumn(name = "rank_id")
			  )
	private UserRank user_currRank;

	
	public User() {
		
		this.user_isBanned = false;
		this.user_isDeactivated = false;
		this.user_isDeleted = false;
		
		this.user_followers_number = 0;
		this.user_friends_number = 0;
		this.user_topic_number = 0;
	}
	
	public User(String username,String email,String password,String passwordConf,Date regDate,Date lastloggon,UserRank rank)
	{
		this.user_name = username;
		this.user_email = email;
		this.user_password = password;
		this.user_passwordConf = passwordConf;
		this.user_regdate = regDate;
		this.user_lastlogon =lastloggon;
		this.user_currRank = rank;
		
		this.user_isBanned = false;
		this.user_isDeactivated = false;
		this.user_isDeleted = false;
		
		this.user_followers_number = 0;
		this.user_friends_number = 0;
		this.user_topic_number = 0;
		
		}
	
	
	
	
	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUser_fname() {
		return user_fname;
	}

	public void setUser_fname(String user_fname) {
		this.user_fname = user_fname;
	}

	public String getUser_lname() {
		return user_lname;
	}

	public void setUser_lname(String user_lname) {
		this.user_lname = user_lname;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_country() {
		return user_country;
	}

	public void setUser_country(String user_country) {
		this.user_country = user_country;
	}

	public String getUser_city() {
		return user_city;
	}

	public void setUser_city(String user_city) {
		this.user_city = user_city;
	}

	public String getUser_pic_path() {
		return user_pic_path;
	}

	public void setUser_pic_path(String user_pic_path) {
		this.user_pic_path = user_pic_path;
	}

	public String getUser_coverpic_path() {
		return user_coverpic_path;
	}

	public void setUser_coverpic_path(String user_coverpic_path) {
		this.user_coverpic_path = user_coverpic_path;
	}

	public String getUser_signature() {
		return user_signature;
	}

	public void setUser_signature(String user_signature) {
		this.user_signature = user_signature;
	}

	public UserGender getUser_gender() {
		return user_gender;
	}

	public void setUser_gender(UserGender user_gender) {
		this.user_gender = user_gender;
	}

	public Date getUser_birthdate() {
		return user_birthdate;
	}

	public void setUser_birthdate(Date user_birthdate) {
		this.user_birthdate = user_birthdate;
	}

	public Date getUser_regdate() {
		return user_regdate;
	}

	public void setUser_regdate(Date user_regdate) {
		this.user_regdate = user_regdate;
	}

	public Integer getUser_age() {
		return user_age;
	}

	public void setUser_age(Integer user_age) {
		this.user_age = user_age;
	}

	public Integer getUser_followers_number() {
		return user_followers_number;
	}

	public void setUser_followers_number(Integer user_followers_number) {
		this.user_followers_number = user_followers_number;
	}

	public Integer getUser_friends_number() {
		return user_friends_number;
	}

	public void setUser_friends_number(Integer user_friends_number) {
		this.user_friends_number = user_friends_number;
	}

	public Integer getUser_topic_number() {
		return user_topic_number;
	}

	public void setUser_topic_number(Integer user_topic_number) {
		this.user_topic_number = user_topic_number;
	}

	public Boolean getUser_isBanned() {
		return user_isBanned;
	}

	public void setUser_isBanned(Boolean user_isBanned) {
		this.user_isBanned = user_isBanned;
	}

	public Boolean getUser_isDeactivated() {
		return user_isDeactivated;
	}

	public void setUser_isDeactivated(Boolean user_isDeactivated) {
		this.user_isDeactivated = user_isDeactivated;
	}

	public Boolean getUser_isDeleted() {
		return user_isDeleted;
	}

	public void setUser_isDeleted(Boolean user_isDeleted) {
		this.user_isDeleted = user_isDeleted;
	}
	
	

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public List<Group> getUser_groups() {
		return user_groups;
	}

	public void setUser_groups(List<Group> user_groups) {
		this.user_groups = user_groups;
	}

	

	public List<Topic> getUser_topics() {
		return user_topics;
	}

	public void setUser_topics(List<Topic> user_topics) {
		this.user_topics = user_topics;
	}



	public List<Comment> getUser_comments() {
		return user_comments;
	}

	public void setUser_comments(List<Comment> user_comments) {
		this.user_comments = user_comments;
	}

	
	
	public String getUser_passwordConf() {
		return user_passwordConf;
	}

	public void setUser_passwordConf(String user_passwordConf) {
		this.user_passwordConf = user_passwordConf;
	}

	public Boolean checkPassword()
	{
		return this.user_password.equals(this.user_passwordConf);
	}

	public Date getUser_lastlogon() {
		return user_lastlogon;
	}

	public void setUser_lastlogon(Date user_lastlogon) {
		this.user_lastlogon = user_lastlogon;
	}

	public UserRank getUser_currRank() {
		return user_currRank;
	}

	public void setUser_currRank(UserRank user_currRank) {
		this.user_currRank = user_currRank;
	}

	public String getUser_fburl() {
		return user_fburl;
	}

	public void setUser_fburl(String user_fburl) {
		this.user_fburl = user_fburl;
	}

	public String getUser_twitterurl() {
		return user_twitterurl;
	}

	public void setUser_twitterurl(String user_twitterurl) {
		this.user_twitterurl = user_twitterurl;
	}

	public String getUser_githuburl() {
		return user_githuburl;
	}

	public void setUser_githuburl(String user_githuburl) {
		this.user_githuburl = user_githuburl;
	}
	
	
	

}
