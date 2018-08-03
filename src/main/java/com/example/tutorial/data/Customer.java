package com.example.tutorial.data;

import org.springframework.data.annotation.Id;


public class Customer {

    @Id
    public String id;

    public String firstName;
    public String lastName;

    public String car;

    public Customer(String firstName, String lastName, String car) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.car = car;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName, car);
    }

}