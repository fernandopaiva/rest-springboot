package com.ferpateste.services;

import com.ferpateste.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(String id){
        logger.info("Finding Person By Id: " + id);
        Person p = new Person();
        p.setId(counter.incrementAndGet());
        p.setNome("Fernando Paiva");
        p.setEmail("eu@eu.com");
        return p;
    }

    public List<Person> findAll(){
        logger.info("Finding All Persons");
        List<Person> lista = new ArrayList<Person>();
        Person p1 = new Person();
        p1.setId(counter.incrementAndGet());
        p1.setNome("Fernando Paiva");
        p1.setEmail("eu@eu.com");

        Person p2 = new Person();
        p2.setId(counter.incrementAndGet());
        p2.setNome("Tauana Paiva");
        p2.setEmail("tau@eu.com");

        lista.add(p1);
        lista.add(p2);

        return lista;
    }

}
