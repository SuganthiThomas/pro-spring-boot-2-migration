package com.apress.todo.controller;

import com.apress.todo.domain.ToDo;
import com.apress.todo.repository.ToDoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


// If you want to test and try using ToDoRouter and ToDoHandler, comment this annotation so Spring Boot does not
// auto-configure this controller. It's worth mentioning both approaches produce the same result.
@RestController
public class ToDoController {
    
    
    
    private ToDoRepository repository;
    
    
    public ToDoController(ToDoRepository repository) {
        this.repository = repository;
    }
    
    @GetMapping("/todo/{id}")
    public Mono<ToDo> getToDo(@PathVariable String id){
        return this.repository.findById(id);
    }
    
    @GetMapping("/todo")
    public Flux<ToDo> getToDos(){
        return this.repository.findAll();
    }
}
