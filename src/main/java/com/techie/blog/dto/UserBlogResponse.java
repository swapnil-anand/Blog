package com.techie.blog.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserBlogResponse {
    private String userName;
    private String firstName;
    private String lastName;
    private Long userId;
    private Set<BlogDto> blogs;
}
