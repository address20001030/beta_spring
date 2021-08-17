package com.nguyenmauhuy.demo.controller;

import com.nguyenmauhuy.demo.model.request.user.UserAuthRequest;
import com.nguyenmauhuy.demo.model.request.user.UserSaveRequest;
import com.nguyenmauhuy.demo.model.request.user.UserUpdateResquest;
import com.nguyenmauhuy.demo.model.response.user.UserResponse;
import com.nguyenmauhuy.demo.service.UserService;
import org.apache.catalina.User;
import org.apache.catalina.core.ApplicationContext;
import org.mapstruct.control.MappingControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(value = "/user")
    public ResponseEntity<Void> save(@RequestBody UserSaveRequest userSaveRequest){
        userService.save(userSaveRequest);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping("/user/auth")
    public ResponseEntity<UserResponse> auth(@RequestBody UserAuthRequest userAuthRequest){
        UserResponse userResponse = userService.auth(userAuthRequest);

        return new ResponseEntity<>(userResponse,HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable long id){
        UserResponse userResponse = userService. findById(id);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<Page<UserResponse>> getAll(@RequestParam int index, @RequestParam int size){
        PageRequest pageRequest = PageRequest.of(index,size);
        Page<UserResponse> userResponses = userService.getAll(pageRequest);

        return ResponseEntity.ok(userResponses);
    }

    @PutMapping("/user/update/{id}")
    public ResponseEntity<Void> update(@RequestBody UserUpdateResquest userUpdateResquest){
        userService.updateUser(userUpdateResquest);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
