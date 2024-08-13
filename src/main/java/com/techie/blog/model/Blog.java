package com.techie.blog.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "b_blog_data")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Author")
    private String author;

    @Column(name = "Blog_Content")
    private String blogContent;

    @Column(name = "Created_By")
    private String createdBy;

    @Column(name = "Created_Dt")
    private LocalDateTime createdDt;

    @Column(name = "Last_Updated_By")
    private String lastUpdatedBy;

    @Column(name = "Last_Updated_Dt")
    private LocalDateTime lastUpdatedDt;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @OneToMany(mappedBy = "blogPost", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Comments> commentSet;

}
