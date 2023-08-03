package kr.jinseok.eatgo.Interface;

public class PasswordWrongException extends RuntimeException{
    public PasswordWrongException(){

        super("password is wrong");
    }
}
