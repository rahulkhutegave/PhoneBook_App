package com.user.main.service;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.user.main.entity.Contact;
import com.user.main.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	private ContactRepository contactRepo;

	public ContactServiceImpl(ContactRepository contactRepo) {
		super();
		this.contactRepo = contactRepo;
	}

	@Override
	public boolean saveContact(Contact contact) {

		Contact entity = contactRepo.save(contact);

		if (entity != null && entity.getContactId() != null) {
			return true;
		}

		return false;
	}

	@Override
	public Boolean isContactExists(Contact contact) {

		Example<Contact> example = Example.of(contact);
		return contactRepo.exists(example);
	}

}
