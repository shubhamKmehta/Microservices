package com.microservice.hotel.services.impl;

import com.microservice.hotel.entities.Hotel;
import com.microservice.hotel.exception.ResourceNotFoundException;
import com.microservice.hotel.repositories.HotelRepo;
import com.microservice.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {


    private final HotelRepo hotelRepo;

    public HotelServiceImpl(HotelRepo hotelRepo) {
        this.hotelRepo = hotelRepo;
    }

    @Override
    public Hotel create(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepo.save(hotel);

    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepo.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel not found"));
    }
}
