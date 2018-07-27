package com.example.demo.api;

import java.util.Collection;

import javax.validation.Valid;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Contact;
import com.example.demo.service.ContactService;

@RestController
public class ContactsApi {
	
	@Autowired
	ContactService contactService;
	
	// Inyecta mapper de Dozer
	@Autowired
	Mapper mapper;
	 
	@RequestMapping(value="/contact", method=RequestMethod.POST)
	public ContactResponse updateOrSave(@RequestBody @Valid ContactRequest contactRequest){
		// Mapeo request dto ==> entity
		Contact contact = mapper.map(contactRequest, Contact.class);
	    
		// Invoca l[ogica de negocio
		Contact updatedContact = contactService.save(contact);
	    
		// Mapeo entity ==> response dto
	    ContactResponse contactResponse = mapper.map(updatedContact, ContactResponse.class); 
	    
	    return contactResponse;
	}
	
	@RequestMapping(value="/contact", method=RequestMethod.GET)
	public Contact getById(){
		return new Contact(1L, "John", "Doe", "+57 311 222 3344", "john@sinbugs.com");
	}
	
	@RequestMapping(value="/contacts", method=RequestMethod.GET)
	public Collection<Contact> findAll(){
		Collection<Contact> contactList = contactService.findAll();
		//Collection<ContactResponse> contactResponse = mapper.map(contactList, ContactResponse.class); 
		return contactList;
	}
	
	@RequestMapping(value="/deleteContact/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") long id){
		contactService.delete(id);;
		return "Bien!!!";
	}
	
}
