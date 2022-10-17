package com.msd.api;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msd.domain.Events;

@RestController
@RequestMapping("/events")
public class EventApi {
	ArrayList<Events> eventList = new ArrayList<Events>();
	
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
	}
}
