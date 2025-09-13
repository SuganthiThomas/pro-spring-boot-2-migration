package com.apress.directory.config;

import com.apress.directory.repository.PersonRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class DirectorySecurityConfig {
    private PersonRepository personRepository;
    
    
    @Override
    public void configure(AuthenticationManagerBuilder auth){
        auth.userDetailsService(
                new DirectoryUserDetailsService(personRepository)
        )
    }
}
