package com.techie.blog.dto;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommentsDto {
    private String comments;
    private String userName;
}
