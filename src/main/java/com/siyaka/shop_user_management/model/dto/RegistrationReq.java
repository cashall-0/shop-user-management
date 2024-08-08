package com.siyaka.shop_user_management.model.dto;

import com.siyaka.shop_user_management.enums.Roles;
import lombok.Data;

@Data
public class RegistrationReq {
    private String email;
    private String password;
    private Roles roles;
}
