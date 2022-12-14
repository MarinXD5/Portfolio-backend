package com.example.Portfolio.services;

import com.example.Portfolio.consts.Constants;
import com.example.Portfolio.entities.contact.ContactDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class ContactService {
    static Constants consts = new Constants();
    public static ContactDTO getContact() throws IOException {

        ContactDTO contact = new ContactDTO();
        try{
            Document document = Jsoup.connect(consts.getPASTEBIN_URL()).get();
            Elements elements = document.getElementsByClass("li1");

            for(Element element : elements ){
                String method = element.getElementsByClass("de1").text();
                if(method.equals("Marin")){
                    contact.setFirstName(method);
                }
                else if (method.equals("Jurlina")){
                    contact.setLastName(method);
                }
                else if (method.equals("23.12.2000")){
                    contact.setDob(method);
                }
                else{
                    contact.setPhone_number(method);
                }
            }
        } catch(IOException ex){
            ex.printStackTrace();
        }


        return contact;
    }
}
