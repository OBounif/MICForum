package com.bounifomar.micforum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bounifomar.micforum.models.mmessage.Comment;

public interface CommentDAO extends JpaRepository<Comment, Long> {

}
