package com.cjvisions.Thymeleaf_demo.controller;

import com.cjvisions.Thymeleaf_demo.entity.Student;
import com.cjvisions.Thymeleaf_demo.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class StudentController {

    private final StudentService service;


    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/students")
    public String listStudents(HttpServletRequest httpServletRequest, Model model){
//        var flashMap = RequestContextUtils.getInputFlashMap(httpServletRequest);
//
//        if (flashMap != null){
//            var savedStudent = (Student) flashMap.get("student");
//
//        }
        model.addAttribute("students", service.getAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudent(Model model){
        Student student = new Student();

        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/students")
    public RedirectView saveStudent(@ModelAttribute("student") Student student, RedirectAttributes redirectAttributes){
        var savedStudent = service.saveStudent(student);

        redirectAttributes.addFlashAttribute("student", savedStudent);
        var msg = "";
        if (savedStudent != null){
            msg = "Student saved successfully";
        }

        System.out.println(msg);
        return new RedirectView("/students", true);
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model){
        model.addAttribute("student", service.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model){

        Student existingStudent = service.getStudentById(id);
        existingStudent.setId(student.getId());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());

        service.updateStudent(existingStudent);
        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id){

        service.deleteStudentById(id);
        return "redirect:/students";
    }

}
