package com.microservices.userservice.services.impl;

import com.microservices.userservice.entities.Hotel;
import com.microservices.userservice.entities.Rating;
import com.microservices.userservice.entities.User;
import com.microservices.userservice.exceptions.ResourceNotFoundException;
import com.microservices.userservice.external.services.HotelService;
import com.microservices.userservice.repository.UserRepo;
import com.microservices.userservice.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@SuppressWarnings("ALL")
@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final RestTemplate restTemplate;
    private final HotelService hotelService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepo userRepo, RestTemplate restTemplate,HotelService hotelService) {
        this.userRepo = userRepo;
        this.restTemplate = restTemplate;
        this.hotelService = hotelService;
    }



    @Override
    public User saveUser(User user) {
        // generate unique user id

        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);

        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUser(String userId) {
       User user =  userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Rating[] ratingOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users" + user.getUserId(), Rating[].class);
        logger.info("{}",ratingOfUser);

        List<Rating> ratings = Arrays.stream(ratingOfUser).toList();
        List<Rating> ratingList = ratings.stream().map(rating ->{

           Hotel hotel = hotelService.getHotel(rating.getHotelId());
           rating.setHotel(hotel);

           return rating;

        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        return  user;
    }

    @Override
    public User deleteUserById(String userId) {
        return null;
    }

    @Override
    public User updateUserById(String userId, User user) {
        return null;
    }
}
