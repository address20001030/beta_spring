package com.nguyenmauhuy.demo.service.impl;

import com.nguyenmauhuy.demo.entity.Role;
import com.nguyenmauhuy.demo.entity.User;
import com.nguyenmauhuy.demo.exception.ObjectNotFoundException;
import com.nguyenmauhuy.demo.mapper.user.UserResponseMapper;
import com.nguyenmauhuy.demo.mapper.user.UserSaveMapper;
import com.nguyenmauhuy.demo.model.request.user.UserAuthRequest;
import com.nguyenmauhuy.demo.model.request.user.UserSaveRequest;
import com.nguyenmauhuy.demo.model.request.user.UserUpdateResquest;
import com.nguyenmauhuy.demo.model.response.user.UserResponse;
import com.nguyenmauhuy.demo.repository.RoleRepository;
import com.nguyenmauhuy.demo.repository.UserRepository;
import com.nguyenmauhuy.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final UserSaveMapper userSaveMapper;
    private final UserResponseMapper userResponseMapper;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserSaveMapper userSaveMapper, UserResponseMapper userResponseMapper, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userSaveMapper = userSaveMapper;
        this.userResponseMapper = userResponseMapper;
        this.roleRepository = roleRepository;
    }

    @Override
    public void save(UserSaveRequest userSaveRequest) {
        User user = userSaveMapper.to(userSaveRequest);
        Set<Role> roles = new HashSet<>(roleRepository.findAllByIdIn(userSaveRequest.getRoleIds()));
        user.setRoles(roles);
        userRepository.save(user);
    }

    @Override
    public UserResponse auth(UserAuthRequest userAuthRequest) {
        User user = userRepository.findByUserNameAndPassword(userAuthRequest.getUserName(), userAuthRequest.getPassword());
        return userResponseMapper.to(user);
    }

    @Override
    public UserResponse findById(long id) {
        Optional<User> user = userRepository.findById(id);

        user.orElseThrow(()-> new ObjectNotFoundException("User not found"));

        return userResponseMapper.to(user.get());
    }

    @Override
    public Page<UserResponse> getAll(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable.previousOrFirst());


        return users.map(userResponseMapper::to);
    }

    @Override
    public void updateUser(UserUpdateResquest userUpdateResquest) {
        User user = userRepository.findById(userUpdateResquest.getId()).orElseThrow(()->new ObjectNotFoundException("User not found"));
        user.setName(userUpdateResquest.getName());
        user.setAddress(userUpdateResquest.getAddress());
        user.setPassword(userUpdateResquest.getPassword());
        user.setUserName(userUpdateResquest.getUserName());
        user.setPhone(userUpdateResquest.getPhone());
        user.setEmail(userUpdateResquest.getEmail());

        userRepository.save(user);
    }
}
