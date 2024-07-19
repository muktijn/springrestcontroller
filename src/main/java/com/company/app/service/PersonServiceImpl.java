package com.company.app.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.app.request.PersonRequest;
import com.company.app.response.PersonResponse;
import com.training.demohibernate.Repository.PersonRepository;
import com.training.demohibernate.model.PersonInfo;


@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final ModelMapper mapper;
    
    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, ModelMapper mapper) {
        this.personRepository = personRepository;
		this.mapper = new ModelMapper();    
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
    public PersonResponse getPersonById(Integer id) {
        Optional<PersonInfo> person = personRepository.findById(id);
        PersonResponse personResponse = mapper.map(person, PersonResponse.class);
        return personResponse;
    }
    private PersonResponse convertToPersonResponse(PersonInfo person) {
        PersonResponse personResponse = new PersonResponse();
        personResponse.setPersonId(person.getPersonId()); // Assuming there's an getId() method in Person
        personResponse.setFirstName(person.getFirstName());
        personResponse.setLastName(person.getLastName());
        personResponse.setMiddleName(person.getMiddleName());
        personResponse.setGender(person.getGender());
        // Add other fields as necessary, based on the Person class structure
        return personResponse;
    }
    public PersonResponse createPerson(PersonRequest personRequest) {
        // Convert PersonRequest to Person entity
        PersonInfo person = mapper.map(personRequest, PersonInfo.class);
        		
        		/*new PersonInfo();
        person.setFirstName(personRequest.getFirstName());
        person.setLastName(personRequest.getLastName());
        person.setMiddleName(personRequest.getMiddleName());
        person.setGender(personRequest.getGender());
        */
        // Save the new person entity to the database
        PersonInfo savedPerson = personRepository.save(person);

        // Convert saved Person entity to PersonResponse and return
        return mapper.map(savedPerson, PersonResponse.class);
    }

    public PersonResponse updatePerson(int id, PersonRequest personRequest) {
        // Find the existing person by id
        Optional<PersonInfo> existingPersonOptional = personRepository.findById(id);
        if (existingPersonOptional.isPresent()) {
            PersonInfo existingPerson = existingPersonOptional.get();

            // Update the existing person entity with values from PersonRequest
            existingPerson.setFirstName(personRequest.getFirstName());
            existingPerson.setLastName(personRequest.getLastName());
            existingPerson.setMiddleName(personRequest.getMiddleName());
            existingPerson.setGender(personRequest.getGender());
            

            // Save the updated person entity to the database
            PersonInfo updatedPerson = personRepository.save(existingPerson);

            // Convert updated Person entity to PersonResponse and return
            return convertToPersonResponse(updatedPerson);
        } else {
            // Handle the case where the person with the given id does not exist
            // This could involve throwing an exception or returning null
            return null;
        }
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