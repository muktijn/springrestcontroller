package com.company.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.demohibernate.Repository.ContactRepository;
import com.training.demohibernate.model.Contact;


@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact findById(Integer id) {
        return contactRepository.findById(id).orElse(null);
    }

    @Override
    public Contact save(Contact person) {
        return contactRepository.save(person);
    }

    @Override
    public void deleteById(Integer id) {
        contactRepository.deleteById(id);
    }
}