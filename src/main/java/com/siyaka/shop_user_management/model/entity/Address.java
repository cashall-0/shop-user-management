package com.siyaka.shop_user_management.model.entity;

import com.siyaka.shop_user_management.model.MetaInfo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Address extends MetaInfo {
    @Id
    private Long id;

    private String streetAddress;
    private String houseNumber;
    private String streetName;
    private String city;
    private String stateOrProvince;
    private String postalOrZipCode;
    private String country;
    private String pOBoxNumber;
    private String landmark;
    private String latAndLong;
    private String timeZone;



}
