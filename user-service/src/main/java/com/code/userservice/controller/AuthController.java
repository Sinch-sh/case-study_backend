package com.code.userservice.controller;

import com.code.userservice.entity.AuthenticationRequest;
import com.code.userservice.entity.AuthenticationResponse;
import com.code.userservice.entity.Company;
import com.code.userservice.repository.UserRepository;
import com.code.userservice.security.CustomUserDetailsService;
import com.code.userservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;



    @RequestMapping("/dashboard")
    public String TestToken(){
        return "Welcome to dashboard "+ SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @RequestMapping("/subs")
    public ResponseEntity<?> subscribeClient(@RequestBody AuthenticationRequest authenticationRequest){
        String username=authenticationRequest.getUsername();
        String password=authenticationRequest.getPassword();
        Company user=new Company();
        user.setUsername(username);
        user.setPassword(password);
        try{
            userRepository.save(user);
        }
        catch(Exception e)
        {
            return ResponseEntity.ok(new AuthenticationResponse("error during client subscription"));
        }
        return ResponseEntity.ok(new AuthenticationResponse("successful client subscription"));
    }

    @RequestMapping("/auth")
    public ResponseEntity<?> authenticateClient(@RequestBody AuthenticationRequest authenticationRequest){
        String username=authenticationRequest.getUsername();
        String password=authenticationRequest.getPassword();

        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }
        catch(Exception e)
        {
            return ResponseEntity.ok(new AuthenticationResponse("error during client authentication"+username));
        }

        UserDetails loadedUser=customUserDetailsService.loadUserByUsername(username);
        String generatedToken=jwtUtil.generateToken(loadedUser);
        return ResponseEntity.ok(new AuthenticationResponse(generatedToken));
    }
}
