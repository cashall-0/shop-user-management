package com.siyaka.shop_user_management.service;

import com.siyaka.shop_user_management.model.dto.UserDto;
import com.siyaka.shop_user_management.model.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    //crud
    Users findUser(String email);
    List<Users> findAllUsers();
    Page<Users> findAllUsers(Pageable pageable);
    boolean updateUser(UserDto userDto);
    boolean deleteUser(String email);
    void saveUser(Users users);
    boolean disableUser(String email);
    boolean enableUser(String email);
    boolean changePassword(String email, String newPassword);
}
