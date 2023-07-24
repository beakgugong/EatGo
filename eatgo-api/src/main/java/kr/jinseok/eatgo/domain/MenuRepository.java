package kr.jinseok.eatgo.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface MenuRepository extends CrudRepository<Menu,Long>{
    List<Menu> findAllByRestaurantId(Long id);
    void deleteById(Long id);

}
