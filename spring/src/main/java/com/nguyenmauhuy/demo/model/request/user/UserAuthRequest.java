package com.nguyenmauhuy.demo.model.request.user;

import lombok.Data;

@Data
public class UserAuthRequest {
    private String userName;
    private String password;
}
