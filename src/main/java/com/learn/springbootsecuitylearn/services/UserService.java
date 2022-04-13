package com.learn.springbootsecuitylearn.services;

import java.util.ArrayList;
import java.util.List;

import com.learn.springbootsecuitylearn.Models.User;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    List<User> list = new ArrayList<>();

    public UserService() {
        list.add(new User("test","1234","test@gmail.com","no_role"));
        list.add(new User("hello","1234","hello@gmail.com","no_role"));
    }

    //Get all Users
    public List<User> getAll(){
        return list;
    }

    //Get Single User
    public User getUser(String username){
       return this.list.stream().filter((user)->user.getUsername().equals(username)).findAny().orElse(null);
    }

    //Add User
    public User addUser(User user){
        this.list.add(user);
        return user;
    }
}
