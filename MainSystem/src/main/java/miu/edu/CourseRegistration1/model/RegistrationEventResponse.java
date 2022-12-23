package miu.edu.CourseRegistration1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import miu.edu.CourseRegistration1.entity.RegistrationEvent;

@Data
@AllArgsConstructor
public class RegistrationEventResponse {
    private RegistrationEvent registrationEvent;
    private String message;
}
