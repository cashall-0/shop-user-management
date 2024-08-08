package com.siyaka.shop_user_management.service;

import com.siyaka.shop_user_management.model.dto.UserInfoDto;
import com.siyaka.shop_user_management.model.entity.UserInfo;

public interface UserInfoService {
    //todo add model mappers for easy dto to entity mapping
    //crud
    boolean createUserInfo(String email, UserInfoDto userInfoDto);
    boolean saveUserInfo(UserInfo userInfo);
    UserInfoDto getUserInfo(String email);
    UserInfoDto getUserInfo(long userInfoId);
    boolean updateUserInfo(String userName, UserInfoDto userInfoDto);
    boolean deleteUserInfo(String userName);

}
