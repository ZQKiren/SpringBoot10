package com.cybersoft.springboot10.controller;

import com.cybersoft.springboot10.entity.Students;
import com.cybersoft.springboot10.request.InsertStudentRequest;
import com.cybersoft.springboot10.service.CourseService;
import com.cybersoft.springboot10.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<?> getAllStudents(){
        return ResponseEntity.ok(studentService.getAll());
    }

    @PostMapping
    public ResponseEntity<?> addStudents(@RequestBody InsertStudentRequest req){
        return ResponseEntity.ok(studentService.addStudent(req));
    }

    @PostMapping("/{id}/courses/{courseId}")
    public ResponseEntity<?> enrollCourse(@PathVariable int id, @PathVariable int courseId){
        try {
            Students student = courseService.enrollCourse(id, courseId);
            return ResponseEntity.ok("Đăng ký khóa học thành công cho sinh viên: " + student.getName());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<?> getStudentCourses(@PathVariable int id){
        try {
            return ResponseEntity.ok(courseService.getCoursesOfStudent(id));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
