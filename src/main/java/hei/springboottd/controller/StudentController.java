package hei.springboottd.controller;

import hei.springboottd.entity.Student;
import hei.springboottd.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping("/students")
    public ResponseEntity<?> addStudents(@RequestBody List<Student> students) {
        try {
            List<Student> allStudents = studentService.addStudent(students);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(allStudents);

        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }
    @GetMapping("/students")
    public ResponseEntity<?> getStudents(@RequestHeader(value = "Accept", required = false) String accept) {

        if (accept == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Accept header is required");
        }
        try {
            if (accept.equals("text/plain")) {
                String names = studentService.getStudentNames();
                return ResponseEntity.ok(names);
            } else if (accept.equals("application/json")) {
                return ResponseEntity.ok(studentService.getStudents());
            } else {
                return ResponseEntity
                        .status(HttpStatus.NOT_IMPLEMENTED)
                        .body("Format not supported");
            }
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Server error");
        }
    }
}
