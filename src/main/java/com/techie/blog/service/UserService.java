package com.techie.blog.service;

import com.techie.blog.dto.UserAddRequest;

public interface UserService {
    boolean isValidUser(Long userId);

    boolean addUser(UserAddRequest userAddRequest);
}
