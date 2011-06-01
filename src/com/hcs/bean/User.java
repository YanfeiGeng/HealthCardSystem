package com.hcs.bean;

public class User {

	public User(String name, String password, Role role) {
		super();
		this.name = name;
		this.password = password;
		this.role = role;
	}

	private String id;
	
	private String name;
	
	private String password;
	
	public User() {
		super();
	}

	private Role role;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
