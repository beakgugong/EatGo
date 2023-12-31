package kr.jinseok.eatgo.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review,Long> {
    List<Review> findAllByRestaurantId(Long id);
    List<Review> findAll();
}
