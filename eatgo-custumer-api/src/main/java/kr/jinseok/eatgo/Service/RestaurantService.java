package kr.jinseok.eatgo.Service;

import kr.jinseok.eatgo.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    private RestaurantRepository restaurantRepository;
    private MenuRepository menuRepository;
    private ReviewRepository reviewRepository;
    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository, MenuRepository menuRepository, ReviewRepository reviewRepository){
        this.restaurantRepository = restaurantRepository;
        this.menuRepository = menuRepository;
        this.reviewRepository = reviewRepository;
    }
    public Restaurant getRestaurant(Long id){
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(()->new RestaurantNotFoundException(id));
        List<Menu> menu = menuRepository.findAllByRestaurantId(id);

        List<Review> review = reviewRepository.findAllByRestaurantId(id);
        restaurant.setReviews(review);
        restaurant.setMenus(menu);
        return restaurant;
    }
    public List<Restaurant> getRestaurants(){
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants;
    }

    public List<Restaurant> getRestaurants(String region, Long categoryId) {
        List<Restaurant> restaurants = restaurantRepository.findAllByLocationContainingAndCategoryId(region, categoryId);
        return restaurants;
    }

    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Transactional
    public Restaurant updateRestaurant(Long id, String name, String location) {
        Restaurant restaurant = restaurantRepository.findById(id).orElse(null);

        restaurant.setName(name);
        restaurant.setLocation(location);

        return restaurant;
    }

    //location null로 뜸
}
