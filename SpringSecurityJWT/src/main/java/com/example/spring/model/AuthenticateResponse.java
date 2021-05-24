package com.example.spring.model;

public class AuthenticateResponse {

    private final String jwtResponse;

    public String getJwtResponse() {
        return jwtResponse;
    }

    public AuthenticateResponse(String jwtResponse) {
        super();
        this.jwtResponse = jwtResponse;
    }


}
