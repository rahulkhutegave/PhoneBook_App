package com.user.main.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	@GetMapping("/viewContacts")
	public ModelAndView handleViewAllContactsClick(HttpServletRequest req) {
		
		ModelAndView mav=new ModelAndView();
		
		Integer pageSize=3;
		
		Integer pageNumber=1;
		
		String parameter = req.getParameter("pno");
		
		if(!"".equals(parameter) && parameter!=null) {
			 pageNumber = Integer.parseInt(parameter);
		}
		
		Page<Contact> page = contactService.getAllContactNew(pageNumber-1, pageSize);
		
		List<Contact> allContacts = page.getContent();
		
		int tp = page.getTotalPages();
		
		mav.addObject("tp", tp);
		mav.addObject("contacts", allContacts);
		
		mav.addObject("currPno", pageNumber);
		mav.setViewName("viewContacts");
		
		
		return mav;
	}

}
