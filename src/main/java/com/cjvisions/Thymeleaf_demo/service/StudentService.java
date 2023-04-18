package com.cjvisions.Thymeleaf_demo.service;

import com.cjvisions.Thymeleaf_demo.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student updateStudent(Student student);

    Student getStudentById(Long id);

    void deleteStudentById(Long id);
}
