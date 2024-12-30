package com.ecommerce.storehub.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class JwtTokenUtil {

    private static final String secretKey = "4E645266556A586E3272357538782F413F4428472B4B6250655368566B597033";
    private long validityInMilliseconds = 3600000; // 1 hour

    // Generate JWT Token
    public String generateToken(Authentication authentication) {
        List<String> roles = new ArrayList<>();
        authentication.getAuthorities().forEach(authority -> roles.add(authority.getAuthority()));

        String username = authentication.getName();
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder().subject(username).issuedAt(now).expiration(validity).claim("roles", roles)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // Parse JWT Token
    public Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .build().parseSignedClaims(token).getPayload();
    }

    // Validate JWT Token
    public boolean isTokenValid(String token) {
        String username = getClaims(token).getSubject();
        return (username!=null && !isTokenExpired(token));
    }

    // Check Token Expiry
    private boolean isTokenExpired(String token) {
        Date expiration = getClaims(token).getExpiration();
        return expiration.before(new Date());
    }

    public Authentication getAuthentication(String token) {
        Claims claims = getClaims(token);
        String username = claims.getSubject();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        // Here we assume roles are stored in a "roles" claim in the JWT token
        List<String> roles = claims.get("roles", List.class);
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }

        // Return an Authentication object
        return new UsernamePasswordAuthenticationToken(username, "", authorities);
    }
}
