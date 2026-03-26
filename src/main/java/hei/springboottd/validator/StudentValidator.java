package hei.springboottd.validator;
import hei.springboottd.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentValidator {
    public void isStudentFieldvalid(Student student){
        if(student.getReference() == null){
            throw new RuntimeException("reference field is not valid "+student.getFirstName()+student.getLastName());
        }
        if (student.getFirstName()== null){
            throw new RuntimeException("firstName field is not valid "+student.getReference());
        }
        if (student.getLastName()== null){
            throw new RuntimeException("lastName field is not valid "+student.getReference());
        }
        if (student.getAge() <= 0){
            throw new RuntimeException("age field is not valid "+student.getReference());
        }
    }
public void isStudentsListvalid(List<Student> students){
        if(students == null || students.isEmpty()){
            throw new RuntimeException("students list is empty");
        }
        for (Student student : students) {
            isStudentFieldvalid(student);
        }
    }
}
