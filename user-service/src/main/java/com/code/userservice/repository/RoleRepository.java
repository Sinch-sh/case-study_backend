package com.code.userservice.repository;

import com.code.userservice.entity.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends MongoRepository<Role,String> {

}
