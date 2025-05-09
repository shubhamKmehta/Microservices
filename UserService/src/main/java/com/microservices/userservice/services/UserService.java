package com.microservices.userservice.services;

import com.microservices.userservice.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String userId);

    User deleteUserById(String userId);
    User updateUserById(String userId, User user);


}
