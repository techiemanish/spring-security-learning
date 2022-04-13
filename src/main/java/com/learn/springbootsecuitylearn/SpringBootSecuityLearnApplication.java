package com.learn.springbootsecuitylearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.learn.springbootsecuitylearn.Models.User;
import com.learn.springbootsecuitylearn.repo.UserRepo;

@SpringBootApplication
public class SpringBootSecuityLearnApplication implements CommandLineRunner{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecuityLearnApplication.class, args);
		System.out.println("Application Started");
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user = new User();
		user.setEmail("admin@gmail.com");
		user.setUsername("admin");
		user.setPassword(this.bCryptPasswordEncoder.encode("1234"));
		user.setRole("ROLE_ADMIN");
		
		this.userRepo.save(user);
		
		User user1 = new User();
		user1.setEmail("manish@gmail.com");
		user1.setUsername("manish");
		user1.setPassword(this.bCryptPasswordEncoder.encode("1234"));
		user1.setRole("ROLE_NORMAL");
		
		this.userRepo.save(user1);
	}

}
