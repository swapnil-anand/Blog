package com.techie.blog.dto;

import lombok.*;

import java.util.Set;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BlogDto {
    private String author;
    private String blogContent;
    private String title;
    private Set<CommentsDto> comments;
}
