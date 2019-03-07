package com.bolsadeideas.springboot.app.auth.service;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public interface JWTService {

    public String create(Authentication auth);
    public boolean validateToken(String token);
    public Claims getClaims(String token);
    public Collection<? extends GrantedAuthority> getRoles(String token);
    public String resolve(String token);

}
