package com.code.userservice.repository;

import com.code.userservice.entity.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<Company,String> {

    Company findByUsername(String username);







}
