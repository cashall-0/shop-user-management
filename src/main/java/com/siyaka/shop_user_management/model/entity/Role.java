package com.siyaka.shop_user_management.model.entity;

import com.siyaka.shop_user_management.enums.Roles;
import com.siyaka.shop_user_management.repository.RoleRepository;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private Roles name;

    @ManyToMany(mappedBy = "roles")
    private Set<Users> users;
}


