package com.example.tutorial.controller;


import com.example.tutorial.data.Customer;
import com.example.tutorial.data.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    CustomerRepository repository;


    @CrossOrigin
    @GetMapping("/server/data")
    public Customer[] putData(){
        return repository.findAll().toArray(new Customer[repository.findAll().size()]);
    }

    @GetMapping("/")
    public String index(){
        return "Welcome";
    }

}
