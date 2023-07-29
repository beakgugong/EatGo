package kr.jinseok.eatgo.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<Users,Long> {
    List<Users> findAll();
}
