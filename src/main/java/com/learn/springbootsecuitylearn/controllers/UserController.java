package com.learn.springbootsecuitylearn.controllers;

import java.util.List;

import com.learn.springbootsecuitylearn.services.UserService;
import com.learn.springbootsecuitylearn.Models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> getAllUsers(){
        return this.userService.getAll();
    }
    
    @GetMapping("/{username}")
//    @PreAuthorize("hasRole('ADMIN')")
    public User getUser(@PathVariable("username") String username){
        return this.userService.getUser(username);
    }

    @PostMapping("/")
    public User addUser(@RequestBody User user){
        return this.userService.addUser(user);
    }

}
