package com.apress.todo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix="todo.jms")
public class ToDoProperties {
	private String destination;
}
