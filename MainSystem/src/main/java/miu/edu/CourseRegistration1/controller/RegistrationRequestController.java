package miu.edu.CourseRegistration1.controller;

import lombok.AllArgsConstructor;
import miu.edu.CourseRegistration1.entity.Role;
import miu.edu.CourseRegistration1.entity.Student;
import miu.edu.CourseRegistration1.model.RegistrationRequestModelList;
import miu.edu.CourseRegistration1.security.AwesomeUserDetails;
import miu.edu.CourseRegistration1.service.RegistrationRequestService;
import miu.edu.CourseRegistration1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/registration-requests")
public class RegistrationRequestController {
    @Autowired
    RegistrationRequestService registrationRequestService;
    @Autowired
    private StudentService studentService;
//    @Autowired
//    RegistrationEventService registrationEventService;
//    @Autowired
//    StudentService studentService;
//    @Autowired
//    CourseOfferingService courseOfferingService;

    @PostMapping
    public ResponseEntity<?> saveRequest(@RequestBody RegistrationRequestModelList registrationRequestModels){
        System.out.println("post");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AwesomeUserDetails loggedInUser = (AwesomeUserDetails) auth.getPrincipal();
        if(loggedInUser.getRole() != Role.STUDENT)
            return ResponseEntity.badRequest().body("Do not Apply to Admin/Faculty!");
        Student student = studentService.findStudentByUserId(loggedInUser.getId());
        try{
            registrationRequestService.createRegistrationRequest(registrationRequestModels, student);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            //e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
//    @PostMapping("")
//    public String createRegistrationRequest(@RequestBody RegistrationRequestObject requestObject){
//        RegistrationRequest registrationRequest1 = new RegistrationRequest();
//        List<CourseOffering> courseOfferingList = courseOfferingService.findAllCourseOffering();
//        //find student by id
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        AwesomeUserDetails loggedInUser = (AwesomeUserDetails) auth.getPrincipal();
//        Student student = studentService.findStudentByStudentId(loggedInUser.getId());
//
//        RegistrationEvent event = registrationEventService.findById(requestObject.getCourses()
//                .get(0).getReg_event_id());
//
//        LocalDate today = LocalDate.now();
//        LocalDate eventDate = event.getEndDate().toLocalDate();
//        int check = today.compareTo(eventDate);
//
//        requestObject.getCourses().forEach(courseRequest -> {
//            if(check > 0 ){
//                registrationRequest1.setPriority(courseRequest.getPriority());
//                //adding registration request to registration db table
//                RegistrationRequest userAddedRequest = registrationRequestService.createRegistrationRequest(registrationRequest1);
//
//                //adding registration request to student List
//                student.getRegistrationRequestList().add(userAddedRequest);
//                studentService.updateStudent(student);
//
//                //adding request to course offering list
//                courseOfferingList.forEach(courseOffering -> {
//                  boolean correctCourseOffer = courseOffering.getCourse().getCode().equals(courseRequest.getCourse_code());
//                  if(correctCourseOffer){
//                      courseOffering.getRegistrationRequestList().add(userAddedRequest);
//                      courseOfferingService.updateCourseOffering(courseOffering);
//                      }
//
//                });
//
//            }
//        });
//        return "successfully created a registration request";
//    }
}
