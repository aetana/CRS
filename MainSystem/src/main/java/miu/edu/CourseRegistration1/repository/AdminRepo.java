package miu.edu.CourseRegistration1.repository;

import miu.edu.CourseRegistration1.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin, Long> {
}
