package hei.springboottd.service;

import hei.springboottd.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    public List<Student> studentList = new ArrayList<>();
    public List<Student>  addStudent(List <Student> studentstoadd) {
        studentList.addAll(studentstoadd);
        return studentList;
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
