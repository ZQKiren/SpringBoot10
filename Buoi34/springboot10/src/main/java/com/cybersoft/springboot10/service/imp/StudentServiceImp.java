package com.cybersoft.springboot10.service.imp;

import com.cybersoft.springboot10.entity.Students;
import com.cybersoft.springboot10.repository.StudentRepository;
import com.cybersoft.springboot10.request.InsertStudentRequest;
import com.cybersoft.springboot10.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Students> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public String addStudent(InsertStudentRequest req){

        Students students = new Students();
        students.setName(req.getStudentName());
        students.setEmail(req.getStudentEmail());

        studentRepository.save(students);

        return "Thêm sinh viên thành công! "+ students.getName();
    }
}
