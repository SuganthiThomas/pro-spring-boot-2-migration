package com.apress.directory.security;

import com.apress.directory.domain.Person;
import com.apress.directory.repository.PersonRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

// TODO Analyze the missing dependencies, components and imports needed for this class to work correctly with Spring Boot 3
// TODO Appliction is not completed due to discrepancies among Sping Boot versions and dependencies
public class UserDetailsService implements UserDetailsService {
    
    private PersonRepository repo;
    
    public DirectoryUserDetailsService(PersonRepository repo) {
        this.repo = repo;
    }
    @Override
    public UserDetails laodUsername(String username) throws     UsernameNotFoundException {
        try{
            final Person person = this.repo.findByEmailIgnoreCase(username);
            
            if(person != null){
                PasswordEncoder encoder = PaswordEncoderFactories.createDelegatingPasswordEncoder();
                String password = encoder.encode(person.getPassword());
                
                return User.withUsername(person.getEmail()).accountLocked(!person.isEnabled()).password(password).roles(person.getRole()).build();
            }
        }catch (Exception ex){
            throw new UsernameNotFoundException(username);
        }
    }
}
