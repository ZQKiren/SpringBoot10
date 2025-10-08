package com.cybersoft.springboot10.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_price")
    private int price;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "category_id")
    private Categories category;
}
