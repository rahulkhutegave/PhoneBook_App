package com.user.main.service;

import org.springframework.data.domain.Page;

import com.user.main.entity.Contact;

public interface ContactService {

	public boolean saveContact(Contact contact);

	public Boolean isContactExists(Contact contact);
	
	public Page<Contact> getAllContactNew(Integer pageNo, Integer pageSize);

}
