package miu.edu.CourseRegistration1.repository;

import miu.edu.CourseRegistration1.entity.CourseOffering;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseOfferingRepo extends JpaRepository<CourseOffering,Long> {
}
