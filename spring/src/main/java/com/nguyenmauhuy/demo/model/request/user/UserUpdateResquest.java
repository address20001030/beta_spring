package com.nguyenmauhuy.demo.model.request.user;

import lombok.Data;

@Data
public class UserUpdateResquest {
    private long id;
    private String userName;
    private String password;
    private String address;
    private String email;
    private String phone;
    private String name;

}
