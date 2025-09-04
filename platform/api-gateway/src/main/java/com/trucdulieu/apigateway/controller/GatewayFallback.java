package com.trucdulieu.apigateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallbacks")
public class GatewayFallback {

    @GetMapping("/auth")
    public ResponseEntity<String> productFallback(){
        return new ResponseEntity<>("Something went wrong for this operation. Please try later...", HttpStatus.SERVICE_UNAVAILABLE);
    }
    @PostMapping("/auth")
    public ResponseEntity<String> authPostFallback(){
        return new ResponseEntity<>("Service Auth fail", HttpStatus.SERVICE_UNAVAILABLE);
    }
}
