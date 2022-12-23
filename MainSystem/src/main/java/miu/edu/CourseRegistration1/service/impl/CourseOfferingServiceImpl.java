package miu.edu.CourseRegistration1.service.impl;

import lombok.AllArgsConstructor;
import miu.edu.CourseRegistration1.entity.CourseOffering;
import miu.edu.CourseRegistration1.repository.CourseOfferingRepo;
import miu.edu.CourseRegistration1.service.CourseOfferingService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
@Transactional
public class CourseOfferingServiceImpl implements CourseOfferingService {
    CourseOfferingRepo courseOfferingRepo;

    @Override
    public CourseOffering updateCourseOffering(CourseOffering c) {
        return courseOfferingRepo.save(c);
    }

    @Override
    public List<CourseOffering> findAllCourseOffering() {
        return courseOfferingRepo.findAll();
    }

    public void save(CourseOffering courseOffering){
        courseOfferingRepo.save(courseOffering);
    }

    public void saveAll(List<CourseOffering> courseOfferings){
        courseOfferingRepo.saveAll(courseOfferings);
    }
}
