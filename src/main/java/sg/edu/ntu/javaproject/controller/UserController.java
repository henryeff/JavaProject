package sg.edu.ntu.javaproject.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import sg.edu.ntu.javaproject.entity.Account;
import sg.edu.ntu.javaproject.entity.User;
import sg.edu.ntu.javaproject.service.UserService;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //create a new user
    @PostMapping({ "", "/" })
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        //String accountJson = objectMapper.writeValueAsString(newAccount);
        log.info("new user created: ");
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    

}
