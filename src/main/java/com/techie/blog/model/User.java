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
@Table(name = "b_user_details")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "User_Name", length = 100)
    private String userName;

    @Column(name = "First_Name", length = 100)
    private String firstName;

    @Column(name = "Middle_Name", length = 100)
    private String middleName;

    @Column(name = "Last_Name", length = 100)
    private String lastName;

    @Column(name = "Password", length = 100)
    private String password;

    @Column(name = "Creatd_By", length = 100)
    private String createdBy;

    @Column(name = "Created_Dt")
    private LocalDateTime createdDt;

    @Column(name = "Updated_By", length = 100)
    private String updatedBy;

    @Column(name = "Updated_Dt")
    private LocalDateTime updatedDt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Blog> blogList;
}
