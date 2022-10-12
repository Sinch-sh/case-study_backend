package com.code.userservice.service;

import com.code.userservice.entity.Company;
import com.code.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;
    @Autowired
    MongoTemplate mongoTemplate;

    public Company addUser(Company user) {

        return userRepository.insert(user);
    }

    public Company updateUser(Company user) throws Exception {
        Optional<Company> op = userRepository.findById(user.getId());
        if (op.isPresent()) {
            Company user1 = op.get();
            userRepository.save(user);
            return user1;
        } else {
            throw new Exception();
        }
    }

    public List<Company> getAllUsers() {

        return userRepository.findAll();
    }

    public Company getUserById(String id)  {
        Optional<Company> op = userRepository.findById(id);
        if (op.isPresent()) {
            return op.get();
        } else {
           return null;
        }

    }

    public String deleteUser(String id) {
        Optional<Company> op = userRepository.findById(id);
        if (op.isPresent()) {
            //userRepository.delete(op.get());
            Company user = op.get();
            if (user.isDeleted() == false) {
                user.setDeleted(true);
                userRepository.save(user);
            } else {
                return null;
            }
        }
        return null;
    }
}





