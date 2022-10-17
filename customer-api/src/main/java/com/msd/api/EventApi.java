package com.msd.api;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.msd.domain.Events;
import com.msd.repository.EventRepository;

@RestController
@RequestMapping("/events")
public class EventApi {
	@Autowired
	EventRepository repo;
	
	@GetMapping
	public Iterable<Events> getAll() {
		return repo.findall();
	}
	
	@GetMapping("{eventId}")
	public Optional<Events> getEventById(@PathVariable("eventId")
	long id) {
		return repo.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<?> addEvent(@RequestBody Events newEvent,
			UriComponentsBuilder uri) {
		if (newEvent.getId() != 0) {
			return ResponseEntity.badRequest().build();
		}
		newEvent=repo.save(newEvent);
		URI location =ServletUriComponentBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(newEvent.getId()).toUri();
		ResponseEntity<?> response=ResponseEntity.created(location).build();
		return response;
	}
	
	@PutMapping
	public ResponseEntity<?> putEvent(@RequestBody Events newEvent,
			@PathVariable("eventId") long eventId) {
		if (newEvent.getId() != eventId) {
			return ResponseEntity.badRequest().build();
		}
		newEvent=repo.save(newEvent);
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{eventId}")
	public ResponseEntity<?> deleteEventById(@PathVariable("eventId") long id) {
		return null;
	}
	
	/*ArrayList<Events> eventList = new ArrayList<Events>();
	
	public EventApi() {
		Events e1 = new Events(1, "CNF001", "All-Java Conference", "Lectures and exhibits covering all Java topics");
		Events e2 = new Events(2, "WKS002", "All-Java Conference", "Hands-on Spring Boot Workshop");
		Events e3 = new Events(3, "TRN001", "All-Java Conference", "Five day introductory training in Angular");
		Events e4 = new Events(4, "RNR004", "Rock n Roll Concert", "BAH Employees RocknRoll Concert");
	
		eventList.add(e1);
		eventList.add(e2);
		eventList.add(e3);
		eventList.add(e4);
	}
	
	@GetMapping
	public Collection<Events> getAll() {
		return this.eventList;
	}
	
	@GetMapping("/{eventId}")
	public Events getCustomerById(@PathVariable("eventId") long id) {
		
		Events event = null;
		for (int i = 0; i < eventList.size(); i++) {
			if (eventList.get(i).getId() == id) {
				event = eventList.get(i);
			}
		}
		return event;
	}*/
}
