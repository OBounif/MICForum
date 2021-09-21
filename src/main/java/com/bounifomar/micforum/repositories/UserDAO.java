package com.bounifomar.micforum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bounifomar.micforum.models.muser.User;

public interface UserDAO extends JpaRepository<User, Long>{

	@Query(value = "Select u from User u where u.user_name=:username and user_password=:password")
	public User findUserByUsernameAndPassword(@Param("username")String username,
											  @Param("password")String password);
	
	
	@Query(value="Select u from User u where u.user_email=:email")
	public User findUserByEmail(@Param("email")String email);
	
	
	@Query(value="Select u from User u where u.user_name=:username")
	public User findUserByUsername(@Param("username")String username);
}
