package com.apress.todo.config;

import com.mongodb.client.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.env.Environment;

@Configuration
public class ToDoConfig {
    private Environment environment;
    
    public ToDoConfig(Environment environment) {
        this.environment = environment;
    }
    // TODO: Solve MongoDB connection issue. Code below is as book example show the working with Spring Boot 2.x and Java 8
//    @Bean
//    @DependsOn("embeddedMongoServer")
//    public MongoClient mongoClient() {
//        int port = environment.getProperty("local.mongodb.port", Integer.class, Integer.class);
//        return new MongoClient("localhost", port);
//    }
    
}