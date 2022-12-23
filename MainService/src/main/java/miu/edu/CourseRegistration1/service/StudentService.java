package miu.edu.CourseRegistration1.service;

import miu.edu.CourseRegistration1.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentService {
    void createStudent(Student s);
    void updateStudent(Student s);
    void deleteStudentById(Long studentId);
    Student findStudentByStudentId(Long id);
    List<Student> findAllStudents();
}