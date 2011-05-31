package com.hcs.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hcs.bean.BasicInformation;
import com.hcs.dao.util.DBHelper;

public class BasicInfoDao {

	
	private String getListSQL = "SELECT id, name, sex, age, birthday, address, currentaddress, checkreport FROM health_basic_info;";
	/**
	 * Get all basic health info records
	 * @return
	 */
	public List<BasicInformation> getHealthCardRecords(){
		Connection conn = null;
		Statement state = null;
		ResultSet result = null;
		List<BasicInformation> basicInfoList = new ArrayList<BasicInformation>();
		try {
			conn = DBHelper.getConnection();
			state = conn.createStatement();
			result = state.executeQuery(getListSQL);
			while(result.next()){
				BasicInformation basicInfo = new BasicInformation();
				int resultId = result.getInt(1);
				String name = result.getString(2);
				String sex = result.getString(3);
				String age = result.getString(4);
				Date birthday = result.getDate(5);
				String address = result.getString(6);
				String currentaddress = result.getString(7);
				String checkreport = result.getString(8);
				basicInfo.setId(String.valueOf(resultId));
				basicInfo.setName(name);
				basicInfo.setSex(sex);
				basicInfo.setAge(age);
				basicInfo.setBirthday(birthday);
				basicInfo.setAddress(address);
				basicInfo.setCurrentAddress(currentaddress);
				basicInfo.setCheckReport(checkreport);
				basicInfoList.add(basicInfo);
			}
			return basicInfoList;
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
	
	private String getHealthSQL = "SELECT id, name, sex, age, birthday, address, currentaddress, checkreport FROM health_basic_info WHERE id = ?;";
	/**
	 * Get all basic health info records
	 * @return
	 */
	public BasicInformation getHealthCardRecordById(String id){
		BasicInformation basicInfo = new BasicInformation();
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet result = null;
		try {
			conn = DBHelper.getConnection();
			state = conn.prepareStatement(getHealthSQL);
			state.setInt(1, Integer.parseInt(id));
			result = state.executeQuery();
			while(result.next()){
				int resultId = result.getInt(1);
				String name = result.getString(2);
				String sex = result.getString(3);
				String age = result.getString(4);
				Date birthday = result.getDate(5);
				String address = result.getString(6);
				String currentaddress = result.getString(7);
				String checkreport = result.getString(8);
				basicInfo.setId(String.valueOf(resultId));
				basicInfo.setName(name);
				basicInfo.setSex(sex);
				basicInfo.setAge(age);
				basicInfo.setBirthday(birthday);
				basicInfo.setAddress(address);
				basicInfo.setCurrentAddress(currentaddress);
				basicInfo.setCheckReport(checkreport);
			}
			return basicInfo;
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
	
	private String addInfoSQL = "INSERT INTO health_basic_info(name, sex, age, birthday, address, currentaddress, checkreport) VALUES(?, ?, ?, ?, ?, ?, ?)";
	/**
	 * Add one health basic information record into DB 
	 * @param value
	 * @return
	 */
	public boolean addHealthCardRecord(BasicInformation basicInfo){
		Connection conn = null;
		PreparedStatement state = null;
		try {
			conn = DBHelper.getConnection();
			state = conn.prepareStatement(addInfoSQL);
			state.setString(1, basicInfo.getName());
			state.setString(2, basicInfo.getSex());
			state.setString(3, basicInfo.getAge());
			state.setDate(4, basicInfo.getBirthday());
			state.setString(5, basicInfo.getAddress());
			state.setString(6, basicInfo.getCurrentAddress());
			state.setString(7, basicInfo.getCheckReport());
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
	
	private String delInfoSQL = "DELETE FROM health_basic_info WHERE id = ?;";
	/**
	 * Delete one health info record
	 * @param id
	 * @return
	 */
	public boolean deleteHealthCardRecord(String id) {
		Connection conn = null;
		PreparedStatement state = null;
		try {
			conn = DBHelper.getConnection();
			state = conn.prepareStatement(delInfoSQL);
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
	
	private String updateInfoSQL = "UPDATE health_basic_info SET name = ?, sex = ?, age = ?, birthday = ?, address = ?, currentaddress = ?, checkreport = ? WHERE id = ?;";
	/**
	 * Update one record on health information record
	 * @param id
	 * @return
	 */
	public boolean updateHealthCardRecord(BasicInformation basicInfo) {
		Connection conn = null;
		PreparedStatement state = null;
		try {
			conn = DBHelper.getConnection();
			state = conn.prepareStatement(updateInfoSQL);
			state.setString(1, basicInfo.getName());
			state.setString(2, basicInfo.getSex());
			state.setString(3, basicInfo.getAge());
			state.setDate(4, basicInfo.getBirthday());
			state.setString(5, basicInfo.getAddress());
			state.setString(6, basicInfo.getCurrentAddress());
			state.setString(7, basicInfo.getCheckReport());
			state.setInt(8, Integer.parseInt(basicInfo.getId()));
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
	
}
