package com.nguyenmauhuy.demo.model.request.user;

import lombok.Data;

import java.util.List;

@Data
public class UserSaveRequest {
    private String userName;
    private String password;
    private String address;
    private String email;
    private String phone;
    private String name;

    private List<Long> roleIds;
}
