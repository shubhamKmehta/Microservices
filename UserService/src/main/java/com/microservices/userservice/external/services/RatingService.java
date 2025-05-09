package com.microservices.userservice.external.services;

import com.microservices.userservice.entities.Rating;
import org.jvnet.hk2.annotations.Service;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @PostMapping("/ratings")
    ResponseEntity<Rating> createRating(Rating values);


    //PUT
    @PutMapping("/ratings/{ratingId}")
    ResponseEntity<Rating> updateRating(@PathVariable("ratingId") String ratingId, Rating rating);


    @DeleteMapping("/ratings/{ratingId}")
    void deleteRating(@PathVariable String ratingId);
}
