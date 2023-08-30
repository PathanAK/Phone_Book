package com.asif.phonebookminiprojectone.Controller;

import com.asif.phonebookminiprojectone.Dao.Contact;
import com.asif.phonebookminiprojectone.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/greet")
    public ResponseEntity<String> greet() {
        return new ResponseEntity<>("Good Morning", HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveContact(@RequestBody Contact contact) {
        return new ResponseEntity<>(contactService.saveContact(contact), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Contact>> getAllContacts() {
        return new ResponseEntity<>(contactService.getAllContact(), HttpStatus.OK);
    }

    @GetMapping("/{contactId}")
    public ResponseEntity<Contact> getContactByID(@PathVariable Integer contactId) {
        return new ResponseEntity<>(contactService.getContactById(contactId), HttpStatus.OK);
    }

    @PutMapping("/{contactId}")
    public ResponseEntity<String> updateContact(@RequestBody Contact contact) {
        return new ResponseEntity<>(contactService.updateContact(contact), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{contactId}")
    public ResponseEntity<String> deleteContact(@PathVariable Integer contactId) {
        return new ResponseEntity<>(contactService.deleteContactById(contactId), HttpStatus.ACCEPTED);
    }
}
