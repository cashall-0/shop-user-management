package com.siyaka.shop_user_management.model.dto;

import com.siyaka.shop_user_management.enums.Gender;
import com.siyaka.shop_user_management.model.entity.Address;
import com.siyaka.shop_user_management.model.entity.UserInfo;

import java.util.List;

public record UserInfoDto(String phone,Gender gender, List<Address>address) {

}
