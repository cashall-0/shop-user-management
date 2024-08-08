package com.siyaka.shop_user_management.repository;

import com.siyaka.shop_user_management.enums.Roles;
import com.siyaka.shop_user_management.model.entity.Role;
import com.siyaka.shop_user_management.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
@Order
public class DataInitializer {

    @Autowired
    private RoleRepository roleRepository;

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            // Check if roles already exist
            List<Role> all = roleRepository.findAll();
            if (all.isEmpty()) {
                Role roleAdmin = new Role();
                Role roleUser = new Role();
                roleAdmin.setName(Roles.ROLE_ADMIN);
                roleUser.setName(Roles.ROLE_USER);

                roleRepository.save(roleAdmin);
                roleRepository.save(roleUser);
            }else
                System.out.println("Roles already initialised");
        };
    }
}
