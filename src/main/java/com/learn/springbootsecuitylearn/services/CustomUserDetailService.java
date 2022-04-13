package com.learn.springbootsecuitylearn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learn.springbootsecuitylearn.Models.CustomUser;
import com.learn.springbootsecuitylearn.Models.User;
import com.learn.springbootsecuitylearn.repo.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = this.userRepo.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("No User found");
		}
		return new CustomUser(user);
	}

}
