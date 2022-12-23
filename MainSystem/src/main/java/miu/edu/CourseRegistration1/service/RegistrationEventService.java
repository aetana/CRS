package miu.edu.CourseRegistration1.service;

import miu.edu.CourseRegistration1.entity.RegistrationEvent;
import miu.edu.CourseRegistration1.model.RegistrationEventModel;

import java.util.List;

public interface RegistrationEventService {
    public RegistrationEvent getLatestRegistrationEvent(long studentId);
    public void addAll(List<RegistrationEvent> registrationEvents);

    public void createRegistrationEvent(RegistrationEvent registrationEvent);

    List<RegistrationEvent> findAll();

    RegistrationEvent findById(Long id);

    //List<RegistrationEvent> findByStudentId(Long id);
}
