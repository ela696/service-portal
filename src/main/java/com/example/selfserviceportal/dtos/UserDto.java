package com.example.selfserviceportal.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private boolean isActive;
    private String password;

    private List<Role> roles;



}
