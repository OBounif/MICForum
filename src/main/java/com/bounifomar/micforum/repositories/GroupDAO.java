package com.bounifomar.micforum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bounifomar.micforum.models.mgroup.Group;

public interface GroupDAO extends JpaRepository<Group, Long> {

}
