package com.microservice.rating.controller;

import com.microservice.rating.entities.Rating;
import com.microservice.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PreAuthorize("hasAnyAuthority('ADMIN') ")
    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }


    @GetMapping
    public ResponseEntity<List<Rating>> getRating(){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatings());
    }

    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAnyAuthority('ADMIN') ")
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingsByUserId(userId));
    }


    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingsByHotelId(hotelId));
    }
}
