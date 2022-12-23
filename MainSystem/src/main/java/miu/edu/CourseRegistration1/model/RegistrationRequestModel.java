package miu.edu.CourseRegistration1.model;

import lombok.Data;
import miu.edu.CourseRegistration1.entity.RegistrationRequest;

import java.util.List;

@Data
public class RegistrationRequestModel {
    RegistrationRequest registrationRequest;
    String courseOfferingCode;

}
