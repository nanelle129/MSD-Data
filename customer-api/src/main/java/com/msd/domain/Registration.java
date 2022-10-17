package com.msd.domain;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Registration {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	
	// map a registration to an event and customer
	@ManyToOne
	Events event;
	@ManyToOne
	Customer customer;
	
	String eventId;
	String customerId;
	Date registrationDate;
	String notes;
	
	public Registration() {
		// TODO Auto-generated constructor stub
	}

	public Registration(long id, String eventId, String customerId, Date registrationDate, String notes) {
		//super();
		this.id = id;
		this.eventId = eventId;
		this.customerId = customerId;
		this.registrationDate = registrationDate;
		this.notes = notes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
	
	
	
	

}
