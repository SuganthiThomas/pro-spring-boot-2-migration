package com.apress.todo.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
@Data
public class ToDo {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @NotNull
    @NotBlank
    private String description;
    
    @Column(insertable = true , updatable = false)
    private LocalDateTime created;
    private LocalDateTime modified;
    private boolean completed;
    
    public ToDo(){}
    
    public ToDo(String description){
        this.description = description;
    }
    
    @PrePersist
    void onCreate(){
        this.setCreated(LocalDateTime.now());
        this.setModified(LocalDateTime.now());
    }
    @PreUpdate
    void onUpdate(){
        this.setModified(LocalDateTime.now());
    }
    
    
    
}
