package miu.edu.CourseRegistration1.service.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import miu.edu.CourseRegistration1.entity.RegistrationEvent;
import miu.edu.CourseRegistration1.entity.RegistrationGroup;
import miu.edu.CourseRegistration1.repository.RegistrationGroupRepo;
import miu.edu.CourseRegistration1.service.EmailService;
import miu.edu.CourseRegistration1.service.RegistrationEventService;
import miu.edu.CourseRegistration1.service.RegistrationGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmailServiceImpl implements EmailService, CommandLineRunner {
    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    RegistrationEventService registrationEventService;
    @Autowired
    RegistrationGroupService registrationGroupService;

    private Map<Integer, Long> eventsTime = new HashMap<>();

    @Override
    public void sendSimpleMessage(String recipient) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@baeldung.com");
        message.setTo(recipient);
        message.setSubject("Registration event end date notice");
        message.setText("Friendly reminder that the time to registration event end date for is less than 8hours");
        emailSender.send(message);

    }

    @Scheduled(fixedRate = 10*60*(1000))
    public void checkExpiringTime(){
        Integer time = LocalTime.now().getMinute();
        sendSimpleMessage("abdelbif@gmail.com");

//        for(Map.Entry<Integer, Long> pair: eventsTime.entrySet()) {
//            if ((pair.getKey() - time) < 10) {
//                eventsTime.remove(pair.getKey());
//                RegistrationEvent event = registrationEventService.findById(pair.getValue());
//                List<RegistrationGroup> group = registrationGroupService.findRegistrationGroups();
//            }
//        }

    }

    @Override
    public void run(String... args) throws Exception {
//        List<RegistrationEvent> events = registrationEventService.findAll();
//        events.forEach(event -> {
//            LocalDate today = LocalDate.now();
//            LocalDate eventDate = LocalDate.of(event.getEndDate().getYear(),event.getEndDate().getMonth(), event.getEndDate().getDayOfMonth());
//            if(today.isEqual(eventDate)){
//                System.out.println("e");
//                eventsTime.put(event.getEndDate().getMinute(),event.getId());
//
//            }
//        });
    }
}