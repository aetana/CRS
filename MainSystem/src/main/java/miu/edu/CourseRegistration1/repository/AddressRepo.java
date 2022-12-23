package miu.edu.CourseRegistration1.repository;

import miu.edu.CourseRegistration1.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,Long> {
}
