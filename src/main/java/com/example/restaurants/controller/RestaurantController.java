package com.example.restaurants.controller;

import com.example.restaurants.model.Restaurant;
import com.example.restaurants.view.RestaurantDetailView;
import com.example.restaurants.view.RestaurantsMasterView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RestaurantController {

    @Autowired
    private RestaurantsMasterView restaurantsMasterView;
    
    @Autowired
    private RestaurantDetailView restaurantDetailView;


    @GetMapping("/")
    public RedirectView getIndex() {
        return new RedirectView("/restaurants");
    }

    @GetMapping("/r/{id}")
    public String getRestaurant(@PathVariable int id, Model model) {
        var rt = new RestTemplate();
        var response = rt.getForObject("http://localhost:8080/restaurants/"+id, Restaurant.class);
        model.addAttribute("name", "Restaurants");
        model.addAttribute("baseUrl", "http://localhost:8082");
        model.addAttribute("restaurant", response);
        return restaurantDetailView.DisplayRestaurantDetails();
    }

    @GetMapping("/restaurants")
    public String ListRestaurant(Model model) {
        var restaurants = Restaurant.GetRestaurants();
        model.addAttribute("name", "Restaurants");
        model.addAttribute("baseUrl", "http://localhost:8082");
        model.addAttribute("restaurants", restaurants);
        return restaurantsMasterView.DisplayRestaurants();
    }

}
