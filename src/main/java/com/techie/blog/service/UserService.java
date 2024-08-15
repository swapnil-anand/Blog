package com.techie.blog.service;

import com.techie.blog.dto.UserAddRequest;

public interface UserService {
    boolean isValidUser(String userName);

    boolean addUser(UserAddRequest userAddRequest);
}
