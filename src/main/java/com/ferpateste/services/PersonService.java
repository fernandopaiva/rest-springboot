package com.ferpateste.services;

import com.ferpateste.controllers.TestLogController;
import com.ferpateste.dto.PersonDTO;
import com.ferpateste.exceptions.ResourceNotFoundException;
import com.ferpateste.mapperdto.ObjectMapper;
import com.ferpateste.model.Person;
import com.ferpateste.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Optional;


@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(TestLogController.class.getName());


    @Autowired
    private PersonRepository repository;

    public PersonDTO findById(Long id){
        logger.info("Finding Person By Id: " + id);
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Record not found"));
        return ObjectMapper.parseObject(entity, PersonDTO.class);
    }

    public List<PersonDTO> findAll(){
        logger.info("Finding All Persons");
        List<Person> lista = repository.findAll();
        return ObjectMapper.parseListObjects(lista, PersonDTO.class);
    }

    //add new person
    public PersonDTO add(PersonDTO personDTO){
        logger.info("Add New Person");
        Person p = ObjectMapper.parseObject(personDTO, Person.class);
        return ObjectMapper.parseObject(repository.saveAndFlush(p), PersonDTO.class);
    }

    //edit person
    public PersonDTO edit(PersonDTO personDTO){
        logger.info("Edit Person");
        Person p = ObjectMapper.parseObject(personDTO, Person.class);
        Person entity = repository.findById(p.getId()).orElseThrow(() -> new ResourceNotFoundException("Record not found"));
        entity.setNome(p.getNome());
        entity.setEmail(p.getEmail());
        entity.setCpf(p.getCpf());
        return ObjectMapper.parseObject(repository.saveAndFlush(entity), PersonDTO.class);
    }

    //delete person
    public void delete(long id){
        logger.info("Delete Person");
        Person p = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Record not found"));

        repository.delete(p);
    }





}
