package com.personapi.personapi.Repository;

import com.personapi.personapi.Models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    
    //  Buscar por email
    Person findByEmail(String email);
}
