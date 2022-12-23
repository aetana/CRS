package miu.edu.CourseRegistration1.controller;

import lombok.AllArgsConstructor;
import miu.edu.CourseRegistration1.entity.RegistrationEvent;
import miu.edu.CourseRegistration1.entity.Role;
import miu.edu.CourseRegistration1.entity.Student;
import miu.edu.CourseRegistration1.model.RegistrationEventModel;
import miu.edu.CourseRegistration1.model.RegistrationEventResponse;
import miu.edu.CourseRegistration1.security.AwesomeUserDetails;
import miu.edu.CourseRegistration1.service.StudentService;
import miu.edu.CourseRegistration1.service.impl.RegistrationEventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/registration-events")
public class RegistrationEventController {
    @Autowired
    private RegistrationEventServiceImpl registrationEvent;
    @Autowired
    private StudentService studentService;

    @GetMapping("/latest")
    public ResponseEntity<?> getLatestRegistrationEvent() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AwesomeUserDetails loggedInUser = (AwesomeUserDetails) auth.getPrincipal();
        if(loggedInUser.getRole() != Role.STUDENT)
            return ResponseEntity.badRequest().body("Do not Apply to Admin/Faculty!");
        Student student = studentService.findStudentByUserId(loggedInUser.getId());
        RegistrationEvent event = registrationEvent.getLatestRegistrationEvent(student.getId());
        if(event == null){
            return new ResponseEntity<String>("Registration Event Not Found! ", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<RegistrationEventResponse>(new RegistrationEventResponse(event, registrationEvent.checkEventStatus(event)), HttpStatus.OK);
    }

    //protected
    @PostMapping("")
    public ResponseEntity<?> createEvent(@RequestBody RegistrationEvent event) {
        registrationEvent.createRegistrationEvent(event);
        return new ResponseEntity<String>("Registration Event creation - Success!", HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<?> getAllRegistrationEvents() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AwesomeUserDetails loggedInUser = (AwesomeUserDetails) auth.getPrincipal();

        if (loggedInUser.getRole() == Role.ADMIN) {
            return new ResponseEntity<List<RegistrationEvent>> (registrationEvent.findAll(),HttpStatus.OK);
        } else if(loggedInUser.getRole() == Role.STUDENT) {
            Student student = studentService.findStudentByUserId(loggedInUser.getId());
            return new ResponseEntity<List<RegistrationEvent>> (registrationEvent.getAllRegistrationEventByStudentId(student.getStudentID()),HttpStatus.OK);
        }else{
            return new ResponseEntity<String> ("Faculty Do Not Have Registration Event!",HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getRegistrationEventById(@PathVariable Long id) {
        RegistrationEvent regEvent = registrationEvent.findById(id);
        if (regEvent != null) return new ResponseEntity<RegistrationEvent>(regEvent,HttpStatus.OK);
        return new ResponseEntity<String>("Registration Event with this Id is Not Found!",HttpStatus.NOT_FOUND);
    }

    //protected
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRegistrationEventById(@PathVariable Long id) {
        registrationEvent.deleteById(id);
        return new ResponseEntity<String>("Registration Event deletion - Success!", HttpStatus.OK);
    }

    //protected
    @PutMapping("/{id}")
    public ResponseEntity<String> updateRegistrationEvent(@PathVariable Long id, @RequestBody RegistrationEvent event) {
        registrationEvent.updateRegistrationEvent(event, id);
        return new ResponseEntity<String>("Registration Event update - Success!", HttpStatus.OK);
    }

}