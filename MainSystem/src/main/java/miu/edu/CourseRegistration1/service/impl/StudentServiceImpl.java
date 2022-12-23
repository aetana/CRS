package miu.edu.CourseRegistration1.service.impl;

import lombok.AllArgsConstructor;
import miu.edu.CourseRegistration1.entity.Student;
import miu.edu.CourseRegistration1.repository.StudentRepo;
import miu.edu.CourseRegistration1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public void createStudent(Student s) {
        studentRepo.save(s);
    }

    public void addAll(List<Student> students){
        studentRepo.saveAll(students);
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
        System.out.println(studentRepo.findStudentByStudentID(studentId));
        return studentRepo.findStudentByStudentID(studentId);
    }

    @Override
    public Student findStudentByUserId(Long userId) {
        return studentRepo.findStudentByUserId(userId);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepo.findAll();
    }

}