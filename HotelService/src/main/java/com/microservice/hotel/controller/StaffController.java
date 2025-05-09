package com.microservice.hotel.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/staffs")
public class StaffController {

    @GetMapping
    public ResponseEntity<List<String>> getStaffs(){
        List<String> list = new ArrayList<>();
        list.add("Michael");
        list.add("Daniel");
        list.add("Rafael");
        list.add("Julian");
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
