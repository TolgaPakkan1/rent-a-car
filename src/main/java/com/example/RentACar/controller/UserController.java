package com.example.RentACar.controller;

import com.example.RentACar.dto.AuthDto;
import com.example.RentACar.dto.LoginDto;
import com.example.RentACar.dto.UserDto;
import com.example.RentACar.model.User;
import com.example.RentACar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> createUser(@RequestBody User user){
        return  new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginDto> login(@RequestBody AuthDto authDto){
        return new ResponseEntity<>(userService.login(authDto), HttpStatus.OK);
    }
}
