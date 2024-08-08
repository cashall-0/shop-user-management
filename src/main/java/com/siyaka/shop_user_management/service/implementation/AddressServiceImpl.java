package com.siyaka.shop_user_management.service.implementation;

import com.siyaka.shop_user_management.model.dto.AddressDto;
import com.siyaka.shop_user_management.service.AddressService;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    @Override
    public boolean createAddress(AddressDto addressDto, String email) {
        return false;
    }

    @Override
    public AddressDto findOneAddress(long addressId) {
        return null;
    }

    @Override
    public List<AddressDto> findAllUserAddress(long userInfoId) {
        return null;
    }

    @Override
    public boolean updateUserAddress(String email, AddressDto addressDto) {
        return false;
    }

    @Override
    public boolean deleteOneUserAddress(long addressId) {
        return false;
    }

    @Override
    public boolean deleteAllUserAddresses(long userInfoId) {
        return false;
    }
}
