package com.cybersoft.springboot10.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Year;

@Entity(name = "books")
@Data
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "book_title")
    private String title;

    @Column(name = "book_author")
    private String author;

    @Column(name = "book_year")
    private Year year;
}
