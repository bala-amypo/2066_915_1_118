package com.example.demo.security;

import com.example.demo.model.AppUser;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtTokenProvider {
    private String secret = "secretKey1234567890123456789012345678901234567890";
    private long validity = 3600000; // 1h

    public String generateToken(AppUser user) {
        Claims claims = Jwts.claims().setSubject(user.getUsername());
        claims.put("role", user.getRole());
        return Jwts.builder().setClaims(claims).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + validity))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) { return false; }
    }
}