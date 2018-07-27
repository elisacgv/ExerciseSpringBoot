package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ContactRepository;
import com.example.demo.entity.Contact;

@Service
public class ContactService {

    @Autowired
    ContactRepository dao;
     
    /*
     * Guarda un contacto en la BD, devuelve el contacto con ID
     */
    public Contact save(Contact contact){
        //return dao.saveAndFlush(contact);
    	return dao.save(contact);
    }
    
    public Collection<Contact> findAll(){
        return dao.findAll();
    }

    public void delete(Long id) {
    	
    	dao.deleteById(id);
    }
    
}
