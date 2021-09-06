package com.bounifomar.micforum.models.muser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name = "T_RANKS")
public class UserRank implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1137035359053134950L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rank_id;
	
	@Enumerated(EnumType.STRING)
	private UserRankType rank_type;
	
	private String rank_img_path;
	
	private Integer rank_min_message;
	private Integer rank_max_message;
	

	private Boolean rank_isSpecial;
	
	@Transient
	private List<UserRank> rank_list=new ArrayList<UserRank>();
	
	public UserRank() {}
	
	
	public UserRank(UserRankType type,String rank_img_path,Integer rank_min_message,Integer rank_max_message,Boolean isSpecial)
	{
		this.rank_type=type;
		this.rank_img_path=rank_img_path;
		this.rank_max_message=rank_max_message;
		this.rank_min_message=rank_min_message;
		this.rank_isSpecial = isSpecial;
	}
	
	
	public Long getRank_id() {
		return rank_id;
	}

	public void setRank_id(Long rank_id) {
		this.rank_id = rank_id;
	}

	public UserRankType getRank_type() {
		return rank_type;
	}

	public void setRank_type(UserRankType rank_type) {
		this.rank_type = rank_type;
	}

	public String getRank_img_path() {
		return rank_img_path;
	}

	public void setRank_img_path(String rank_img_path) {
		this.rank_img_path = rank_img_path;
	}

	public Integer getRank_min_message() {
		return rank_min_message;
	}

	public void setRank_min_message(Integer rank_min_message) {
		this.rank_min_message = rank_min_message;
	}

	public Integer getRank_max_message() {
		return rank_max_message;
	}

	public void setRank_max_message(Integer rank_max_message) {
		this.rank_max_message = rank_max_message;
	}



	public List<UserRank> getRank_list() {
		return rank_list;
	}

	public void setRank_list(List<UserRank> rank_list) {
		this.rank_list = rank_list;
	}


	public Boolean getRank_isSpecial() {
		return rank_isSpecial;
	}


	public void setRank_isSpecial(Boolean rank_isSpecial) {
		this.rank_isSpecial = rank_isSpecial;
	}
	
	
	
}
