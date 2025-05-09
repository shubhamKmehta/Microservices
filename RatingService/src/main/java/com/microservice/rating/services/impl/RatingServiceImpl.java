package com.microservice.rating.services.impl;

import com.microservice.rating.entities.Rating;
import com.microservice.rating.repository.RatingRepo;
import com.microservice.rating.services.RatingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepo repo;

    public RatingServiceImpl(RatingRepo repo){
        this.repo = repo;
    }

    @Override
    public Rating create(Rating rating) {
        return repo.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return repo.findAll();
    }

    @Override
    public List<Rating> getRatingsByUserId(String userId) {
        return repo.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingsByHotelId(String hotelId) {
        return repo.findByHotelId(hotelId);
    }
}
