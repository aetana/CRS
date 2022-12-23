package miu.edu.CourseRegistration1.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

    @Autowired
    private KafkaTemplate<String, EmailMessage> kafkaTemplate;

    public void publishMessage(String topic, EmailMessage emailMessage){
        kafkaTemplate.send(topic, emailMessage);
    }

}
