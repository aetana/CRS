package miu.edu.CourseRegistration1.service;

import miu.edu.CourseRegistration1.entity.CourseOffering;

import java.util.List;

public interface CourseOfferingService {
    CourseOffering updateCourseOffering(CourseOffering c);

    List<CourseOffering> findAllCourseOffering();
}
