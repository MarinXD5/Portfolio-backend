package com.example.Portfolio.entities.contact;

import com.example.Portfolio.services.ContactService;
import lombok.Data;

import java.util.Date;

@Data
public class ContactDTO {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String description;

    public ContactDTO(String firstName, String lastName, String dateOfBirth, String description){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.description = description;
    }

    public ContactDTO(){

    }
}
