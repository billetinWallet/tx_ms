package com.wallet.tx_ms.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class Validator{
    protected static String scrt = "3f2d6a6bc52e789ce88dac6f183291837bd0ea53099d34b81a4bf90c47e897919630cdfb935c2abe016ee4753b5764300c4294dc5b655fe67cff7fe2fc659dff";
    public static boolean validateToken(String token){
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

    public static boolean validateUser(String token, String requestedId){
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

