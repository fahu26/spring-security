package com.example.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.model.AuthenticateRequest;
import com.example.spring.model.AuthenticateResponse;
import com.example.spring.service.MyUserDetailsService;
import com.example.spring.util.JwtUtil;

@RestController
public class HomeController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private MyUserDetailsService userDetails;

    @Autowired
    private JwtUtil jwtUtilService;

    @GetMapping("/home")
    public String getHomePage() {
        return "<h1>Welcome User</h1>";
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticateRequest request) throws Exception {
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (BadCredentialsException e) {
            // TODO: handle exception
            throw new Exception("Incorrect Userbane & Password");
        }
        final UserDetails details = userDetails.loadUserByUsername(request.getUsername());
        final String jwt = jwtUtilService.generateToken(details);
        return ResponseEntity.ok(new AuthenticateResponse(jwt));
    }
}
