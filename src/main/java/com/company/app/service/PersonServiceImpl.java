package com.company.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.demohibernate.Repository.PersonRepository;
import com.training.demohibernate.model.PersonInfo;


@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<PersonInfo> findAll() {
        return personRepository.findAll();
    }

    @Override
    public PersonInfo findById(Integer id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public PersonInfo save(PersonInfo person) {
        return personRepository.save(person);
    }

    @Override
    public void deleteById(Integer id) {
        personRepository.deleteById(id);
    }
}