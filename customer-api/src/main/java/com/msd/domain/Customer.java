package com.msd.domain;

public class Customer {
	long id;
	String name;
	String password;
	String email;
	
	
	

	public Customer() {
		super();
	}
	
	public String toJSON() {
		return "{\"id:\"" +id + ",\"name:\"" + name + ",\"password:\""  
				+  ",\"email:\"" + email + "}";
	}

	public Customer(long id, String name, String password, String email) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
