package com.example.Portfolio.controllers;

import com.example.Portfolio.entities.contact.ContactDTO;
import com.example.Portfolio.services.ContactService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.Set;

@RestController
public class ContactController {

    @CrossOrigin("http://localhost:4200")
    @RequestMapping(path = "/contact")
    public ContactDTO getContact() throws FileNotFoundException {
        return ContactService.getContact();
    }
}
