package com.siyaka.shop_user_management.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HttpResponseData<T>{
    private T responseData;
    private int statusCode;


}
