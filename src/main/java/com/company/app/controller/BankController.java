package com.company.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.app.service.BankService;
import com.company.app.service.ContactService;
import com.company.app.service.PersonService;
import com.training.demohibernate.model.Bank;
import com.training.demohibernate.model.Contact;
import com.training.demohibernate.model.PersonInfo;

@Controller
public class BankController {

    private final BankService bankService;
    private final PersonService personService;
    private final ContactService contactService;

    

    @Autowired
    public BankController(BankService bankService, PersonService personService,
    		ContactService contactService) {
        this.bankService = bankService;
		this.personService = personService;
		this.contactService = contactService;
        
    }
    
    @GetMapping("/newBank")
    public String newBank() {
        return "newBank";
    }
    
    @GetMapping("/error")
    public String error() {
        return "error";
    }
    
    @GetMapping("/success")
    public String success() {
        return "success";
    }
    
    @PostMapping("/saveBank")
    public String saveContact(@ModelAttribute Bank bank, Model model,
    		RedirectAttributes redirectAttributes) {
        Bank addbank = bankService.save(bank);
        PersonInfo person = personService.findById(addbank.getPersonId());
        Contact contact   = contactService.findById(addbank.getPersonId());

        redirectAttributes.addFlashAttribute("bank", addbank);
        redirectAttributes.addFlashAttribute("contact", contact);
        redirectAttributes.addFlashAttribute("person", person);
        
        if (addbank != null  && (addbank.getPersonId() > 0)) 
           return "redirect:/success";
        else 
            return "error";   
    }
}