package hei.springboottd.controller;

import hei.springboottd.entity.Student;
import hei.springboottd.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

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
    public String getStudents(@RequestHeader("Accept") String acceptHeader ) {
        if(acceptHeader.toLowerCase().trim().contains("text/plain")) {
            return studentService.getStudents().toString();
        }else{
            return "format non supporté";

        }
    }
}
