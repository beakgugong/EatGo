package kr.jinseok.eatgo.controller;

import kr.jinseok.eatgo.Service.UserService;
import kr.jinseok.eatgo.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public List<Users> list(){
        List<Users> users = userService.getUsers();
        return users;
    }
    @PostMapping("/users")
    public ResponseEntity<?> create(@RequestBody Users resource) throws URISyntaxException {
        Users user = userService.addUser(resource);


        String uri = "/users/"+user.getId();
        return ResponseEntity.created(new URI(uri)).body("{}");
    }
    @PatchMapping("/users/{id}")
    public String update(@PathVariable("id") Long id, @RequestBody Users resource){
        Users user = userService.updateUser(id,resource);
        return "";
    }
    /*@DeleteMapping("/users/{id}")
    public String delete(@PathVariable("id") Long id){
        userService.deleteId(id);
        return null;
    }*/
}
