package com.example.Portfolio.entities.contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO {
    private String firstName;
    private String lastName;
    private String phone_number;
    private String dob;
}
