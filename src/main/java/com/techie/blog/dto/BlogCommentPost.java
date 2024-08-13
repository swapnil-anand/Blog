package com.techie.blog.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BlogCommentPost {
    private Long blogId;
    private String comments;
    private String userName;
    private String commentedBy;
}
