package com.company.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.app.request.PersonRequest;
import com.company.app.response.PersonResponse;
import com.company.app.service.PersonService;

@RestController
public class PersonRestController {
 
    @Autowired
    private PersonService personService;
 
    @GetMapping("/persons/{id}")
    private ResponseEntity<PersonResponse> getPersonDetails(@PathVariable("id") int id) {
       	PersonResponse person = personService.getPersonById(id);
        return ResponseEntity.status(HttpStatus.OK).body(person);
    }
    
    @PostMapping("/persons")
    public ResponseEntity<PersonResponse> createPerson(@RequestBody PersonRequest personRequest) {
        PersonResponse person = personService.createPerson(personRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(person);
    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<PersonResponse> updatePerson(@PathVariable("id") int id, @RequestBody PersonRequest personRequest) {
        PersonResponse person = personService.updatePerson(id, personRequest);
        return ResponseEntity.status(HttpStatus.OK).body(person);
    }

    @DeleteMapping("/persons/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable("id") int id) {
        personService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
 
}