package com.company.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import com.company.app.service.PersonService;
import com.training.demohibernate.model.PersonInfo;

import java.util.List;

@Controller
//@ComponentScan("com.company.app.Controller")
public class PersonController {

   
    
    @RequestMapping({"/","/newPerson"})
    public String person() {
        return "newPerson";
    }
    
    
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    
    @RequestMapping("/savePerson")
    @PostMapping
    public String savePerson(@ModelAttribute PersonInfo personInfo, Model model, RedirectAttributes redirectAttributes) {
        PersonInfo addperson = personService.save(personInfo);
        //model.addAttribute("person", addperson);
        redirectAttributes.addFlashAttribute("person", addperson);
        if (addperson != null  && (addperson.getPersonId() > 0)) 
           return "redirect:/newContact";
        else 
        	return "error";
        
    }

    @GetMapping
    public String listPersons(Model model) {
        List<PersonInfo> persons = personService.findAll();
        model.addAttribute("persons", persons);
        return "persons/list"; // Assuming you have a Thymeleaf template at src/main/resources/templates/persons/list.html
    }

    @GetMapping("/{id}")
    public String showPerson(@PathVariable Integer id, Model model) {
        PersonInfo person = personService.findById(id);
        if (person != null) {
            model.addAttribute("person", person);
            return "persons/show"; // Assuming you have a Thymeleaf template at src/main/resources/templates/persons/show.html
        } else {
            return "redirect:/persons"; // Redirect to the list if the person is not found
        }
    }



    @GetMapping("/new")
    public String newPersonForm(Model model) {
        model.addAttribute("person", new PersonInfo());
        return "persons/new"; // Assuming you have a Thymeleaf template at src/main/resources/templates/persons/new.html
    }

    @GetMapping("/edit/{id}")
    public String editPersonForm(@PathVariable Integer id, Model model) {
        PersonInfo person = personService.findById(id);
        if (person != null) {
            model.addAttribute("person", person);
            return "persons/edit"; // Assuming you have a Thymeleaf template at src/main/resources/templates/persons/edit.html
        } else {
            return "redirect:/persons";
        }
    }
/*
    @PostMapping("/update/{id}")
    public String updatePerson(@PathVariable Long id, Person personDetails) {
        Person person = personService.update(id, personDetails); // Assuming your service has an update method
        return "redirect:/persons";
    }
    */

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable Integer id) {
        personService.deleteById(id);
        return "redirect:/persons";
    }
    
}