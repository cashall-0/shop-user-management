package com.siyaka.shop_user_management.controller;

import com.siyaka.shop_user_management.enums.Roles;
import com.siyaka.shop_user_management.model.dto.AuthRequest;
import com.siyaka.shop_user_management.model.dto.AuthResponse;
import com.siyaka.shop_user_management.model.dto.RegistrationReq;
import com.siyaka.shop_user_management.service.implementation.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authRequest) throws Exception {
        final String token = authService.createToken(authRequest.getEmail(), authRequest.getPassword());
        return ResponseEntity.ok(new AuthResponse(token));
    }
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationReq req) {
        if(authService.registerUser(req, Roles.ROLE_USER))
            return ResponseEntity.ok("User registered successfully");
        else
            return ResponseEntity.ok("User registration Unsuccessful");
    }
}
