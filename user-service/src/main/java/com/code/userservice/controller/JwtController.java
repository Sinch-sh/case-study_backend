package com.code.userservice.controller;

import com.code.userservice.entity.AuthenticationRequest;
import com.code.userservice.entity.AuthenticationResponse;
import com.code.userservice.security.CustomUserDetailsService;
import com.code.userservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value = "/token")
    public ResponseEntity<?> generateToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        System.out.println(authenticationRequest);
        try{
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));

        }
        catch (UsernameNotFoundException e)
        {
            e.printStackTrace();
            throw new Exception("Bad Credentials");
        }
        //if username password is correct , generate token
        UserDetails userDetails=this.customUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        String token=this.jwtUtil.generateToken(userDetails);
        System.out.println("JWT"+token);
        return  ResponseEntity.ok(new AuthenticationResponse(token));
    }
}
