package miu.edu.CourseRegistration1.rabbitMQ.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitService {
    private final RabbitTemplate rabbitTemplate;
    final private Queue mQueue;

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(mQueue.getName(), message);
    }

}
