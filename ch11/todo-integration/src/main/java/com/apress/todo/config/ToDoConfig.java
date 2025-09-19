package com.apress.todo.config;

import com.apress.todo.domain.ToDo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

@Configuration
public class ToDoConfig {

    
    @Bean
    public ApplicationRunner runner(MessageChannel input){
        return args -> {
            input.send(MessageBuilder.withPayload(new ToDo("buy milk today", true)).build());
        };
    }
}
