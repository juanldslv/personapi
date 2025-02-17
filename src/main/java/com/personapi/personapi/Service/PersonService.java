package com.personapi.personapi.Service;

import com.personapi.personapi.Models.Person;
import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> getAllPersons();
    Optional<Person> getPersonById(Long id);
    Person createPerson(Person person);
    Person updatePerson(Long id, Person person);
    void deletePerson(Long id);
}
