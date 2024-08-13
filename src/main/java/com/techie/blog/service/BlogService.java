package com.techie.blog.service;

import com.techie.blog.dto.BlogCommentPost;
import com.techie.blog.dto.BlogPost;
import com.techie.blog.dto.UserBlogResponse;

public interface BlogService {
    boolean addPostByUser(BlogPost blogPost);

    boolean addCommentToPostByPostId(BlogCommentPost blogCommentPost);

    UserBlogResponse getBlogsByUserId(Long userId);
}
