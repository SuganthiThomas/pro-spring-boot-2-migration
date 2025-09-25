package com.apress.task;

import com.apress.todo.annotation.EnableToDoSecurity;
import com.apress.todo.client.ToDoClient;
import com.apress.todo.domain.ToDo;
import com.apress.todo.security.ToDoSecurity;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@EnableToDoSecurity
@SpringBootApplication
public class TaskApplication {
    
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(TaskApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }
    
    @Bean
    ApplicationRunner createToDos(ToDoClient client) {
        return args -> {
            ToDo toDo = client.add(new ToDo("Read a Book"));
            // TODO There is a problem when building the url to fetch the todo item. The item si saved successfully.
            //However, the following exception is causing the problem:
            // org.springframework.web.client.HttpClientErrorException$NotFound: 404  on GET request for "http://localhost:8080//toDos//": "{"timestamp":"2025-09-25T01:14:30.143+00:00","status":404,"error":"Not Found","path":"//toDos//"}"
            // Basically, the path is malformed due to double forward slashes. The correct path, at least tested manually is http://localhost:8080/toDos
            ToDo review = client.findyById(toDo.getId());
            System.out.println(review);
            System.out.println(client.findAll());
        };
    }
    
    @Bean
    ApplicationRunner secure(ToDoSecurity utils) {
        return args -> {
            String text = "This text will be encrypted";
            String hash = utils.getEncoder().encode(text);
            System.out.println(">>> ENCRYPT: " + hash);
            System.out.println(">>> Verify: " + utils.getEncoder().matches(text, hash));
        };
    }
    
}
