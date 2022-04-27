package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import in.ashokit.entity.Contact;
import in.ashokit.repository.ContactRepository;

public abstract  class ContactServiceImpl implements ContactService {
	@Autowired(required=true)
private ContactRepository repo;

@Override
public String upsert(Contact contact){
	@SuppressWarnings("unused")
	Contact save=repo.save(contact);
	return "SUCCESS";
}

@Override
public List<Contact> getAllContacts() {
	 repo.findAll();
	return null;
	}

@Override
public Contact getContact(int cid) {
	Optional<Contact>findById=repo.findById(cid);
	if(findById.isPresent()) {
		return findById.get();	
	}
	return null;
}

@Override
public String deleteContact(int cid) {
	repo.deleteById(cid);
	return "SUCCESS";
}


}

	


