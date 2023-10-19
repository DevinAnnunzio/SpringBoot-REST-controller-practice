package com.annunzio.restcontrollerpractice.rest;

import com.annunzio.restcontrollerpractice.entity.User;
import jakarta.annotation.PostConstruct;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        if(usersList.contains(userId)){
            return usersList.get(userId);
        }
        throw new UserNotFoundException("User with id: " + userId + " not found");
    }

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(UserNotFoundException exception){
        UserErrorResponse errorResponse = new UserErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    //Handle generic exception
    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(Exception exception){
        UserErrorResponse errorResponse = new UserErrorResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
