package com.msd.api;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
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
		return repo.findAll();
	}

	@GetMapping("/{event_Id}")
	public Optional<Events> getEventById(@PathVariable("event_Id") long id) {
		return repo.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<?> addEvent(@RequestBody Events newEvent, UriComponentsBuilder uri) {
		if (newEvent.getId() != 0 || newEvent.getCode() == null || newEvent.getTitle() == null || newEvent.getDescription() == null) {
			// Reject and we'll assign the event id
			return ResponseEntity.badRequest().build();
		}
		newEvent = repo.save(newEvent);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newEvent.getId()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		return response;
	}

	@PutMapping("/{event_Id}")
	public ResponseEntity<?> putEvent(
			@RequestBody Events newEvent,
			@PathVariable("event_Id") long eventId) 
	{
		if (newEvent.getId() != eventId || newEvent.getCode() == null || newEvent.getTitle() == null || newEvent.getDescription() == null) {
			return ResponseEntity.badRequest().build();
		}
		newEvent = repo.save(newEvent);
		return ResponseEntity.ok().build();
	}	
	
	@DeleteMapping("/{event_Id}")
	public ResponseEntity<?> deleteEventById(@PathVariable("event_Id") long id) {
		repo.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
