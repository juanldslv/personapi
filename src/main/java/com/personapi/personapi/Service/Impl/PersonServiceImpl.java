package com.personapi.personapi.Service.Impl;

import com.personapi.personapi.Models.Person;
import com.personapi.personapi.Repository.PersonRepository;
import com.personapi.personapi.Service.PersonService;   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Long id, Person person) {
        Optional<Person> existingPerson = personRepository.findById(id);
        if (existingPerson.isPresent()) {
            Person updatedPerson = existingPerson.get();
            updatedPerson.setFirstName(person.getFirstName());
            updatedPerson.setLastName(person.getLastName());
            updatedPerson.setEmail(person.getEmail());
            updatedPerson.setPhoneNumber(person.getPhoneNumber());
            updatedPerson.setAge(person.getAge());
            updatedPerson.setAddress(person.getAddress());
            return personRepository.save(updatedPerson);
        }
        return null;
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
