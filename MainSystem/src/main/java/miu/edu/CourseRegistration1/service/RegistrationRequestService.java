package miu.edu.CourseRegistration1.service;

import miu.edu.CourseRegistration1.entity.Student;
import miu.edu.CourseRegistration1.model.RegistrationRequestModelList;

public interface RegistrationRequestService {
    void createRegistrationRequest(RegistrationRequestModelList registrationRequestObject, Student studentId) throws Exception;

}
