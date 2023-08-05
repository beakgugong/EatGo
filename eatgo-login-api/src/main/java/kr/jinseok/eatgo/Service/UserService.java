package kr.jinseok.eatgo.Service;


import kr.jinseok.eatgo.Interface.EmailWrongException;
import kr.jinseok.eatgo.Interface.PasswordWrongException;
import kr.jinseok.eatgo.Interface.SessionRequestDto;
import kr.jinseok.eatgo.domain.Users;
import kr.jinseok.eatgo.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Users authenticate(SessionRequestDto sessionRequestDto)
    {
        Users exist = userRepository.findByEmail(sessionRequestDto.getEmail()).orElseThrow(()-> new EmailWrongException());
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if(passwordEncoder.matches(sessionRequestDto.getPassword(), exist.getPassword())){
            return exist;
        }
        else throw new PasswordWrongException();
    }
}
