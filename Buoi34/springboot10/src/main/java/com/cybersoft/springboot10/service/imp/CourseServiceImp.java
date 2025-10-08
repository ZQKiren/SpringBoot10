package com.cybersoft.springboot10.service.imp;

import com.cybersoft.springboot10.entity.Courses;
import com.cybersoft.springboot10.entity.Students;
import com.cybersoft.springboot10.repository.CourseRepository;
import com.cybersoft.springboot10.repository.StudentRepository;
import com.cybersoft.springboot10.request.InsertCourseRequest;
import com.cybersoft.springboot10.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImp implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public String addCourse(InsertCourseRequest req){
        Courses courses = new Courses();
        courses.setTitle(req.getCourseTitle());

        courseRepository.save(courses);

        return "Thêm khóa học thành công! " + courses.getTitle();
    }

    @Override
    public Students enrollCourse(int studentId, int courseId) {
        Optional<Students> students = studentRepository.findById(studentId);
        Optional<Courses> courses = courseRepository.findById(courseId);
        
        if (students.isPresent() && courses.isPresent()) {
            Students student = students.get();
            Courses course = courses.get();
            
            if (student.getCourse() == null) {
                student.setCourse(new java.util.ArrayList<>());
            }
            
            if (!student.getCourse().contains(course)) {
                student.getCourse().add(course);
                studentRepository.save(student);
            }
            
            return student;
        }
        
        throw new RuntimeException("Không tìm thấy sinh viên hoặc khóa học!");
    }

    @Override
    public List<Courses> getCoursesOfStudent(int studentId) {
        Optional<Students> studentOpt = studentRepository.findById(studentId);
        
        if (studentOpt.isPresent()) {
            Students student = studentOpt.get();
            return student.getCourse() != null ? student.getCourse() : new java.util.ArrayList<>();
        }
        
        throw new RuntimeException("Không tìm thấy sinh viên!");
    }
}
