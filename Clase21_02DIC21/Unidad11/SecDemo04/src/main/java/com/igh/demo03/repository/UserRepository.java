package com.igh.demo03.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igh.demo03.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsernameAndDisabled(String username, boolean disabled);
	
}
