package com.msd.api;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
public class RegistrationApi {

	ArrayList<Registration> registrationList = newArrayList<Registration>();
	
	@SuppressWarnings("deprecation")
	public RegistrationAPI() {
		Registration r1 = new Registration(1L, "1", "2", new Date(), "please email me the event details");
		Registration r2 = new Registration(2L, "2", "2", new Date(), "send transportation and hotel booking");
		Registration r3 = new Registration(3L, "3", "3", new Date(), "defer payments for a week");
		
		registrationList.add(r1);
		registrationList.add(r2);
		registrationList.add(r3);
	}
	
	@GetMapping
	public Collection<Registration> getAll() {
		return this.registrationList;
	}
	
	@GetMapping("/{registrationId}")
	public Registration getCustomerById(@PathVariable("registrationId") long id ) {
		Registration registration = null;
		for (int i = 0; i < registrationList.size(); i++) {
			if (registrationList.get(i).getId() == id) {
				registration = registrationList.get(i);
			}
		}
		return registration;
	}
	//@Autowired
	//RegistrationRepository repo;
	
	//@GetMapping
	//public Iterable<Registration> getAll() {
	//	return repo.findAll();
	//}
	
	//@GetMapping("/{RegStatus}")
}
