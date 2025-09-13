package com.apress.directory.repository;

import com.apress.directory.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends JpaRepository<Person, String> {
    public Person findByEmailIgnoreCase(@Param("email") String email);
}
