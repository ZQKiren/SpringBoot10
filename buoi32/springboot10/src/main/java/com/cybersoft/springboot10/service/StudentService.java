package com.cybersoft.springboot10.service;

import com.cybersoft.springboot10.entity.Products;
import com.cybersoft.springboot10.entity.Students;
import com.cybersoft.springboot10.repository.StudentRepository;
import com.cybersoft.springboot10.request.InsertStudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String addStudent(InsertStudentRequest req){
        Students students = new Students();
        students.setName(req.getStudentName());
        students.setAge(req.getStudentAge());
        students.setGender(req.getStudentGender());

        studentRepository.save(students);

        return "Thêm học sinh thành công!";
    }

    public Optional<Students> detailStudent(int id){
        return studentRepository.findById(id);
    }
}
