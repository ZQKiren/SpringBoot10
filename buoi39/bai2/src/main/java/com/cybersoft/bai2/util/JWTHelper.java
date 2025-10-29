package com.cybersoft.bai2.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JWTHelper {

    private final SecretKey key;
    private final long expirationMs;

    public JWTHelper(
            @Value("${secret-key.jwt}") String secret,
            @Value("${secret-key.is-base64}") boolean isBase64,
            @Value("${secret-key.expiration-ms}") long expirationMs
    ) {
        String s = secret == null ? "" : secret.trim();
        this.key = isBase64
                ? Keys.hmacShaKeyFor(Decoders.BASE64.decode(s))
                : Keys.hmacShaKeyFor(s.getBytes(StandardCharsets.UTF_8));
        this.expirationMs = expirationMs;
    }

    public String generateToken(String subject) {
        Date now = new Date();
        Date exp = new Date(now.getTime() + expirationMs);
        return Jwts.builder()
                .subject(subject)
                .issuedAt(now)
                .expiration(exp)
                .signWith(key, Jwts.SIG.HS256)
                .compact();
    }

    public String validateToken(String token) {
        try {
            return Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload()
                    .getSubject();
        } catch (JwtException | IllegalArgumentException e) {
            return null;
        }
    }
}
