package kr.jinseok.eatgo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;




@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Restaurant {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String location;
    @Transient
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private List<Menu> menus;
    @Transient
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private List<Review> reviews;
    public Restaurant(String name, String location) {
        this.name = name;
        this.location = location;
    }
    public Restaurant(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }
    public void setMenus(List<Menu> menus) {
        this.menus = new ArrayList<>(menus );

    }
    public void setName(String name){
        this.name=name;
    }
    public void setLocation(String location){
        this.location=location;
    }
}

