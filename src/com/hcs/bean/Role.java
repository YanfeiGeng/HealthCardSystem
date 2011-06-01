package com.hcs.bean;

public class Role {

	public Role() {
		super();
	}

	public Role(String roleName, String roleLevel) {
		super();
		this.roleName = roleName;
		this.roleLevel = roleLevel;
	}

	private String id;
	
	private String roleName;
	
	private String roleLevel;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleLevel() {
		return roleLevel;
	}

	@Override
	public String toString() {
		return this.roleName;
	}

	public void setRoleLevel(String roleLevel) {
		this.roleLevel = roleLevel;
	}
	
}
