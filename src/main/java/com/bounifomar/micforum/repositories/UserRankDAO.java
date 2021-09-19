package com.bounifomar.micforum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bounifomar.micforum.models.muser.UserRank;


public interface UserRankDAO extends JpaRepository<UserRank, Long>{

}
