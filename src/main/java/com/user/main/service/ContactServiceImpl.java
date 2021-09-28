package com.user.main.service;

import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

	@Override
	public Page<Contact> getAllContactNew(Integer pageNo, Integer pageSize) {

		Contact contactFilter = new Contact();
		contactFilter.setActivesw("Y");
		Example<Contact> example = Example.of(contactFilter);
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		return contactRepo.findAll(example, pageRequest);

	}

	@Override
	public Contact getContactById(Integer contactId) {

		Optional<Contact> findById = contactRepo.findById(contactId);
		if (findById.isPresent()) {
			return findById.get();
		}

		return null;
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
		//Soft Delete		
		Optional<Contact> findById = contactRepo.findById(contactId);
		if (findById.isPresent()) {
			Contact contact = findById.get();
			contact.setActivesw("N");
			contactRepo.save(contact);
			return true;
		}

		return false;
	}

}
