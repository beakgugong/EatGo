package kr.jinseok.eatgo.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class JwtUtil {
    private Key key;
    public JwtUtil(String secret){
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }
    public String jwtCreate(long l, String name, Long restaurantId){

        JwtBuilder builder = Jwts.builder()
                .claim("userId", l)
                .claim("userName", name);
        if(restaurantId!=null){
            builder = builder.claim("restaurantId", restaurantId);
        }
        String token = builder
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
        return token;
    }
    public Claims getClaims(String token){
        Claims claims= Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws (token)
                .getBody();
        return claims;
    }
}

