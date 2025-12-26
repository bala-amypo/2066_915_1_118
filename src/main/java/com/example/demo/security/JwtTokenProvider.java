package com.example.demo.security;

import com.example.demo.model.AppUser;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {
    
    private final String secret;
    private final long validityInMs;
    private final Key key;
    
    public JwtTokenProvider(@Value("${jwt.secret}") String secret, 
                           @Value("${jwt.validity}") long validityInMs) {
        this.secret = secret;
        this.validityInMs = validityInMs;
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }
    
    public String generateToken(AppUser user) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMs);
        
        return Jwts.builder()
            .setSubject(user.getEmail())
            .claim("role", user.getRole().name())
            .claim("userId", user.getId())
            .setIssuedAt(now)
            .setExpiration(validity)
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();
    }
    
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
    
    public String getEmailFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .getBody();
        return claims.getSubject();
    }
    
    public String getRoleFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .getBody();
        return claims.get("role", String.class);
    }
}