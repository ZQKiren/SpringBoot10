package com.cybersoft.springboot10.service;

import com.cybersoft.springboot10.entity.Courses;
import com.cybersoft.springboot10.entity.Students;
import com.cybersoft.springboot10.request.InsertCourseRequest;

import java.util.List;

public interface CourseService {
    String addCourse(InsertCourseRequest req);

    Students enrollCourse(int studentId, int courseId);

    List<Courses> getCoursesOfStudent(int studentId);
}
