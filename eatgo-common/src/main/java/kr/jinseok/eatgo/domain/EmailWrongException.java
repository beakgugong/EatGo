package kr.jinseok.eatgo.domain;

public class EmailWrongException extends RuntimeException{
    public EmailWrongException(){
        super("email is wrong");

    }
}
