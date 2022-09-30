package com.example.Portfolio.services;

import com.example.Portfolio.consts.Constants;
import com.example.Portfolio.entities.contact.ContactDTO;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class ContactService {
    static Constants consts = new Constants();

    public static ContactDTO getVarContact(String content) throws IOException{
        ContactDTO contentContact = new ContactDTO();

        for (int i = 0; i < content.length(); i++){
            if(content.equals("Marin")){
                contentContact.setFirstName("Marin");
            }
            if(content.equals("Jurlina")){
                contentContact.setLastName("Jurlina");
            }
            if(content.equals("23.12.2000")){
                contentContact.setDateOfBirth("23.12.2000");
            }
            if(content.equals("Test Description")){
                contentContact.setDescription("Test Description");
            }
        }
        return contentContact;
    }

    public static ContactDTO getContact() throws FileNotFoundException {

        ContactDTO contactDTO = null;
        try {
            DataInputStream DIS = new DataInputStream(new FileInputStream(consts.getFileLocation()));

            byte[] datainBytes = new byte[DIS.available()];
            DIS.readFully(datainBytes);
            DIS.close();

            String content = new String(datainBytes, 0, datainBytes.length);

            contactDTO = getVarContact(content);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return contactDTO;
    }

}
