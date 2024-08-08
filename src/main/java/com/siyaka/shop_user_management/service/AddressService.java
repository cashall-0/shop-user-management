package com.siyaka.shop_user_management.service;

import com.siyaka.shop_user_management.model.dto.AddressDto;

import java.util.List;

public interface AddressService {
    //crud
    boolean createAddress(AddressDto addressDto, String email);
    AddressDto findOneAddress(long addressId);
    List<AddressDto> findAllUserAddress(long userInfoId);
    boolean updateUserAddress(String email, AddressDto addressDto);
    boolean deleteOneUserAddress(long addressId);
    boolean deleteAllUserAddresses(long userInfoId);
}
