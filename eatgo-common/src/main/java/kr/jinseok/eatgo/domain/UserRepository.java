package kr.jinseok.eatgo.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<Users,Long> {
    List<Users> findAll();
    Optional<Users> findById(Long id);
    Optional<Users> findByEmail(String email);
}
