package com.microservices.userservice.repository;

import com.microservices.userservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {

}
