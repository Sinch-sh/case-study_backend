package com.code.userservice.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthenticationRequest {
    private String username;
    private String password;


}
