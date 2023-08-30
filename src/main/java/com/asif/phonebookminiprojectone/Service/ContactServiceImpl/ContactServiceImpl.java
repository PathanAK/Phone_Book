package com.asif.phonebookminiprojectone.Service.ContactServiceImpl;

import com.asif.phonebookminiprojectone.Dao.Contact;
import com.asif.phonebookminiprojectone.Repository.ContactRepository;
import com.asif.phonebookminiprojectone.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public String saveContact(Contact contact) {
        contact.setActiveSwitch("Y");
        contact = contactRepository.save(contact);
        if(contact.getContactId()!=null) {
            return "Contact Saved";
        }else{
            return "Unable to save contact";
        }
    }

    @Override
    public List<Contact> getAllContact() {
        List<Contact> contacts= contactRepository.findByActiveSwitch("Y");
        return contacts;
    }

    @Override
    public Contact getContactById(Integer contactId) {
        Optional<Contact> getById = contactRepository.findById(contactId);
        if(getById.isPresent()) {
            return getById.get();
        }
        return null;
    }

    @Override
    public String updateContact(Contact contact) {

        if(contactRepository.existsById(contact.getContactId())) {
            contactRepository.save(contact);
            return "Update Successfully";
        }
        return "Contact not found";
    }

    @Override
    public String deleteContactById(Integer contactId) {
//        if (contactRepository.existsById(contactId)) {
//            contactRepository.deleteById(contactId);
//            return "Contact deleted Successfully";
//        }else {
//            return "Contact not found";
//        }
        Optional<Contact> contactById = contactRepository.findById(contactId);
        if(contactById.isPresent()) {
            Contact contact = contactById.get();
            contact.setActiveSwitch("N");
            contactRepository.save(contact);
            return "Contact Deleted";
        }else {
            return null;
        }
    }
}
