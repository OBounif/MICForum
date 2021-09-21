package com.bounifomar.micforum.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bounifomar.micforum.models.mmessage.Topic;


@Transactional
public interface TopicDAO extends JpaRepository<Topic, Long>{
	
	/*
	 * @Query("select t from t_topic t limit :offset,:limit")
	 * limit is not part of JPQL ! 
	 */
	
	@Query("select t from Topic t where t.topic_forum.forum_id = :forumid")
	public List<Topic> getTopics(@Param("forumid")Long forum_id,Pageable pageable);
	
	
	@Query("from Topic t order by id desc")
	public List<Topic> getTopics(Pageable pageable);
	
	@Query("select count(t) from Topic t where t.topic_forum.forum_id = :forumid")
	public Long topicsCount(@Param("forumid")Long forum_id);
	
	
	
}
