package com.hcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hcs.bean.User;
import com.hcs.dao.util.DBHelper;

public class UserDao {
	
	private RoleDao roleDao = new RoleDao();
	
	private String listUserSQL = "SELECT id, name, passwd, roleId FROM health_user";
	
	/**
	 * List all users 
	 * @return
	 */
	public List<User> listAllUser(){
		List<User> users = new ArrayList<User>();
		Connection conn = null;
		Statement state = null;
		ResultSet result = null;
		try {
			conn = DBHelper.getConnection();
			state = conn.createStatement();
			result = state.executeQuery(listUserSQL);
			User resultUser = new User();
			if(result.next()){
				resultUser.setId(result.getString(1));
				resultUser.setName(result.getString(2));
				resultUser.setPassword(result.getString(3));
				resultUser.setRole(roleDao.getRoleById(result.getString("roleid")));
				users.add(resultUser);
			}
			return users;
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
	
	private String authSQL = "SELECT id, name, passwd, roleid FROM health_user WHERE name = ? AND passwd = ?;";
	
	/**
	 * Validate user name and password
	 * @param user
	 * @return
	 */
	public User authUser(User user){
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet result = null;
		try {
			conn = DBHelper.getConnection();
			state = conn.prepareStatement(authSQL);
			state.setString(1, user.getName());
			state.setString(2, user.getPassword());
			result = state.executeQuery();
			User resultUser = new User();
			if(result.next()){
				resultUser.setId(result.getString(1));
				resultUser.setName(result.getString(2));
				resultUser.setPassword(result.getString(3));
				resultUser.setRole(roleDao.getRoleById(result.getString("roleid")));
			}
			return resultUser;
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
	
	private String insertSQL = "INSERT INTO health_user(name, passwd, roleid) VALUES(?, ?, ?)";
	
	/**
	 * Add user into DB
	 * @param user
	 * @return
	 */
	public boolean addUser(User user){
		Connection conn = null;
		PreparedStatement state = null;
		try {
			conn = DBHelper.getConnection();
			state = conn.prepareStatement(insertSQL);
			state.setString(1, user.getName());
			state.setString(2, user.getPassword());
			state.setString(3, user.getRole().getId());
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
		return false;
	}
	
	private String updateSQL = "UPDATE health_user SET passwd = ? WHERE id = ?;";
	
	/**
	 * 
	 * @return
	 */
	public boolean changePasswd(User user){
		Connection conn = null;
		PreparedStatement state = null;
		try {
			conn = DBHelper.getConnection();
			state = conn.prepareStatement(updateSQL);
			state.setString(1, user.getPassword());
			state.setString(2, user.getId());
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
		return false;
	}
	
	private String getUserSQL = "SELECT id, name, passwd, roleId FROM health_user WHERE id = ?;";
	
	/**
	 * Get user by id
	 * @param id
	 * @return
	 */
	public User getUserById(String id){
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet result = null;
		try {
			conn = DBHelper.getConnection();
			state = conn.prepareStatement(getUserSQL);
			state.setString(1, id);
			result = state.executeQuery();
			User resultUser = new User();
			if(result.next()){
				resultUser.setId(result.getString(1));
				resultUser.setName(result.getString(2));
				resultUser.setPassword(result.getString(3));
				resultUser.setRole(roleDao.getRoleById(result.getString("roleid")));
			}
			return resultUser;
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
	
	private String delSQL = "DELETE FROM health_user WHERE id = ?;";
	
	/**
	 * Delete one user from DB by ID
	 * @param id
	 * @return
	 */
	public boolean deleteUser(String id){
		Connection conn = null;
		PreparedStatement state = null;
		try {
			conn = DBHelper.getConnection();
			state = conn.prepareStatement(delSQL);
			state.setString(1, id);
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
