package com.siyaka.shop_user_management.service.implementation;

import com.siyaka.shop_user_management.model.dto.UserInfoDto;
import com.siyaka.shop_user_management.model.entity.UserInfo;
import com.siyaka.shop_user_management.model.entity.Users;
import com.siyaka.shop_user_management.service.UserInfoService;
import com.siyaka.shop_user_management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {
    private final UserService userService;
    @Override
    public boolean createUserInfo(String email, UserInfoDto userInfoDto) {
        Users user = userService.findUser(email);
        UserInfo userInfo = new UserInfo();
        userInfo.setGender(userInfoDto.gender());
        userInfo.setPhone(userInfo.getPhone());
        user.setUserInfo(userInfo);
        userService.saveUser(user);
        return user.getUserInfo()!= null;
    }

    @Override
    public boolean saveUserInfo(UserInfo userInfo) {
        return false;
    }

    @Override
    public UserInfoDto getUserInfo(String email) {
        Users user = userService.findUser(email);
        return new UserInfoDto(user.getUserInfo().getPhone(), user.getUserInfo().getGender(), user.getUserInfo().getAddress());
    }

    @Override
    public UserInfoDto getUserInfo(long userInfoId) {
        return null;
    }

    @Override
    public boolean updateUserInfo(String userName, UserInfoDto userInfoDto) {
        Users user = userService.findUser(userName);
        user.getUserInfo().setPhone(userInfoDto.phone());
        user.getUserInfo().setGender(userInfoDto.gender());
        user.getUserInfo().setAddress(userInfoDto.address());
        userService.saveUser(user);//todo always returns true
        return true;
    }

    @Override
    public boolean deleteUserInfo(String userName) {
        return false;
    }
}
