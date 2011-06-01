package com.hcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hcs.bean.Role;
import com.hcs.dao.util.DBHelper;

public class RoleDao {
	
	private String getRoleSQL = "SELECT id, rolename, rolelevel FROM health_role WHERE id = ?;";
	
	/**
	 * Get role object via ID
	 * @param id
	 * @return
	 */
	public Role getRoleById(String id){
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet result = null;
		Role role = new Role();
		try {
			conn = DBHelper.getConnection();
			state = conn.prepareStatement(getRoleSQL);
			state.setInt(1, Integer.parseInt(id));
			result = state.executeQuery();
			while(result.next()){
				role.setId(result.getString("id"));
				role.setRoleName(result.getString("rolename"));
				role.setRoleLevel(result.getString("rolelevel"));
			}
			return role;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				result.close();
				state.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	private String addRoleSQL = "INSERT INTO health_role(rolename, rolelevel) VALUES(?, ?)";
	/**
	 * Add role into DB
	 * @param role
	 * @return
	 */
	public boolean addRole(Role role){
		Connection conn = null;
		PreparedStatement state = null;
		try {
			conn = DBHelper.getConnection();
			state = conn.prepareStatement(addRoleSQL);
			state.setString(1, role.getRoleName());
			state.setString(2, role.getRoleLevel());
			state.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				state.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	private String listRoles = "SELECT id, rolename, rolelevel FROM health_role;";
	
	/**
	 * List all roles
	 * @return
	 */
	public List<Role> listRoles(){
		List<Role> roles = new ArrayList<Role>();
		Connection conn = null;
		Statement state = null;
		ResultSet result = null;
		try {
			conn = DBHelper.getConnection();
			state = conn.createStatement();
			result = state.executeQuery(listRoles);
			while(result.next()){
				Role role = new Role();
				role.setId(result.getString("id"));
				role.setRoleName(result.getString("rolename"));
				role.setRoleLevel(result.getString("rolelevel"));
				roles.add(role);
			}
			return roles;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				result.close();
				state.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	private String updateRole = "UPDATE health_role SET rolename = ?, rolelevel = ? WHERE id = ?;";
	
	/**
	 * Update role information 
	 * @param role
	 */
	public void updateRole(Role role){
		Connection conn = null;
		PreparedStatement state = null;
		try {
			conn = DBHelper.getConnection();
			state = conn.prepareStatement(updateRole);
			state.setString(1, role.getRoleName());
			state.setString(2, role.getRoleLevel());
			state.setInt(3, Integer.parseInt(role.getId()));
			state.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				state.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private String deleteSQL = "DELETE FROM health_role WHERE id = ?;";
	
	/**
	 * Delete role from database
	 * @param role
	 */
	public void deleteRole(Role role){
		Connection conn = null;
		PreparedStatement state = null;
		try {
			conn = DBHelper.getConnection();
			state = conn.prepareStatement(deleteSQL);
			state.setInt(1, Integer.parseInt(role.getId()));
			state.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				state.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
