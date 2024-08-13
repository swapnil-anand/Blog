package com.techie.blog.service.impl;

import com.techie.blog.dto.UserAddRequest;
import com.techie.blog.model.User;
import com.techie.blog.repository.UserRepository;
import com.techie.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isValidUser(Long userId) {
        return this.userRepository.findById(userId).isPresent();
    }

    @Override
    public boolean addUser(UserAddRequest userAddRequest) {
        String createdBy = userAddRequest.getUserName();

        User newUser = new User();
        newUser.setUserName(userAddRequest.getUserName());
        newUser.setFirstName(userAddRequest.getFirstName());
        newUser.setMiddleName(userAddRequest.getMiddleName());
        newUser.setLastName(userAddRequest.getLastName());
        newUser.setBlogList(new LinkedHashSet<>());
        newUser.setPassword(newUser.getPassword());
        newUser.setCreatedBy(createdBy);
        newUser.setCreatedDt(LocalDateTime.now());
        newUser.setUpdatedBy(createdBy);
        newUser.setUpdatedDt(LocalDateTime.now());

        return this.userRepository.save(newUser).getId() != null;
    }


}
