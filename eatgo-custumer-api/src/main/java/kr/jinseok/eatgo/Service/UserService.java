package kr.jinseok.eatgo.Service;

import kr.jinseok.eatgo.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Users register(Users resource) {
        Optional<Users> exist = userRepository.findByEmail(resource.getEmail());

        if (exist.isPresent()) {
            throw new EmailExistedException(resource.getEmail());
        }

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hash = passwordEncoder.encode(resource.getPassword());
        Users users = Users.builder()
                .email(resource.getEmail())
                .name(resource.getEmail())
                .password(hash)
                .build();
        return userRepository.save(users);
    }
}
