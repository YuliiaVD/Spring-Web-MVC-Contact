package org.example.app.service.contact;

import org.example.app.dto.contact.ContactDtoRequest;
import org.example.app.entity.Contact;
import org.example.app.service.BaseService;

import java.util.List;

public interface ContactService extends BaseService<Contact, ContactDtoRequest> {
    boolean create(ContactDtoRequest request);
    List<Contact> fetchAll();
    Contact fetchById(Long id);
    boolean update(Long id, ContactDtoRequest request);
    boolean delete(Long id);
}
