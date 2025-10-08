package com.cybersoft.springboot10.repository;

import com.cybersoft.springboot10.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Courses, Integer> {
}
