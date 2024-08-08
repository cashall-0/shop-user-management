package com.siyaka.shop_user_management.service.implementation;

import com.siyaka.shop_user_management.enums.Roles;
import com.siyaka.shop_user_management.model.dto.RegistrationReq;
import com.siyaka.shop_user_management.model.entity.Role;
import com.siyaka.shop_user_management.model.entity.Users;
import com.siyaka.shop_user_management.repository.RoleRepository;
import com.siyaka.shop_user_management.repository.UsersRepository;
import com.siyaka.shop_user_management.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UsersRepository usersRepository;

    private final JwtUtils jwtUtils;
    private final CustomUserDetailsService userDetailsService;
    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
    public String createToken(String email, String password) throws Exception {
        authenticate(email, password);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        return jwtUtils.generateToken(userDetails);
    }
    public boolean registerUser(RegistrationReq registrationReq, Roles uRole){
        Users users = new Users();
        users.setEmail(registrationReq.getEmail());
        if(usersRepository.findByEmail(registrationReq.getEmail()).isPresent())
            return false;
        users.setPassword(passwordEncoder.encode(registrationReq.getPassword()));
        users.setEnabled(true);
        // Retrieve the "ROLE_USER" role from the database
        Role userRole = roleRepository.findByName(registrationReq.getRoles()!=null? registrationReq.getRoles():uRole)
                .orElseThrow(() -> new RuntimeException(uRole.name() +" not found"));
        // Set the user's roles to a singleton set containing the "ROLE_USER" role
        users.setRoles(Collections.singleton(userRole));
        usersRepository.save(users);
        usersRepository.flush();
        return users.getId()!=null;
    }
    public Users changePassword(Users user, String newPassword){
        user.setPassword(passwordEncoder.encode(newPassword));
        return  user;
    }
}
