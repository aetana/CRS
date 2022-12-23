package miu.edu.CourseRegistration1.service;

import miu.edu.CourseRegistration1.kafka.EmailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    public void sendMail(EmailMessage emailMessage) {
        try{
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(emailMessage.getRecipient());
            mailMessage.setSubject(emailMessage.getSubject());
            mailMessage.setText(emailMessage.getMessageBody());

            javaMailSender.send(mailMessage);
            System.out.println("Mail sent Successfully to "+emailMessage.getRecipient());
        } catch (Exception e){
            System.out.println("Error sending mail");
        }
    }

}
