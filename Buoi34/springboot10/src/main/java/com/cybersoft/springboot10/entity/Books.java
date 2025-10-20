package com.cybersoft.springboot10.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "books")
@Table
@Data
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "book_title")
    private String title;

    @Column(name = "book_author")
    private String author;

    @Column(name = "book_price")
    private int price;
}
