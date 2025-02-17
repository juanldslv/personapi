package com.personapi.personapi;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.personapi.personapi.Controller.PersonController;
import com.personapi.personapi.Models.Person;
import com.personapi.personapi.Service.PersonService;

@WebMvcTest(PersonController.class)
public class PersonControllerTest {


    @MockitoBean
    private PersonService personService;
 @Autowired
    private MockMvc mockMvc;

    
    

    @Test
    void testGetAllPersons() throws Exception {
        Person person = new Person();
        person.setId(1L);
        person.setFirstName("Juan");

        Mockito.when(personService.getAllPersons()).thenReturn(Arrays.asList(person));

        mockMvc.perform(get("/api/persons"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName", is("Juan")));
    }

    @Test
    void testCreatePerson() throws Exception {
        Person person = new Person();
        person.setFirstName("Ana");
        person.setLastName("Lopez");

        Mockito.when(personService.createPerson(Mockito.any(Person.class))).thenReturn(person);

        mockMvc.perform(post("/api/persons")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(person)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is("Ana")));
    }
}
