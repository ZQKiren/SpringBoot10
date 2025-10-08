package com.cybersoft.springboot10.service;

import com.cybersoft.springboot10.entity.Students;
import com.cybersoft.springboot10.request.InsertStudentRequest;

import java.util.List;

public interface StudentService {
    List<Students> getAll();

    String addStudent(InsertStudentRequest req);
}
