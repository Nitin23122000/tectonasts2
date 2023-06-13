package com.contactMS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
public class contactController {

	@Autowired
	private contactService contactService;
	
	@GetMapping("/{id}")
	public List<contacts> getContactOfUser(@PathVariable("id") Long id){
		return this.contactService.getContactOfEmployee(id);
	}
	
}
