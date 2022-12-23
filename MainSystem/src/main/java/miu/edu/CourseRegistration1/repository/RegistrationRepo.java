package miu.edu.CourseRegistration1.repository;

import miu.edu.CourseRegistration1.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepo extends JpaRepository<Registration,Long> {
}
