package com.cybersoft.springboot10.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "courses")
@Table
@Data
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "course_title")
    private String title;

    @ManyToMany(mappedBy = "course")
    private List<Students> student;
}
