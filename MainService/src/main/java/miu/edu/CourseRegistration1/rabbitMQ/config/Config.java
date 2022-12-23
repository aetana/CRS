package miu.edu.CourseRegistration1.rabbitMQ.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class Config {



    @Bean
    public Queue registrationEventQueue() {
        return new Queue("registrationEventQueue", true);
    }



    @Bean
    FanoutExchange registrationExchange() {
        return new FanoutExchange("registrationEventQueue");
    }



    @Bean
    Binding registrationBinder(Queue registrationEventQueue, FanoutExchange registrationExchange) {
        return BindingBuilder.bind(registrationEventQueue).to(registrationExchange);
    }


}