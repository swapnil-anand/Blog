package com.techie.blog.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserAddRequest {
    private String firstName;
    private String middleName;
    private String lastName;
    private String userName;
    private String password;
}
