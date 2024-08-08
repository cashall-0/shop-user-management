package com.siyaka.shop_user_management.model.dto;


import com.siyaka.shop_user_management.model.entity.Role;

import java.util.Set;

public record UserDto (String email, String password, Set<Role> roles) {
}
