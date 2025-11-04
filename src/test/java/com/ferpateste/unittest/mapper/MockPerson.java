package com.ferpateste.unittest.mapper;

import java.util.ArrayList;
import java.util.List;

import com.ferpateste.dto.PersonDTO;
import com.ferpateste.model.Person;

public class MockPerson {


    public Person mockEntity() {
        return mockEntity(0);
    }
    
    public PersonDTO mockDTO() {
        return mockDTO(0);
    }
    
    public List<Person> mockEntityList() {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<PersonDTO> mockDTOList() {
        List<PersonDTO> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockDTO(i));
        }
        return persons;
    }
    
    public Person mockEntity(Integer number) {
        Person person = new Person();
        person.setId((long)number);
        person.setNome("Person: " + number);
        person.setEmail("eu@" + number + ".com");
        person.setCpf("xxx.xxx.xxx-" + number);
        return person;
    }

    public PersonDTO mockDTO(Integer number) {
        PersonDTO person = new PersonDTO();
        person.setId((long)number);
        person.setNome("Person: " + number);
        person.setEmail("eu@" + number + ".com");
        person.setCpf("xxx.xxx.xxx-" + number);
        return person;
    }

}