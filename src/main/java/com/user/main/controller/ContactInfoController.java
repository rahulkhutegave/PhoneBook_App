package com.user.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.user.main.entity.Contact;
import com.user.main.service.ContactService;

@Controller
public class ContactInfoController {

	private ContactService contactService;

	public ContactInfoController(ContactService contactService) {
		super();
		this.contactService = contactService;
	}

	@GetMapping("/loadForm")
	public String loadForm(Model model) {
		Contact cobj = new Contact();
		model.addAttribute("contact", cobj);
		return "contact";
	}

	@PostMapping("/saveContact")
	public String handleSaveBtn(Contact cont, Model model) {

		Boolean contactExists = contactService.isContactExists(cont);
		if (contactExists) {
			model.addAttribute("errMsg", "Duplicate Contact Found!!");
		} else {
			cont.setActivesw("Y");
			boolean isSaved = contactService.saveContact(cont);
			if (isSaved) {
				model.addAttribute("succMsg", "Contact Saved Successfully!!");
			} else {
				model.addAttribute("errMsg", "Something Went Wrong!!");
			}
		}

		return "contact";
	}

}
