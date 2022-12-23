package miu.edu.CourseRegistration1.controller;

import lombok.AllArgsConstructor;
import miu.edu.CourseRegistration1.entity.CourseOffering;
import miu.edu.CourseRegistration1.entity.RegistrationEvent;
import miu.edu.CourseRegistration1.entity.RegistrationRequest;
import miu.edu.CourseRegistration1.entity.Student;
import miu.edu.CourseRegistration1.model.CourseRequest;
import miu.edu.CourseRegistration1.model.RegistrationRequestObject;
import miu.edu.CourseRegistration1.security.AwesomeUserDetails;
import miu.edu.CourseRegistration1.service.CourseOfferingService;
import miu.edu.CourseRegistration1.service.RegistrationEventService;
import miu.edu.CourseRegistration1.service.RegistrationRequestService;
import miu.edu.CourseRegistration1.service.StudentService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/registration-requests")
public class RegistrationRequestController {
    RegistrationRequestService registrationRequestService;
    RegistrationEventService registrationEventService;
    StudentService studentService;
    CourseOfferingService courseOfferingService;

    @PostMapping("")
    public String createRegistrationRequest(@RequestBody RegistrationRequestObject requestObject){
        RegistrationRequest registrationRequest1 = new RegistrationRequest();
        List<CourseOffering> courseOfferingList = courseOfferingService.findAllCourseOffering();
        //find student by id
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AwesomeUserDetails loggedInUser = (AwesomeUserDetails) auth.getPrincipal();
        Student student = studentService.findStudentByStudentId(loggedInUser.getId());

        RegistrationEvent event = registrationEventService.findById(requestObject.getCourses()
                .get(0).getReg_event_id());

        LocalDate today = LocalDate.now();
        LocalDate eventDate = event.getEndDate().toLocalDate();
        int check = today.compareTo(eventDate);

        requestObject.getCourses().forEach(courseRequest -> {
            if(check > 0 ){
                registrationRequest1.setPriority(courseRequest.getPriority());
                //adding registration request to registration db table
                RegistrationRequest userAddedRequest = registrationRequestService.createRegistrationRequest(registrationRequest1);

                //adding registration request to student List
                student.getRegistrationRequestList().add(userAddedRequest);
                studentService.updateStudent(student);

                //adding request to course offering list
                courseOfferingList.forEach(courseOffering -> {
                  boolean correctCourseOffer = courseOffering.getCourse().getCode().equals(courseRequest.getCourse_code());
                  if(correctCourseOffer){
                      courseOffering.getRegistrationRequestList().add(userAddedRequest);
                      courseOfferingService.updateCourseOffering(courseOffering);
                      }
                });
            }
        });
        return "successfully created a registration request";
    }
}
