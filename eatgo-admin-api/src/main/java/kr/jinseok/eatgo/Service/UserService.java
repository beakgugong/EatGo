package kr.jinseok.eatgo.Service;

import kr.jinseok.eatgo.domain.Users;
import kr.jinseok.eatgo.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<Users> getUsers(){
        List<Users> users = userRepository.findAll();

        return users;
    }
    public Users addUser(Users user){
        Users user1 = Users.builder()
                .email(user.getEmail())
                .level(user.getLevel())
                .name(user.getName()).build();
        userRepository.save(user1);
    return user1;
    }

    public Users updateUser(Long id,Users users) {
        Users users1 = userRepository.findById(id).orElse(null);
        users1.setName(users.getName());
        users1.setName(users.getName());
        users1.setEmail(users.getEmail());

        return users1;
    }

}

