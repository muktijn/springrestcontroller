package com.company.app.service;

import java.util.List;

import com.company.app.request.PersonRequest;
import com.company.app.response.PersonResponse;
import com.training.demohibernate.model.PersonInfo;

public interface PersonService {
    List<PersonInfo> findAll();
    PersonInfo findById(Integer id);
    public PersonResponse getPersonById(Integer id);
    PersonInfo save(PersonInfo person);
	void deleteById(Integer id);
	PersonResponse createPerson(PersonRequest personRequest);
	PersonResponse updatePerson(int id, PersonRequest personRequest);
}