package kr.jinseok.eatgo.domain;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
class RestaurantTest {
    @Test
    public void creation(){
        Restaurant restaurant = Restaurant.builder()
                .id(1004L)
                .name("bob zip")
                .location("seoul")
                 .build();
        assertThat(restaurant.getName()).isEqualTo("bob zip");
        assertThat(restaurant.getLocation()).isEqualTo("seoul");
        assertThat(restaurant.getId()).isEqualTo(1004L);
    }

}