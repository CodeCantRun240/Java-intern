package backend.security;

import backend.model.CreateUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

    @Component
    public class JwtUtil {

        private final String SECRET = "role-based-authentication-practical-1234567890";

        private final SecretKey secretKey = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

        public SecretKey getSecretKey() {
            return this.secretKey;
        }



        public String generateToken(UserDetails userDetails, String position) {

            return Jwts.builder()
                    .setSubject(userDetails.getUsername())
                    .claim("position", position)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 1 day
                    .signWith(secretKey, SignatureAlgorithm.HS256)
                    .compact();
        }

        public String extractUsername(String token) {
            return Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        }

        public boolean validateToken(String token, UserDetails userDetails) {
            String username = extractUsername(token);
            return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
        }

        private boolean isTokenExpired(String token) {
            Date expiration = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody()
                    .getExpiration();
            return expiration.before(new Date());
        }



    }


