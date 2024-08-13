package com.techie.blog.controller;

import com.techie.blog.dto.UserAddRequest;
import com.techie.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(name = "/validate")
    @ResponseStatus(HttpStatus.OK)
    public boolean isValidUser(@PathVariable("userid") Long userId) {
        return userService.isValidUser(userId);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean isUserCreated(@RequestBody UserAddRequest userAddRequest) {
        return this.userService.addUser(userAddRequest);
    }
}
