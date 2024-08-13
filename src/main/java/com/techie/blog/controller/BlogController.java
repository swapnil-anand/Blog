package com.techie.blog.controller;

import com.techie.blog.dto.BlogCommentPost;
import com.techie.blog.dto.BlogPost;
import com.techie.blog.dto.UserBlogResponse;
import com.techie.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/add-post")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean addPostByUser(@RequestBody BlogPost blogPost) {
        return blogService.addPostByUser(blogPost);
    }

    @PostMapping("/add-comment")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean addCommentToPost(@RequestBody BlogCommentPost blogCommentPost) {
        return blogService.addCommentToPostByPostId(blogCommentPost);
    }

    @GetMapping("/get-blog")
    @ResponseStatus(HttpStatus.OK)
    public UserBlogResponse getBlogByUserId(@RequestParam("userId") String userId) {
        return blogService.getBlogsByUserId(Long.valueOf(userId));
    }

}
