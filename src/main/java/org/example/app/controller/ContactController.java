package org.example.app.controller;

import org.example.app.dto.contact.ContactDtoRequest;
import org.example.app.entity.Contact;
import org.example.app.service.contact.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class ContactController {

    @Autowired
    private ContactService service;

    @GetMapping("/contacts")
    public String fetchAllContacts(Model model) {
        List<Contact> list = service.fetchAll();
        model.addAttribute("title", "Contacts");
        if (list.isEmpty()) {
            model.addAttribute("contactsInfo", "No Contacts yet :(");
        } else {
            model.addAttribute("contacts", list);
        }
        model.addAttribute("fragmentName", "contact-list");
        return "layout";
    }

    @RequestMapping("/create-contact")
    public String createContact(Model model) {
        model.addAttribute("title", "Add Contact");
        model.addAttribute("fragmentName", "contact-add");
        return "layout";
    }

    @RequestMapping(value = "/add-contact", method = RequestMethod.POST)
    public RedirectView addContact(@ModelAttribute ContactDtoRequest request) {
        RedirectView redirectView = new RedirectView("./contacts");
        if (service.create(request))
            return redirectView;
        else return redirectView;
    }

    @RequestMapping("/update-contact/{id}")
    public String updateContact(@PathVariable("id") Long id, Model model) {
        model.addAttribute("title", "Update Contact");
        Contact contact = service.fetchById(id);
        model.addAttribute("contact", contact);
        model.addAttribute("fragmentName", "contact-update");
        return "layout";
    }

    @RequestMapping(value = "/change-contact", method = RequestMethod.POST)
    public RedirectView changeContact(@ModelAttribute ContactDtoRequest request) {
        RedirectView redirectView = new RedirectView("./contacts");
        if (service.update(request.id(), request))
            return redirectView;
        else return redirectView;
    }

    @RequestMapping("/delete-contact/{id}")
    public RedirectView deleteContact(@PathVariable("id") Long id) {
        RedirectView redirectView = new RedirectView("../contacts");
        if (service.delete(id)) return redirectView;
        else return redirectView;
    }

}
