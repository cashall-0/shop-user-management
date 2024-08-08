package com.siyaka.shop_user_management.model.dto;

public record AddressDto(Long id, String streetAddress, String houseNumber, String streetName, String city, String stateOrProvince,
                         String postalOrZipCode, String country, String pOBoxNumber, String landmark, String latAndLong, String timeZone) {
}