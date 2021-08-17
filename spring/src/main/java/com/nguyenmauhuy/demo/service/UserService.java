package com.nguyenmauhuy.demo.service;


import com.nguyenmauhuy.demo.model.request.user.UserAuthRequest;
import com.nguyenmauhuy.demo.model.request.user.UserSaveRequest;
import com.nguyenmauhuy.demo.model.request.user.UserUpdateResquest;
import com.nguyenmauhuy.demo.model.response.user.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    void save(UserSaveRequest userSaveRequest);

    UserResponse auth(UserAuthRequest userAuthRequest);

    UserResponse findById(long id);

    Page<UserResponse> getAll(Pageable pageable);

    void updateUser(UserUpdateResquest userUpdateResquest);
}
