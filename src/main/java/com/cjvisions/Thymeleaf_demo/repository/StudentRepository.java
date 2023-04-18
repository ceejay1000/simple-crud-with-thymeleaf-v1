package com.cjvisions.Thymeleaf_demo.repository;

import com.cjvisions.Thymeleaf_demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> { }
