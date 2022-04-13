package com.learn.springbootsecuitylearn.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.springbootsecuitylearn.Models.User;

public interface UserRepo extends JpaRepository<User, String>{
	public User findByUsername(String username);
}
