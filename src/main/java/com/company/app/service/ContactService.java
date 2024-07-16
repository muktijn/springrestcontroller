package com.company.app.service;

import java.util.List;

import com.training.demohibernate.model.Contact;

public interface ContactService {
    List<Contact> findAll();
    Contact findById(Integer id);
    Contact save(Contact contact);
	void deleteById(Integer id);
}