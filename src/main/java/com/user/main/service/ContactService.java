package com.user.main.service;

import com.user.main.entity.Contact;

public interface ContactService {

	public boolean saveContact(Contact contact);

	public Boolean isContactExists(Contact contact);

}
