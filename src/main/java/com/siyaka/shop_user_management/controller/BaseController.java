package com.siyaka.shop_user_management.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    @GetMapping("/")
    public ResponseEntity<?> testHomepage(){
        return ResponseEntity.ok("This is my beautiful homepage");
    }
}
