package com.example.Portfolio.entities.contact;

import lombok.Data;

@Data
public class ContactDTO {
    private String firstName;
    private String lastName;
    private String dob;
    private String phone_number;

    public ContactDTO(String firstName, String lastName, String dob, String phone_number){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.phone_number = phone_number;
    }

    public ContactDTO(){

    }
}
