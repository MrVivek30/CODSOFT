package com.codsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codsoft.model.Contact;
import com.codsoft.service.ContactService;

@RestController
@RequestMapping("/contacts")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@GetMapping
	public ResponseEntity<List<Contact>> getAllContacts() {
		List<Contact> contacts = contactService.getAllContacts();
		return new ResponseEntity<>(contacts, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Contact> getContactById(@PathVariable Integer id) {

		Contact contact = contactService.getContactById(id);
		return new ResponseEntity<>(contact, HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<Contact> addContact(@RequestBody Contact contact) {
		Contact newContact = contactService.addContact(contact);
		return new ResponseEntity<>(newContact, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Contact> updateContact(@RequestBody Contact updatedContact) {

		Contact contact = contactService.updateContact(updatedContact);
		return new ResponseEntity<>(contact, HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Contact> deleteContact(@PathVariable Integer id) {

		Contact deletedContact = contactService.deleteContact(id);
		return new ResponseEntity<>(deletedContact, HttpStatus.OK);

	}
}