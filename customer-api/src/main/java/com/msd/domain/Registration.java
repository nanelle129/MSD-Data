package com.msd.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REGISTRATION")
public class Registration {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	
	// map a registration to an event and customer
	@Column(name="EVENT_ID")
	String eventId;
	
	@Column(name="CUSTOMER_ID")
	String customerId;
	
	Date registrationDate;
	String notes;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEvent_Id() {
		return eventId;
	}

	public void setEvent_Id(String eventId) {
		this.eventId = eventId;
	}

	public String getCustomer_Id() {
		return customerId;
	}

	public void setCustomer_Id(String customerId) {
		this.customerId = customerId;
	}

	public Date getRegistration_Date() {
		return registrationDate;
	}

	public void setRegistration_Date(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
	
	
	
	

}
