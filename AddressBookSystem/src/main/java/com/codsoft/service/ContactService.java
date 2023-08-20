package com.codsoft.service;

import java.util.List;

import com.codsoft.exception.ContactException;
import com.codsoft.model.Contact;

public interface ContactService {
	public List<Contact> getAllContacts();

	public Contact getContactById(Integer id) throws ContactException;

	public Contact addContact(Contact contact);

	public Contact updateContact(Contact updatedContact) throws ContactException;

	public Contact deleteContact(Integer id) throws ContactException;
}
