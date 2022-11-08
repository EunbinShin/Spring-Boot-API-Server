package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.User;

@Repository
public interface UserJpaRepo extends JpaRepository<User, Long>{
	
	User findByName(String name);
	
	User findByEmail(String email);
}
