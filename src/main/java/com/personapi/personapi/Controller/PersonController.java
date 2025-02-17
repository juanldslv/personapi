package com.personapi.personapi.Controller;

import com.personapi.personapi.Models.Person;
import com.personapi.personapi.Models.Greeting;
import com.personapi.personapi.Service.PersonService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> getAllPersons() {
        logger.info("Obteniendo todas las personas");
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        logger.debug("Buscando persona con ID: {}", id);
        Optional<Person> person = personService.getPersonById(id);
        return person.map(ResponseEntity::ok).orElseGet(() -> {
            logger.warn("No se encontró la persona con ID: {}", id);
            return ResponseEntity.notFound().build();});
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        logger.info("Creando persona: {}", person);
        return personService.createPerson(person);
    }
    private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
    @GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "Mr") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person person) {
        logger.info("Actualizando persona con ID: {}", id);
        Person updatedPerson = personService.updatePerson(id, person);
        if (updatedPerson != null) {
            logger.debug("Persona actualizada: {}", updatedPerson);
            return ResponseEntity.ok(updatedPerson);
        }
        logger.warn("No se encontró la persona con ID: {}", id);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        logger.info("Eliminando persona con ID: {}", id);
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }
}
