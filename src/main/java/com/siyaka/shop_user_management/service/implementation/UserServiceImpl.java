package com.siyaka.shop_user_management.service.implementation;

import com.siyaka.shop_user_management.model.dto.UserDto;
import com.siyaka.shop_user_management.model.entity.Users;
import com.siyaka.shop_user_management.repository.UsersRepository;
import com.siyaka.shop_user_management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UsersRepository usersRepository;
    private final AuthService authService;

    @Override
    public Users findUser(String email) {
        Optional<Users> usersOptional = usersRepository.findByEmail(email);
            return usersOptional.orElseThrow();
    }

    @Override
    public List<Users> findAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Page<Users> findAllUsers(Pageable pageable) {
        return usersRepository.findAll(pageable);
    }

    @Override
    public boolean updateUser(UserDto userDto) {
        Optional<Users> usersOptional = usersRepository.findByEmail(userDto.email());
        Users users = usersOptional.orElseThrow();
        users.setEmail(userDto.email());
        users.setRoles(userDto.roles());
        Users save = usersRepository.save(users);
        return save.getEmail() .equals(userDto.email());
    }

    @Override
    public boolean deleteUser(String email) {
        Optional<Users> usersOptional = usersRepository.findByEmail(email);
        usersOptional.ifPresent(usersRepository::delete);
        Optional<Users> usersByEmail = usersRepository.findByEmail(email);
        return usersByEmail.isEmpty();
    }

    @Override
    public void saveUser(Users users) {
        usersRepository.save(users);
    }

    @Override
    public boolean disableUser(String email) {
        Optional<Users> usersOptional = usersRepository.findByEmail(email);
        Users users = usersOptional.orElseThrow();
        users.setEnabled(false);
        usersRepository.save(users);
        //todo always returns true
        return true;
    }

    @Override
    public boolean enableUser(String email) {
        Optional<Users> usersOptional = usersRepository.findByEmail(email);
        Users users = usersOptional.orElseThrow();
        users.setEnabled(true);
        usersRepository.save(users);
        //todo always returns true
        return true;
    }

    @Override
    public boolean changePassword(String email, String newPassword) {
        Optional<Users> usersOptional = usersRepository.findByEmail(email);
        Users users = usersOptional.orElseThrow();
        usersRepository.save(authService.changePassword(users, newPassword));
        return true;
    }
}
