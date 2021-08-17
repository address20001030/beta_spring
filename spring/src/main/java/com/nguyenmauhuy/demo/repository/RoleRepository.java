package com.nguyenmauhuy.demo.repository;

import com.nguyenmauhuy.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Long> {
    List<Role> findAllByIdIn(List<Long> ids);
}
