package com.company.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.app.service.ContactService;
import com.training.demohibernate.model.Contact;

@Controller
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }
    
    @GetMapping("/newContact")
    public String newContact() {
        return "newContact";
    }
    
    @PostMapping("/saveContact")
    public String saveContact(@ModelAttribute Contact contact, Model model,
    		RedirectAttributes redirectAttributes) {
        Contact addcontact = contactService.save(contact);
        //model.addAttribute("contact", addcontact);
        redirectAttributes.addFlashAttribute("contact", addcontact);
        if (addcontact != null  && (addcontact.getPersonId() > 0)) 
           return "redirect:/newBank";
        else 
            return "error";   
    }
}