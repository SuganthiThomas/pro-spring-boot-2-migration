package com.apress.todo.cloud;

import com.apress.todo.domain.ToDo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class ToDoSink {
    private Logger log = LoggerFactory.getLogger(ToDoSink.class);
    
    @Bean
    public Consumer<ToDo> process() {
        return message -> {
            log.info("SINK - Message Received >>> {}", message);
        };
    }
}
