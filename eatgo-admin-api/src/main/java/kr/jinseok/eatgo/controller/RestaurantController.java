package kr.jinseok.eatgo.controller;

import kr.jinseok.eatgo.Service.RestaurantService;
import kr.jinseok.eatgo.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
@CrossOrigin
@RestController
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;


    @GetMapping("/restaurant")
    public List<Restaurant> list(){
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        return restaurants;
    }
    @GetMapping("/restaurant/{id}")
    public Restaurant detail(@PathVariable("id") Long id){
        Restaurant restaurant = restaurantService.getRestaurant(id);

        return restaurant;
    }

    @PostMapping("/restaurant")
    public ResponseEntity<?> create(@Validated @RequestBody Restaurant resource) throws URISyntaxException {

        Restaurant restaurant = restaurantService.addRestaurant(Restaurant.builder()
                .name(resource.getName())
                .location(resource.getLocation())
                .build());

        URI address = new URI("/restaurant/1234");
        return ResponseEntity.created(address).body("{}");
    }
    @PatchMapping("/restaurant/{id}")
    public String update(@PathVariable("id") Long id, @RequestBody Restaurant resource){
        String name = resource.getName();
        String location = resource.getLocation();
        restaurantService.updateRestaurant(id, name, location);
        return "{}";
    }

}
