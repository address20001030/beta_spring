package com.nguyenmauhuy.demo.mapper.user;

import com.nguyenmauhuy.demo.entity.User;
import com.nguyenmauhuy.demo.mapper.Mapper;
import com.nguyenmauhuy.demo.model.request.user.UserSaveRequest;

@org.mapstruct.Mapper(componentModel = "spring")
public interface UserSaveMapper extends Mapper<User, UserSaveRequest> {
}
