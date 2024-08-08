package com.siyaka.shop_user_management.model.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
