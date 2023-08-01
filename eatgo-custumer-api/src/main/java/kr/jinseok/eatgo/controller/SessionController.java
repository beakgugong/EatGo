package kr.jinseok.eatgo.controller;

import kr.jinseok.eatgo.Service.SessionRequestDto;
import kr.jinseok.eatgo.Service.SessionResponseDto;
import kr.jinseok.eatgo.Service.UserService;
import kr.jinseok.eatgo.domain.Users;
import kr.jinseok.eatgo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class SessionController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwt;
    @PostMapping("/session")
    public ResponseEntity<SessionResponseDto> create(@RequestBody SessionRequestDto resource) throws URISyntaxException {
        Users users = userService.authenticate(resource);

        String accessToken = jwt.jwtCreate(users.getId(), users.getName());

        SessionResponseDto sessionResponseDto = SessionResponseDto.builder()
                .accessToken(accessToken)
                .build();
        String uri = "/session";

        return ResponseEntity.created(new URI(uri)).body(sessionResponseDto);
    }
}
