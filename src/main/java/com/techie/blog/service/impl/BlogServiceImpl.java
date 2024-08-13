package com.techie.blog.service.impl;

import com.techie.blog.dto.*;
import com.techie.blog.model.Blog;
import com.techie.blog.model.Comments;
import com.techie.blog.model.User;
import com.techie.blog.repository.BlogRepository;
import com.techie.blog.repository.CommentsRepository;
import com.techie.blog.repository.UserRepository;
import com.techie.blog.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentsRepository commentsRepository;


    @Override
    public boolean addPostByUser(BlogPost blogPost) {

        Optional<User> user = this.userRepository.findById(blogPost.getUserId());

        if (user.isEmpty()) {
            log.info("User Not Found for User id: {}", blogPost.getUserId());
            return false;
        }

        Blog blogModel = new Blog();
        blogModel.setBlogContent(blogPost.getBlogContent());
        blogModel.setAuthor(blogPost.getAuthor());
        blogModel.setTitle(blogPost.getTitle());
        blogModel.setCreatedBy(blogPost.getCratedBy());
        blogModel.setCreatedDt(LocalDateTime.now());
        blogModel.setLastUpdatedBy(blogPost.getUpdatedBy());
        blogModel.setLastUpdatedDt(LocalDateTime.now());
        blogModel.setUser(user.get());
        this.blogRepository.save(blogModel);

        log.info("Blog Saved Successfully with id: {} ", blogModel.getId());
        return true;
    }

    @Override
    public boolean addCommentToPostByPostId(BlogCommentPost blogCommentPost) {
        Optional<Blog> blog = this.blogRepository.findById(blogCommentPost.getBlogId());
        if (blog.isEmpty()) {
            log.info("Blog Not Present with Blog id {}", blogCommentPost.getBlogId());
            return false;
        }

        Comments comments = new Comments();
        comments.setComment(blogCommentPost.getComments());
        comments.setBlogPost(blog.get());
        comments.setCreatedBy(blogCommentPost.getCommentedBy());
        comments.setCreatedDt(LocalDateTime.now());
        comments.setUserName(blogCommentPost.getUserName());

        this.commentsRepository.save(comments);
        log.info("Comments Saved Successfully {}", comments.getId());
        return true;
    }

    @Override
    public UserBlogResponse getBlogsByUserId(Long userId) {

        Optional<User> user = this.userRepository.findById(userId);

        if (user.isEmpty())
            throw new IllegalStateException("No User found!");

        Set<Blog> blogSet = user.get().getBlogList();

        Set<BlogDto> blogDto =
                blogSet
                        .stream()
                        .map(blog ->
                                BlogDto.builder()
                                        .blogContent(blog.getBlogContent())
                                        .title(blog.getTitle())
                                        .author(blog.getAuthor())
                                        .comments(
                                                blog.getCommentSet()
                                                        .stream()
                                                        .map(c -> CommentsDto.builder()
                                                                .userName(c.getUserName())
                                                                .comments(c.getComment())
                                                                .build())
                                                        .collect(Collectors.toSet())
                                        )
                                        .build()
                        ).collect(Collectors.toSet());

        UserBlogResponse response = new UserBlogResponse();
        response.setUserId(user.get().getId());
        response.setUserName(user.get().getUserName());
        response.setLastName(user.get().getLastName());
        response.setFirstName(user.get().getFirstName());
        response.setBlogs(blogDto);


        return response;
    }
}
