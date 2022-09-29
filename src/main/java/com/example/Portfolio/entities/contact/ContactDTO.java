package com.example.Portfolio.entities.contact;

import lombok.Data;

import java.util.Date;

@Data
public class ContactDTO {
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String description;
}
