package com.techie.blog.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "b_comment_data")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "COMMENT", length = 2500)
    private String comment;

    @Column(name = "USER_NAME", length = 100)
    private String userName;

    @Column(name = "CREATED_BY", length = 100)
    private String createdBy;

    @Column(name = "CREATED_DT")
    private LocalDateTime createdDt;

    @Column(name = "UPDATED_BY", length = 100)
    private String updatedBy;

    @Column(name = "UPDATED_DT")
    private LocalDateTime updatedDt;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private Blog blogPost;
}
