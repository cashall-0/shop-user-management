package com.siyaka.shop_user_management.exceptions;

public class UsersNotFoundException extends  RuntimeException{
    public UsersNotFoundException(String message) {
        super(message);
    }

}
