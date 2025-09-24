package com.apress.todo.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties(prefix = "todo.client")
public class ToDoClientProperties {
    
    private String host = "http://localhost:8080";
    private String path = "/toDos";
}
