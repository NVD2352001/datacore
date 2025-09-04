package com.trucdulieu.authservice.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.trucdulieu.authservice.model.AuthRequest;
import com.trucdulieu.authservice.model.AuthResponse;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtService jwtService;

    public AuthResponse register(AuthRequest authRequest) {
        String accessToken = jwtService.generate(authRequest.getEmail(), "ACCESS");
        String refreshToken = jwtService.generate(authRequest.getEmail(), "REFRESH");

        return new AuthResponse(accessToken, refreshToken);
    }

    public Object infor(String token){
        token= token.replace("Bearer ", "");
        return jwtService.getAllClaimsFromToken(token);
    }
}
