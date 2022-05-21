package in.ashokit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import in.ashokit.entity.Contact;
import in.ashokit.service.ContactService;




@RestController

public class ContactRestController {
	@Autowired(required=true)

private ContactService Service;

@PostMapping("/contact")
ResponseEntity<String> Contact (@RequestBody Contact contact){
Service.upsert(contact);
return new ResponseEntity<>("",HttpStatus.CREATED);
}
	
@GetMapping("/contacts")
ResponseEntity<List<Contact>> getAllContacts( ) {
	List<Contact>allContacts=Service.getAllContacts();
	return new ResponseEntity<>(allContacts,HttpStatus.OK);
}


@GetMapping("/contact/{cid}")
ResponseEntity<Contact> getContact(@PathVariable int cid) {
	Contact contact=Service.getContact(cid);
	return new ResponseEntity<>(contact,HttpStatus.OK);
	}

	
@SuppressWarnings("unused")
@DeleteMapping("/contact/{cid}")
ResponseEntity<String> deleteContact(@PathVariable int cid) {
	Contact contact=Service.getContact(cid);
	return new ResponseEntity<>("",HttpStatus.OK);
}
}






