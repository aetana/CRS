package miu.edu.CourseRegistration1.kafka;

import miu.edu.CourseRegistration1.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Subscriber {

    @Autowired
    EmailSenderService emailSenderService;

    @KafkaListener(topics = "emailTopic")
    public void consumeEmailMessage(@Payload EmailMessage emailMessage){
        emailSenderService.sendMail(emailMessage);
    }
}
