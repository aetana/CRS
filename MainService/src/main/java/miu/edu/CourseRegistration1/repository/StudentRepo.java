package miu.edu.CourseRegistration1.repository;

import miu.edu.CourseRegistration1.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long>{
    Student findStudentByStudentID(Long studentId);
    void deleteStudentByStudentID(Long studentId);
}