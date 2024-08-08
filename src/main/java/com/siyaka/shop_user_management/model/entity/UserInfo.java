package com.siyaka.shop_user_management.model.entity;

import com.siyaka.shop_user_management.enums.Gender;
import com.siyaka.shop_user_management.model.MetaInfo;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@Data
public class UserInfo extends MetaInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String phone;
    private Gender gender;
    @OneToMany
    private List<Address> address;
}
