package com.nguyenmauhuy.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, columnDefinition = "nvarchar(100)")
    private String userName;
    @Column(columnDefinition = "nvarchar(100)")
    private String name;
    private String password;
    @Column
    private String phone;
    @Column
    private String email;
    @Column
    private String address;
    @Column
    private LocalDate createDate;
    @Column
    private String createBy;
    @Column
    private LocalDate modifiedDate;
    @Column
    private String modifiedBy;

    @ManyToMany
    @JoinTable(name = "permission",
            joinColumns = @JoinColumn(name = "user_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "role_id",nullable = false))
    private Set<Role> roles = new HashSet<>();
}
