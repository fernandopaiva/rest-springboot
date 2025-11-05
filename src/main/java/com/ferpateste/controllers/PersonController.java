package com.ferpateste.controllers;

import com.ferpateste.dto.PersonDTO;
import com.ferpateste.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService pService;

    //http://localhost:8080/person/findById/
    //@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "/findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO findById(@PathVariable("id") Long id){
        PersonDTO dto = pService.findById(id);
        dto.setBirthDay(new Date());
        return dto;
    }

    //http://localhost:8080/person/findAll/
    //@RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDTO> findAll(){
        return pService.findAll();
    }

    //http://localhost:8080/person/add
    //@RequestMapping(value = "/add", method = RequestMethod.POST,
    //        produces = MediaType.APPLICATION_JSON_VALUE,
    //        consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(value = "/add",
                            produces = MediaType.APPLICATION_JSON_VALUE,
                            consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO add(@RequestBody PersonDTO person){
        return pService.add(person);
    }

    //http://localhost:8080/person/edit/id
    //@RequestMapping(value = "/edit", method = RequestMethod.PUT,
    //        produces = MediaType.APPLICATION_JSON_VALUE,
     //       consumes = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping(value = "/edit",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO edit(@RequestBody PersonDTO person){
        return pService.edit(person);
    }

    //http://localhost:8080/person/delete/id
    //@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        pService.delete(id);
        return ResponseEntity.noContent().build();
    }

    //public void delete(@PathVariable Long id){



}
