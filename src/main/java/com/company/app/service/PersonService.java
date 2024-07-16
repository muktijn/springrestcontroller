package com.company.app.service;

import java.util.List;

import com.training.demohibernate.model.PersonInfo;

public interface PersonService {
    List<PersonInfo> findAll();
    PersonInfo findById(Integer id);
    PersonInfo save(PersonInfo person);
	void deleteById(Integer id);
}