package miu.edu.CourseRegistration1.repository;

import miu.edu.CourseRegistration1.entity.RegistrationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRequestRepo extends JpaRepository<RegistrationRequest, Long> {
}
