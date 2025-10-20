package com.cybersoft.springboot10.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "categories")
@Table
@Data
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "category_name")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Products> products;
}
