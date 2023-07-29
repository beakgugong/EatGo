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

    @GetMapping("/restaurants")
    public List<Restaurant> list(){
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        return restaurants;
    }
    @GetMapping("/restaurant")
    public List<Restaurant> list(@RequestParam("region") String region,
                                 @RequestParam("categoryId") Long categoryId){
        List<Restaurant> restaurants = restaurantService.getRestaurants(region,categoryId);
        return restaurants;
    }
    @GetMapping("/restaurant/{id}")
    public Restaurant detail(@PathVariable("id") Long id){
        Restaurant restaurant = restaurantService.getRestaurant(id);

        return restaurant;
    }
    /*@GetMapping("/restaurants/{location}")
    public List<Restaurant> region(@PathVariable("location") String location){
        List<Restaurant> restaurants = restaurantService.getRegion(location);
        return  restaurants;
    }*/

}
