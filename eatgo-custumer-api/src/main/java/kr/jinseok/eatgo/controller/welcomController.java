package kr.jinseok.eatgo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcomController {
    @GetMapping("/")
    public String Hello(){
        return "Hello World!!!";
    }
}
