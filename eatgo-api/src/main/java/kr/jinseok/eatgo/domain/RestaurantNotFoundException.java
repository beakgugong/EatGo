package kr.jinseok.eatgo.domain;

public class RestaurantNotFoundException extends RuntimeException{
    public RestaurantNotFoundException(Long id){
        super("Cloud not find restaurant"+ id);
    }
}
