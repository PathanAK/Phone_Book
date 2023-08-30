package com.asif.phonebookminiprojectone.Controller;

import com.asif.phonebookminiprojectone.Dao.Contact;
import com.asif.phonebookminiprojectone.Service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/contact")
@Tag(name="PHONE BOOK Rest API", description = "Phone book backend crud operations")
public class ContactController {

    @Autowired
    private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @Operation(summary = "Print the Greet message", description = "Good morning")
    @GetMapping("/greet")
    public ResponseEntity<String> greet() {
        return new ResponseEntity<>("Good Morning", HttpStatus.OK);
    }

    @Operation(summary = "Save endpoint", description = "save the given contact details")
    @PostMapping("/save")
    public ResponseEntity<String> saveContact(@RequestBody Contact contact) {
        return new ResponseEntity<>(contactService.saveContact(contact), HttpStatus.CREATED);
    }

    @Operation(summary = "Display all contact", description = "display all the saved contact from the phone book")
    @GetMapping()
    public ResponseEntity<List<Contact>> getAllContacts() {
        return new ResponseEntity<>(contactService.getAllContact(), HttpStatus.OK);
    }
    @Operation(summary = "Display contact by id", description = "display saved contact by given id given by the user")
    @GetMapping("/{contactId}")
    public ResponseEntity<Contact> getContactByID(@PathVariable Integer contactId) {
        return new ResponseEntity<>(contactService.getContactById(contactId), HttpStatus.OK);
    }

    @Operation(summary = "update contact", description = "update contact of the given id")
    @PutMapping("/{contactId}")
    public ResponseEntity<String> updateContact(@RequestBody Contact contact) {
        return new ResponseEntity<>(contactService.updateContact(contact), HttpStatus.ACCEPTED);
    }

    @Operation(summary = "delete contact", description = "delete contact by the given id")
    @DeleteMapping("/{contactId}")
    public ResponseEntity<String> deleteContact(@PathVariable Integer contactId) {
        return new ResponseEntity<>(contactService.deleteContactById(contactId), HttpStatus.ACCEPTED);
    }
}
