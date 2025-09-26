package com.cybersoft.springboot10.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "students")
@Data
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "student_name")
    private String name;

    @Column(name = "student_age")
    private int age;

    @Column(name = "student_gender")
    private String gender;
}
