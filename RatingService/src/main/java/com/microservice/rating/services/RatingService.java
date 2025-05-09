package com.microservice.rating.services;

import com.microservice.rating.entities.Rating;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public interface RatingService {

    Rating create(Rating rating);

    List<Rating> getRatings();
    List<Rating> getRatingsByUserId(String userId);
    List<Rating> getRatingsByHotelId(String hotelId);



}
