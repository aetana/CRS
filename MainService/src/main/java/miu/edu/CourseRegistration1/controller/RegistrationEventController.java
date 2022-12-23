package miu.edu.CourseRegistration1.controller;

import lombok.AllArgsConstructor;
import miu.edu.CourseRegistration1.entity.RegistrationEvent;
import miu.edu.CourseRegistration1.model.RegistrationEventModel;
import miu.edu.CourseRegistration1.rabbitMQ.service.RabbitService;
import miu.edu.CourseRegistration1.security.AwesomeUserDetails;
import miu.edu.CourseRegistration1.service.EmailService;
import miu.edu.CourseRegistration1.service.impl.RegistrationEventServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/registration-events")
public class RegistrationEventController {
    RegistrationEventServiceImpl registrationEvent;

    RabbitService rabbitService;
    EmailService emailService;


    @GetMapping("/latest")
    public RegistrationEventModel getLatestRegistrationEvent(){
        return registrationEvent.getLatestRegistrationEvent();
    }

    //protected
    @PostMapping("")
    public String createEvent(@RequestBody RegistrationEvent event){
        registrationEvent.createRegistrationEvent(event);
        return  "success";
    }
    @GetMapping(value = "")
    public List<RegistrationEvent> getAllRegistrationEvents(){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AwesomeUserDetails authUser = (AwesomeUserDetails) auth.getPrincipal();
        if(authUser.getRole().equals("admin")){
            return registrationEvent.findAll();
        }else{
            return registrationEvent.findByStudentId(authUser.getId());
        }
    }

    @GetMapping("/{id}")
    public RegistrationEvent getRegistrationEventById(@PathVariable Long id){
        RegistrationEvent regEvent = registrationEvent.findById(id);
        if(regEvent != null) return regEvent;
        return regEvent ;
    }

    //protected
    @DeleteMapping("/{id}")
    public String deleteRegistrationEventById(@PathVariable Long id){
        registrationEvent.deleteById(id);
        return "Successfully deleted event";
    }

    //protected
    @PutMapping("/{id}")
    public  String updateRegistrationEvent(@PathVariable Long id, @RequestBody RegistrationEvent event){
        registrationEvent.updateRegistrationEvent(event, id);
        return  "success";
    }

    @GetMapping("/sendmail/{email}")
    public void sendingEmail(@PathVariable String email){
        emailService.sendSimpleMessage(email);
    }

}