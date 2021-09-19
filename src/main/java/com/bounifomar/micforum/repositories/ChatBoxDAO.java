package com.bounifomar.micforum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bounifomar.micforum.models.mmessage.ChatBox;

public interface ChatBoxDAO extends JpaRepository<ChatBox, Long>{

}
