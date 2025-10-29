package com.cybersoft.bai2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true, length=50)
    private String username;

    @Column(nullable=false, unique=true, length=100)
    private String email;

    @Column(nullable=false, length=255)
    private String password;

    @Column(nullable=false)
    private Boolean enabled = true;
}

