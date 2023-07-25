package kr.jinseok.eatgo.Service;

import kr.jinseok.eatgo.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RestaurantService {

    private RestaurantRepository restaurantRepository;
    private MenuRepository menuRepository;
    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository,MenuRepository menuRepository){
        this.restaurantRepository = restaurantRepository;
        this.menuRepository = menuRepository;

    }
    public Restaurant getRestaurant(Long id){
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(()->new RestaurantNotFoundException(id));
        restaurant.setMenus(menuRepository.findAllByRestaurantId(id));

        return restaurant ;
    }

    public List<Restaurant> getRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
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
