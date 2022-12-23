package miu.edu.CourseRegistration1.repository;

import miu.edu.CourseRegistration1.entity.RegistrationEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RegistrationEventRepo extends JpaRepository<RegistrationEvent,Long> {

    @Query(nativeQuery = true,
            value = "select * from ( select m.*, row_number() over ( order by id desc) as rn from registration_event m ) m2 where m2.rn = 1")
    RegistrationEvent findLatestEvent();

}
