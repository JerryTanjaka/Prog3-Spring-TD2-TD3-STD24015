package hei.springboottd.service;

import hei.springboottd.entity.Student;
import hei.springboottd.validator.StudentValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentValidator studentValidator;
    public StudentService(StudentValidator studentValidator) {
        this.studentValidator = studentValidator;
    }
    public List<Student> studentList = new ArrayList<>();
    public List<Student>  addStudent(List <Student> studentstoadd) {
        try {
            studentValidator.isStudentsListvalid(studentstoadd);
            studentList.addAll(studentstoadd);
            return studentList;
        } catch (RuntimeException e) {
            throw new RuntimeException("Failed to add students: " + e.getMessage());
        }
    }
    public List<Student> getStudents() {
        return studentList;
    }
    public String getStudentNames() {
        return studentList.stream()
                .map(Student::getFirstName)
                .collect(Collectors.joining(", "));
    }
}
