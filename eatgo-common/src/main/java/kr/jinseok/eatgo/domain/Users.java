package kr.jinseok.eatgo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String email;
    @NonNull
    private String name;
    private Long level;
    @NonNull
    private String password;
    private Long restaurantId;
    public boolean isRestaurantOwner(){
        if(this.restaurantId!=null){
            return true;
        }
        return false;
    }
}
