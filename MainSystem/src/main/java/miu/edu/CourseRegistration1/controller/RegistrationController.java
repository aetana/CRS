package miu.edu.CourseRegistration1.controller;

import lombok.AllArgsConstructor;
import miu.edu.CourseRegistration1.entity.Registration;
import miu.edu.CourseRegistration1.service.RegistrationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/registrations")
public class RegistrationController {
    RegistrationService registrationService;

    @GetMapping("")
    public List<Registration> getAllRegistrations(){
        return registrationService.getAllRegistrations();
    }


}
