package com.code.userservice.entity;


public class AuthenticationResponse {

    String response;

    public AuthenticationResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public AuthenticationResponse() {
    }
}
