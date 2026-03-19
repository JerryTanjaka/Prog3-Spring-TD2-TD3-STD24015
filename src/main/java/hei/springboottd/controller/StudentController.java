package hei.springboottd.controller;

import hei.springboottd.entity.Student;
import hei.springboottd.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping("/students")
    public List<Student> createStudent(@RequestBody List<Student> newStudents) {
        return studentService.addStudent(newStudents);
    }
    @GetMapping("/students")
    public List<String> getStudents() {
        return studentService.getStudents();
    }
}
