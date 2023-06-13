package com.contactMS;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class contactServiceImpl implements contactService {

	List<contacts> con=List.of(
			new contacts(21L, "nk", "nitin1860@gmail.com", 11L),
			new contacts(22L, "pk", "kp@gmail.com",11L),
			new contacts(23L,"ck","ml@gmail.com",12L),
			new contacts(24L, "hello", "hello@gmailcom", 13L)
			
			);
	
	
	@Override
	public List<contacts> getContactOfEmployee(Long id) {
		
		return con.stream().filter(contacts->contacts.getId().equals(id)).collect(Collectors.toList());
	}

}
