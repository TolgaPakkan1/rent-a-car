package com.example.RentACar.service;

import com.example.RentACar.dto.LoginDto;
import com.example.RentACar.model.User;
import com.example.RentACar.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;
import java.util.*;
import java.util.function.Function;

/* kullanıcı varsa extrat eder, yoksa generate eder */
@Service

public class JwtService {

    @Autowired
    private UserRepository userRepository;

    private static final String SECRET = "404D635166546A576E5A7234753778214125442A472D4B6150645267556B5870";

    public String extractEmail(String token){
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        Claims claims= extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parser()
                .verifyWith(getSingKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public LoginDto generateToken(Authentication authentication){
        LoginDto loginDto = new LoginDto();
        Optional<User> userOptional = userRepository.findByEmail(authentication.getName());

        Map<String, Object> claims = new HashMap<>();
        claims.put("authorities", authentication.getAuthorities());
        claims.put("name", authentication.getName());
        if (userOptional.isPresent()){
            loginDto.setUserId(userOptional.get().getId());
        }
        loginDto.setToken(createToken(claims,authentication.getName()));

        return loginDto;
    }

    private String createToken( Map<String, Object> claims, String name){
       return Jwts.builder()
               .claims(claims)
               .subject(name)
               .issuedAt(new Date(System.currentTimeMillis()))
               .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
               .signWith(getSingKey())
               .compact();
    }

    private SecretKey getSingKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public boolean validateToken(String token, UserDetails userDetails){
        final  String email = extractEmail(token);
        return (email.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }


}
