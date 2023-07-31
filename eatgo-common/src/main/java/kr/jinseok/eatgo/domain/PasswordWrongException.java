package kr.jinseok.eatgo.domain;

public class PasswordWrongException extends RuntimeException{
    public PasswordWrongException(){
        super("password is wrong");
    }
}
