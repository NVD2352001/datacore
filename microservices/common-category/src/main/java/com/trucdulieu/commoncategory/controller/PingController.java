package com.trucdulieu.commoncategory.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trucdulieu.commoncategory.config.UserContextHolder;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products/ping")
@RequiredArgsConstructor
public class PingController {
    @GetMapping
    public String getHello(){
        return UserContextHolder.getUserContext().getUserName();
    }
}
