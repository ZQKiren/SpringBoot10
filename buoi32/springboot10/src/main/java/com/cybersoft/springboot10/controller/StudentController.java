package com.cybersoft.springboot10.controller;

import com.cybersoft.springboot10.request.InsertStudentRequest;
import com.cybersoft.springboot10.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody InsertStudentRequest req){
        return ResponseEntity.ok(studentService.addStudent(req));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detailStudent(@PathVariable int id){
        return ResponseEntity.of(studentService.detailStudent(id));
    }
}
