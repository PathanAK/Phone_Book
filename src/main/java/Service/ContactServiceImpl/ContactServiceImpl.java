package Service.ContactServiceImpl;

import Dao.Contact;
import Repository.ContactRepository;
import Service.ContactService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    ContactRepository contactRepository;


    @Override
    public String saveContact(Contact contact) {
        contact= (Contact) contactRepository.save(contact);
        if(contact.getContactId()!=null) {
            return "Contact Saved Successfully..!";
        }else {
            return "Unable to save the contact..!!";
        }
    }

    @Override
    public List<Contact> getAllContact() {
        List<Contact> contacts= contactRepository.findAll();
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
        if (contactRepository.existsById(contactId)) {
            contactRepository.deleteById(contactId);
            return "Contact deleted Successfully";
        }else {
            return "Contact not found";
        }
    }
}
