package com.techie.blog.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BlogPost {
    private String title;
    private String author;
    private String blogContent;
    private String cratedBy;
    private LocalDateTime createdDt;
    private String updatedBy;
    private String updatedDt;
    private Long userId;
}
