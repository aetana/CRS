package miu.edu.CourseRegistration1.repository;

import miu.edu.CourseRegistration1.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepo extends JpaRepository<Faculty, Long> {
}
