package com.siyaka.shop_user_management.service.implementation;

import com.siyaka.shop_user_management.exceptions.UsersNotFoundException;
import com.siyaka.shop_user_management.model.entity.Users;
import com.siyaka.shop_user_management.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //get user details
        Users users = usersRepository.findByEmail(email)
                .orElseThrow(() -> new UsersNotFoundException("User with email " + email + " not found"));

        //get roles and set the authorities for authorization
        Set<SimpleGrantedAuthority> authorities = users.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toSet());
        //return an instance userDetails entity from the security core
        return new org.springframework.security.core.userdetails.User(users.getEmail(), users.getPassword(), authorities);
    }
}
