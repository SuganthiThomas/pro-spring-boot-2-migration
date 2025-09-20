package com.apress.todo.cloud;

import com.apress.todo.domain.ToDo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Supplier;

@Configuration
public class ToDoSender {
    @Bean
    public Supplier<ToDo> sendToDo() {
        return () -> new ToDo("Read a Book");
    }
}
