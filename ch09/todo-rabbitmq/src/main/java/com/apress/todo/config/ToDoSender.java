package com.apress.todo.config;

import com.apress.todo.domain.ToDo;
import com.apress.todo.rmq.ToDoProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

// This version of the class is the one which only sends a single message
//@Configuration
//public class ToDoSender {
//    @Bean
//    public CommandLineRunner sendToDos(@Value("${todo.jms.destination}") String destination, ToDoProducer producer) {
//        return args ->{
//            producer.sendTo(destination, new ToDo("workout tomorrow morning!"));
//        };
//    }
//}

// This newer version schedules a deliverable message every 10 seconds
@EnableScheduling
@Configuration
public class ToDoSender{
    @Autowired
    private ToDoProducer toDoProducer;
    @Value("${todo.amqp.queue}")
    private String destination;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    
    @Scheduled(fixedRate = 5000)
    private void sendToDos(){
        toDoProducer.sendTo(destination, new ToDo("Thinking on Spring Boot at " + dateFormat.format(new Date())));
    }
    
}