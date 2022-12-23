package miu.edu.CourseRegistration1.service.impl;

import lombok.AllArgsConstructor;
import miu.edu.CourseRegistration1.entity.RegistrationRequest;
import miu.edu.CourseRegistration1.repository.RegistrationRequestRepo;
import miu.edu.CourseRegistration1.service.RegistrationRequestService;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RegistrationRequestServiceImpl implements RegistrationRequestService {
    RegistrationRequestRepo registrationRequestRepo;
    @Override
    public RegistrationRequest createRegistrationRequest(RegistrationRequest r) {
       return registrationRequestRepo.save(r);
    }
}
