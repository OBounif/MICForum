package com.bounifomar.micforum.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bounifomar.micforum.models.mforum.Forum;


public interface ForumDAO extends JpaRepository<Forum, Long>{
		
	@Query("select f from Forum f where f.forum_title=:forum_title")
	Forum findByForum_title(@Param("forum_title") String forum_title);
	
	@Query("select f from Forum f where f.forum_f_id is null")
	List<Forum> findByIdEqualsNull();
	
	@Query("select f from  Forum f where f.forum_title like :stringlike")
	List<Forum> findByLikeKey(@Param("stringlike")String stringlike);
	
	
}
