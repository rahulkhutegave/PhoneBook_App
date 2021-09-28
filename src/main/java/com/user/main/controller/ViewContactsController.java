package com.user.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.user.main.entity.Contact;
import com.user.main.service.ContactService;

@Controller
public class ViewContactsController {

	@Autowired
	private ContactService service;

	@GetMapping("/editContacts")
	public ModelAndView handleEditLinkClick(@RequestParam("cid") Integer contactId) {

		ModelAndView mav = new ModelAndView();
		Contact cobj = service.getContactById(contactId);
		mav.addObject("contact", cobj);
		mav.setViewName("contact");

		return mav;
	}

	@GetMapping("/deleteContact")
	public String handleDeleteLinkClick(@RequestParam("cid") Integer contactId) {
		service.deleteContactById(contactId);

		return "redirect:viewContacts";
	}

}
