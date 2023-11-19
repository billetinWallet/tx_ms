package com.wallet.tx_ms.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Validator{

    @Value("${JWT_SCRT}")
    protected String scrt;

    public boolean validateToken(String token){
        if (token == null || token.isEmpty()){
            System.out.println("Empty authorization header");
            return false;
        }
        try{
            Claims claims = Jwts.parser().setSigningKey(scrt.getBytes()).parseClaimsJws(token.substring(7)).getBody();
        } catch (Exception e){
            System.out.println("Token validation failed: "+e);
            return false;
        }
        return true;
    }

    public boolean validateUser(String token, String requestedId){
        if (token == null || token.isEmpty()){
            System.out.println("Empty authentication header");
            return false;
        }
        try {
            Claims claims = Jwts.parser().setSigningKey(scrt.getBytes()).parseClaimsJws(token.substring(7)).getBody();
            if (!claims.values().toArray()[0].toString().equals(requestedId)){
                System.out.println("User trying to access protected info");
                return false;
            }
        } catch (Exception e){
            System.out.println("Token validation failed: "+e);
            return false;
        }
        return true;
    }
}

