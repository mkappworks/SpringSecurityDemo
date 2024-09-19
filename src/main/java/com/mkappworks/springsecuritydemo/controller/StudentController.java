package com.mkappworks.springsecuritydemo.controller;

import com.mkappworks.springsecuritydemo.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    private final List<Student> students;

    public StudentController() {
        students = new ArrayList<>(
                List.of(
                        new Student(1, "Malith", 100),
                        new Student(2, "Mark", 90),
                        new Student(3, "John", 80)
                )
        );
    }


    @GetMapping
    public List<Student> getStudents() {
        return students;
    }

//    @GetMapping("csrf-token")
//    public CsrfToken getCsrfToken(HttpServletRequest request) {
//        return (CsrfToken) request.getAttribute(CsrfToken.class.getName());
//    }

    @PostMapping
    public String addStudent(@RequestBody Student student) {
        students.add(student);
        return "student added successfully" + student;
    }
}
