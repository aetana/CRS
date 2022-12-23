//package miu.edu.CourseRegistration1.jms;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import miu.edu.CourseRegistration1.model.RegistrationEventModel;
//import org.springframework.jms.annotation.JmsListener;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//@Component
//public class RegistrationEventListener {
//    @JmsListener(destination = "registrationEventQueue")
//    public  void receiveMessage(final String registrationEventModelAsString){
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            RegistrationEventModel registrationEventModel = objectMapper.readValue(registrationEventModelAsString, RegistrationEventModel.class);
//            System.out.println("JMS receiver received message: " + registrationEventModelAsString);
//        }catch (IOException e){
//            System.out.println("JMS receiver: Cannot convert : " + registrationEventModelAsString+" to an Event object");
//        }
//    }
//}
