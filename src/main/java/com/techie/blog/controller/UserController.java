package com.techie.blog.controller;

import com.techie.blog.dto.UserAddRequest;
import com.techie.blog.exception.ApiRequestException;
import com.techie.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/validate/{username}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public boolean isValidUser(@PathVariable("username") String username) {
        return userService.isValidUser(username);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean isUserCreated(@RequestBody UserAddRequest userAddRequest) {
        return this.userService.addUser(userAddRequest);
    }
}
