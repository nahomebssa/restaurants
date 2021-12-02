package com.example.restaurants.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.client.RestTemplate;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
@Document(collection = "Restaurant")
public class Restaurant {

    @Transient
	public static final String SEQUENCE_NAME = "book_sequence";

    @Id
    private long id;
    private String name;
    private Location location;
    private String cuisine;
    private Tier tier;
    private double rating;


    public static List<Restaurant> GetRestaurants() {
        var response = new RestTemplate();
        return response.getForObject("http://localhost:8080/restaurants", List.class);
    }
}
