package com.nguyenmauhuy.demo.repository;

import com.nguyenmauhuy.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserNameAndPassword(String userName, String password);

}
