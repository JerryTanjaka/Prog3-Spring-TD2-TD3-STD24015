package hei.springboottd.service;

import hei.springboottd.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    public List<Student> studentList = new ArrayList<>();
    public List<String>  addStudent(List <Student> studentstoadd) {
        studentList.addAll(studentstoadd);
        return studentList.stream()
                .map(Student::getFirstName)
                .toList();
    }
}
