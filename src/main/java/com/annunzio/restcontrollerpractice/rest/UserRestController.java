package com.annunzio.restcontrollerpractice.rest;

import com.annunzio.restcontrollerpractice.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserRestController {

    private List<User> usersList;
    //Use @PostConstruct to load data, called only once when bean is created
    @PostConstruct
    public void loadData(){
        usersList = new ArrayList<>();
        usersList.add(new User("Jim", "Jones", 87, 1));
        usersList.add(new User("Mike", "Jones", 38, 2));
        usersList.add(new User("John", "Jones", 35, 3));
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        //Skipping DB crud for now
        return  usersList;
    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable int userId){
        for(User u: usersList){
            if(u.getUserId() == userId){
                return u;
            }
        }
        return null;
    }

}
