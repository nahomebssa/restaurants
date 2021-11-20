package com.example.restaurants.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@Data
class Restaurant {
    private int id;
    private String name;
}

@RestController
public abstract class RestaurantAPI {

    @GetMapping("/api/restaurants")
    public List<Restaurant> getRestaurants() {
        return null;
    }

    @GetMapping("/api/restaurants/{id}")
    public Restaurant getRestaurant(@PathVariable int id) {
        return null;
    }

    @PostMapping("/api/restaurants/add")
    public Restaurant addRestaurant(@RequestBody Restaurant r) {
        // check if user is allowed to add a restaurant
        // via /api/users/...
        return null;
    }

    @DeleteMapping("/api/restaurants")
    public Restaurant deleteRestaurant(@RequestBody Restaurant r) {
        // notify reviews restaurant is delete
        // via /api/reviews/events/restaurant-deleted
        return null;
    }

    @PostMapping("/api/restaurants/update")
    public Restaurant updateRestaurant(@RequestBody Restaurant r) {
        return null;
    }

    @PostMapping("/api/restaurants/add-rating")
    public Restaurant addRating(@RequestBody Restaurant r) {
        return null;
    }

}