package com.apress.todo.cloud;


import com.apress.todo.domain.ToDo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.function.Supplier;


// The version illustrated in the Spring Boot 2 version has some annotations deprecated. Therefore, some significant changes need to be done
//@Configuration
public class ToDoSource {
    
//    @Bean
    public Supplier<ToDo> simpleToDo() {
        return () -> new ToDo("Test Spring Cloud Stream");
    }
}
