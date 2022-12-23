package miu.edu.CourseRegistration1.repository;

import miu.edu.CourseRegistration1.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistrationRepo extends JpaRepository<Registration,Long> {
    List<Registration> findByStudentId(long id);
}
