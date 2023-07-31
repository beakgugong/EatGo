package kr.jinseok.eatgo.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmailExistedException extends RuntimeException{
     public EmailExistedException(String email){
        super("Email is already registered: "+ email);
    }
}
