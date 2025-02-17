package com.personapi.personapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.personapi.personapi.Models.Person;
import com.personapi.personapi.Repository.PersonRepository;
import com.personapi.personapi.Service.Impl.PersonServiceImpl;


public class PersonServiceTest {
      @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonServiceImpl personService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllPersons() {
        Person person1 = new Person();
        person1.setId(1L);
        person1.setFirstName("Juan");
        person1.setLastName("Perez");

        Person person2 = new Person();
        person2.setId(2L);
        person2.setFirstName("Maria");
        person2.setLastName("Gomez");

        when(personRepository.findAll()).thenReturn(Arrays.asList(person1, person2));

        List<Person> persons = personService.getAllPersons();

        assertNotNull(persons);
        assertEquals(2, persons.size());
        verify(personRepository, times(1)).findAll();
    }

    @Test
    void testGetPersonById() {
        Person person = new Person();
        person.setId(1L);
        person.setFirstName("Juan");

        when(personRepository.findById(1L)).thenReturn(Optional.of(person));

        Optional<Person> result = personService.getPersonById(1L);

        assertNotNull(result);
        assertEquals("Juan", result.get().getFirstName());
        verify(personRepository, times(1)).findById(1L);
    }

    @Test
    void testCreatePerson() {
        Person person = new Person();
        person.setFirstName("Ana");
        person.setLastName("Lopez");

        when(personRepository.save(person)).thenReturn(person);

        Person createdPerson = personService.createPerson(person);

        assertNotNull(createdPerson);
        assertEquals("Ana", createdPerson.getFirstName());
        verify(personRepository, times(1)).save(person);
    }

    @Test
    void testUpdatePerson() {
        Person existingPerson = new Person();
        existingPerson.setId(1L);
        existingPerson.setFirstName("Carlos");

        Person updatedDetails = new Person();
        updatedDetails.setFirstName("Carlos Updated");

        when(personRepository.findById(1L)).thenReturn(Optional.of(existingPerson));
        when(personRepository.save(existingPerson)).thenReturn(existingPerson);

        Person updatedPerson = personService.updatePerson(1L, updatedDetails);

        assertNotNull(updatedPerson);
        assertEquals("Carlos Updated", updatedPerson.getFirstName());
        verify(personRepository, times(1)).save(existingPerson);
    }

    @Test
    void testDeletePerson() {
        Long id = 1L;

        personService.deletePerson(id);

        verify(personRepository, times(1)).deleteById(id);
    }
 
}
