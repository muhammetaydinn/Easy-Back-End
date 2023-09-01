package com.example.Easy.Services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    private final static String SECRET_KEY="uOUnp+/pZyEGl83RYAmqpp1VmPz0MhkkoyrdsSz/50E=";
    public String extractUserName(String token) {
        return extractClaim(token,Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims,T> claimsTFunction){
        final Claims claims =extractClaims(token);
        return claimsTFunction.apply(claims);
    }
    private Claims extractClaims(String token){

        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build().parseClaimsJwt(token).getBody();
    }
    public String generateToken(UserDetails user){
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ 1000+60*24))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    public String generateToken(Map<String,Object> extraClaims, UserDetails user){
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ 1000+60*24))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    private Key getSigningKey() {

        byte[] keyBytes= Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
