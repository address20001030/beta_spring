package com.nguyenmauhuy.demo.mapper.user;

import com.nguyenmauhuy.demo.entity.User;
import com.nguyenmauhuy.demo.mapper.Mapper;
import com.nguyenmauhuy.demo.model.response.user.UserResponse;

@org.mapstruct.Mapper(componentModel = "spring")
public interface UserResponseMapper extends Mapper<UserResponse, User> {
}
