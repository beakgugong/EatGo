package kr.jinseok.eatgo.controller;

import kr.jinseok.eatgo.domain.Restaurant;
import kr.jinseok.eatgo.Service.RestaurantService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RestaurantController.class)
class RestaurantControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private RestaurantService restaurantService;
    //@SpyBean(RestaurantRepositoryImpl.class)
    //private RestaurantRepository restaurantRepository;


    @Test
    public void list() throws Exception {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1004L,"bob zip","seoul"));
        given(restaurantService.getRestaurants()).willReturn(restaurants);
        mvc.perform(get("/restaurant"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("bob zip")))
                .andExpect(content().string(containsString("seoul")))
                .andExpect(content().string(containsString("kimchi")));

    }
    @Test
    public void detail() throws Exception {
        mvc.perform(get("/restaurant/1004"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\":1004")))
                .andExpect(content().string(containsString("\"name\":\"bob zip\"")));
        mvc.perform(get("/restaurant/2020"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\":2020")))
                .andExpect(content().string(containsString("\"name\":\"cyber food\"")));
    }

    @Test
    public void create() throws Exception{


        mvc.perform(post("/restaurant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Beryong\", \"location\":\"seoul\"}"))
                .andExpect(status().isCreated())
                .andExpect(header().string("location","/restaurant/1234"))
                .andExpect(content().string("{}"));

        verify(restaurantService).addRestaurant(any());
    }
    @Test
    public void update() throws Exception{
        mvc.perform(patch("/restaurant/1004")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Joker Bar\", \"location\":\"Busan\"}"))
                .andExpect(status().isOk());
        verify(restaurantService).updateRestaurant(1004L,"Joker bar","Busan");
    }
}