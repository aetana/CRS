package miu.edu.CourseRegistration1.service.impl;

import lombok.AllArgsConstructor;
import miu.edu.CourseRegistration1.entity.Student;
import miu.edu.CourseRegistration1.repository.StudentRepo;
import miu.edu.CourseRegistration1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    StudentRepo studentRepo;

    @Override
    public void createStudent(Student s) {
        studentRepo.save(s);
    }

    @Override
    public void updateStudent(Student s) {
        createStudent(s);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepo.deleteById(studentId);
    }

    @Override
    public Student findStudentByStudentId(Long studentId) {
        return studentRepo.findById(studentId).orElse(null);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepo.findAll();
    }

}