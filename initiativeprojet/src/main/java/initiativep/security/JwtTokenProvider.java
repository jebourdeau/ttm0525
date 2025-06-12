package initiativep.security;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import initiativep.model.User;
import initiativep.services.UserService;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;


@Component
@Slf4j
@RequiredArgsConstructor
public class JwtTokenProvider {
    @Value("${jwt.secret}")
    private String jwtSecret;
    @Value("${jwt.expiration}")
    private long jwtExpirationInMs;


    public String generateToken(User user) {
        ObjectMapper objectMapper = new ObjectMapper();

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
        byte[] keyBytes = jwtSecret.getBytes();
        Map<String, Object> claims = objectMapper
                .convertValue(user, new TypeReference<Map<String, Object>>() {});
       claims.remove("password");
       claims.put("sub", user.getUsername());
       claims.put("role", user.getClass().getSimpleName().toLowerCase());
        return Jwts.builder()
        .setSubject(user.getUsername())
        .setClaims(claims)
        .setIssuedAt(now)
        .setExpiration(expiryDate)
        .signWith(SignatureAlgorithm.HS512, jwtSecret.getBytes())
        .compact();
}
    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parser()
        .setSigningKey(jwtSecret.getBytes())
        .parseClaimsJws(token)
        .getBody();
        return claims.getSubject();
    }
    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret.getBytes()).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            log.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }
}