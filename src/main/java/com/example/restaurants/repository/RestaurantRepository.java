package com.example.restaurants.repository;

import com.example.restaurants.model.Restaurant;

import org.springframework.data.mongodb.repository.MongoRepository;
public interface RestaurantRepository extends MongoRepository<Restaurant, Integer> {}
