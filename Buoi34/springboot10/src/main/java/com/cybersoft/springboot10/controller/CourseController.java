package com.cybersoft.springboot10.controller;

import com.cybersoft.springboot10.request.InsertCourseRequest;
import com.cybersoft.springboot10.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody InsertCourseRequest req){
        return ResponseEntity.ok(courseService.addCourse(req));
    }
}
