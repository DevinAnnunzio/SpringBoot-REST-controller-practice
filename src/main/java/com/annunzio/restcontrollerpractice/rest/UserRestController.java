package com.annunzio.restcontrollerpractice.rest;

import com.annunzio.restcontrollerpractice.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserRestController {
    @GetMapping("/users")
    public List<User> getUsers(){
        //Skipping DB crud for now
        List<User> users = new ArrayList<>();
        users.add(new User("Jim", "Jones", 87));
        users.add(new User("Mike", "Jones", 38));
        users.add(new User("John", "Jones", 35));
        return  users;
    }
}
