package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.springframework.security.web.context.HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;

public class SecurityUtils {
    //TODO: add sprint security authentication using OAuth2
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    public void setAuthManager(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//    }
//
//    public SecurityUtils() {
//    }
//
//    public String authenticateUser(HttpServletRequest req, String user, String password) {
//        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user, password);
//        authToken.setDetails(new WebAuthenticationDetails(req));
//        Authentication authentication = authenticationManager.authenticate(authToken);
//        SecurityContext sc = SecurityContextHolder.getContext();
//        sc.setAuthentication(authentication);
//        HttpSession session = req.getSession(true);
//        session.setAttribute(SPRING_SECURITY_CONTEXT_KEY, sc);
//        return authToken.toString();
//    }

}
