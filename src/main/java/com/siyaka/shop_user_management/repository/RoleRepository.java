package com.siyaka.shop_user_management.repository;

import com.siyaka.shop_user_management.enums.Roles;
import com.siyaka.shop_user_management.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(Roles role);
}
