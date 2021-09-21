package com.bounifomar.micforum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bounifomar.micforum.models.muser.UserRank;
import com.bounifomar.micforum.models.muser.UserRankType;


public interface UserRankDAO extends JpaRepository<UserRank, Long>{

	
	@Query("select r from UserRank r where r.rank_type=:user_rank")
	public UserRank findUserRankByRankType(@Param("user_rank") UserRankType rank_type);
	
}
