package in.ashokit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import in.ashokit.entity.Contact;

public interface ContactService {
	@Autowired(required=true)
	@Bean
	
	String upsert(Contact contact);
	List<Contact> getAllContacts();
	Contact getContact(int cid);
	String deleteContact(int cid) ;
	
	
	
	
	
	
}

		
	
	


