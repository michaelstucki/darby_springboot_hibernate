package com.michaelstucki.springbootRestControllerDemo.rest;

import com.michaelstucki.springbootRestControllerDemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("A", "X"));
        students.add(new Student("B", "Y"));
        students.add(new Student("C", "Z"));
        return students;
    }
}
