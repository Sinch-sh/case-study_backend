package com.code.userservice.security;


import com.code.userservice.entity.Company;
import com.code.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Company user=userRepository.findByUsername(username);
        if(user==null)
            return null;
        String name=user.getUsername();
        String pwd=user.getPassword();
        return new org.springframework.security.core.userdetails.User(name,pwd,new ArrayList<>());

    }
}
