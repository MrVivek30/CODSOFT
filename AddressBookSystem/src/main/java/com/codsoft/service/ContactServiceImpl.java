package com.codsoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codsoft.exception.ContactException;
import com.codsoft.model.Contact;
import com.codsoft.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public List<Contact> getAllContacts() {
		// TODO Auto-generated method stub
		
		return contactRepository.findAll();
	}

	@Override
	public Contact getContactById(Integer id) throws ContactException {
		// TODO Auto-generated method stub
		return contactRepository.findById(id).orElseThrow(()->new ContactException("Contact not found whith this id "+id));
	}

	@Override
	public Contact addContact(Contact contact) {
		// TODO Auto-generated method stub
		return contactRepository.save(contact);
	}

	@Override
	public Contact updateContact(Contact updatedContact) throws ContactException {
		// TODO Auto-generated method stub
		Contact contact=contactRepository.findById(updatedContact.getId()).orElseThrow(()->new ContactException("Contact not found whith this id "+updatedContact.getId()));
		
		return contactRepository.save(updatedContact);
	}

	@Override
	public Contact deleteContact(Integer id) throws ContactException {
		Contact contact=contactRepository.findById(id).orElseThrow(()->new ContactException("Contact not found whith this id "+id));
		contactRepository.delete(contact);
		return contact;
	}

	
}
