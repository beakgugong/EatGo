package kr.jinseok.eatgo.Service;

import kr.jinseok.eatgo.domain.Restaurant;
import kr.jinseok.eatgo.domain.RestaurantRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;

class RestaurantServiceTest {
    private RestaurantService restaurantService;

    private RestaurantRepository restaurantRepository;
    /*@BeforeEach
    public void setUp(){

        RestaurantRepository restaurantRepository = new RestaurantRepositoryImpl();

        restaurantService = new RestaurantService(restaurantRepository);
    }*/
    private void mockRestaurantRepository() {
        List<Restaurant> restaurants = new ArrayList<>();
        Restaurant restaurant = new Restaurant(1004L, "Bob zip", "seoul");
        restaurants.add(restaurant);
    }

    @Test
    public void getRestaurant(){
        Restaurant restaurant = restaurantService.getRestaurant(1004L);
        assertThat(restaurant.getId()).isEqualTo(1004L);
    }
    @Test
    public void getRestaurants(){
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        Restaurant restaurant = restaurants.get(0);
        assertThat(restaurant.getId()).isEqualTo(1004L);
    }

    @Test
    public void addRestaurant() {
        Restaurant newRestaurant = restaurantService.addRestaurant(new Restaurant("Beryong","seoul"));
        Restaurant saved = new Restaurant(1234L,"Beryong","seoul");

        //given(restaurantRepository.save(any())).willReturn( saved);
        assertThat(newRestaurant.getId()).isEqualTo(1234L);
    }

    @Test
    public void updateRestaurant() {
        Restaurant restaurant = new Restaurant(1004L,"Bob zip", "seoul");
        given(restaurantRepository.findById(1004L)).willReturn(Optional.of(restaurant));

        restaurantService.updateRestaurant(1004L,"Sul zip", "Busan");

        assertThat(restaurant.getName()).isEqualTo("Sul zip");
    }
}