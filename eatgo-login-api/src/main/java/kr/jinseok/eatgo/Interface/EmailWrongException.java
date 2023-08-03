package kr.jinseok.eatgo.Interface;

public class EmailWrongException extends RuntimeException{
    public EmailWrongException(){
        super("email is wrong");

    }
}
