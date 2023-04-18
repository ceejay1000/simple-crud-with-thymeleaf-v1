package com.cjvisions.Thymeleaf_demo;

import com.cjvisions.Thymeleaf_demo.entity.Student;
import com.cjvisions.Thymeleaf_demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ThymeleafDemoApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Student> students = new ArrayList<>();

		students.add(new Student("Lamal", "Jawal", "jawal@mail.com"));
		students.add(new Student("James", "Ortega", "james@mail.com"));
		students.add(new Student("Phineas", "Joe", "joe@mail.com"));
		students.add(new Student("Patience", "Pawa", "pawa@mail.com"));

		studentRepository.saveAll(students);
	}
}
