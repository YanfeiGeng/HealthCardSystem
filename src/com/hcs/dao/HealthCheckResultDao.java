package com.hcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hcs.bean.CheckResultBean;
import com.hcs.dao.util.DBHelper;

public class HealthCheckResultDao {
	
	private String getRecordListSQL = "SELECT resultID, generalInfo, shParam1, shParam2, shParam3, shParam4, shParam5, shParam6, shParam7, rayResult, heartResult, checkResult FROM health_check_result";
	/**
	 * Return the health check records result
	 * @return
	 */
	public List<CheckResultBean> getCheckResultRecords(){
		Connection conn = null;
		Statement state = null;
		ResultSet result = null;
		List<CheckResultBean> checkResultList = new ArrayList<CheckResultBean>();
		try {
			conn = DBHelper.getConnection();
			state = conn.createStatement();
			result = state.executeQuery(getRecordListSQL);
			while(result.next()){
				CheckResultBean checkResultB = new CheckResultBean();
				checkResultB.setResultID(String.valueOf(result.getInt(0)));
				checkResultB.setGeneralInfo(result.getString(1));
				checkResultB.setShParam1(result.getString(2));
				checkResultB.setShParam2(result.getString(3));
				checkResultB.setShParam3(result.getString(4));
				checkResultB.setShParam4(result.getString(5));
				checkResultB.setShParam5(result.getString(6));
				checkResultB.setShParam6(result.getString(7));
				checkResultB.setShParam7(result.getString(8));
				checkResultB.setRayResult(result.getString(9));
				checkResultB.setHeartResult(result.getString(10));
				checkResultB.setCheckResult(result.getString(11));
				checkResultList.add(checkResultB);
			}
			return checkResultList;
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
	
	private String addOneRecordSQL = "INSERT INTO health_check_result VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	/**
	 * Add one check result record into DB
	 * @param checkResult
	 * @return
	 */
	public boolean addCheckResultRecord(CheckResultBean checkResult){
		Connection conn = null;
		PreparedStatement state = null;
		try {
			conn = DBHelper.getConnection();
			state = conn.prepareStatement(addOneRecordSQL);
			state.setString(0, checkResult.getGeneralInfo());
			state.setString(1, checkResult.getShParam1());
			state.setString(2, checkResult.getShParam2());
			state.setString(3, checkResult.getShParam3());
			state.setString(4, checkResult.getShParam4());
			state.setString(5, checkResult.getShParam5());
			state.setString(6, checkResult.getShParam6());
			state.setString(7, checkResult.getShParam7());
			state.setString(8, checkResult.getRayResult());
			state.setString(9, checkResult.getHeartResult());
			state.setString(10, checkResult.getCheckResult());
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
	
	private String deleteOneRecordSQL = "DELETE FROM health_check_result WHERE id = ?";
	/**
	 * Delete one health check record
	 * @param id
	 * @return
	 */
	public boolean deleteCheckResultRecord(String id) {
		Connection conn = null;
		PreparedStatement state = null;
		try {
			conn = DBHelper.getConnection();
			state = conn.prepareStatement(deleteOneRecordSQL);
			state.setString(0, id);
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
	
	private String updateOneRecordSQL = "UPDATE health_check_result SET generalInfo = ?, shParam1 = ?, shParam2 = ?, shParam3 = ?, shParam4 = ?, shParam5 = ?, shParam6 = ?, shParam7 = ?, rayResult = ?, heartResult = ?, checkResult = ? WHERE resultID = ?";
	/**
	 * Update one specific  record with corresponding information
	 * @param checkResult
	 */
	public void updateCheckResultRecord(CheckResultBean checkResult){
		Connection conn = null;
		PreparedStatement state = null;
		try {
			conn = DBHelper.getConnection();
			state = conn.prepareStatement(updateOneRecordSQL);
			state.setString(0, checkResult.getGeneralInfo());
			state.setString(1, checkResult.getShParam1());
			state.setString(2, checkResult.getShParam2());
			state.setString(3, checkResult.getShParam3());
			state.setString(4, checkResult.getShParam4());
			state.setString(5, checkResult.getShParam5());
			state.setString(6, checkResult.getShParam6());
			state.setString(7, checkResult.getShParam7());
			state.setString(8, checkResult.getRayResult());
			state.setString(9, checkResult.getHeartResult());
			state.setString(10, checkResult.getCheckResult());
			state.setInt(10, Integer.valueOf(checkResult.getResultID()));
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
	
	private String getOneRecordSQL = "SELECT resultID, generalInfo, shParam1, shParam2, shParam3, shParam4, shParam5, shParam6, shParam7, rayResult, heartResult, checkResult FROM health_check_result WHERE resultID = ?";
	/**
	 * Retrieve one of the check result record with provided ID
	 * @param id
	 * @return
	 */
	public CheckResultBean getCheckResult(String id){
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet result = null;
		CheckResultBean checkResultB = new CheckResultBean();
		try {
			conn = DBHelper.getConnection();
			state = conn.prepareStatement(getOneRecordSQL);
			state.setInt(0, Integer.parseInt(id));
			result = state.executeQuery();
			while(result.next()){
				checkResultB.setResultID(String.valueOf(result.getInt(0)));
				checkResultB.setGeneralInfo(result.getString(1));
				checkResultB.setShParam1(result.getString(2));
				checkResultB.setShParam2(result.getString(3));
				checkResultB.setShParam3(result.getString(4));
				checkResultB.setShParam4(result.getString(5));
				checkResultB.setShParam5(result.getString(6));
				checkResultB.setShParam6(result.getString(7));
				checkResultB.setShParam7(result.getString(8));
				checkResultB.setRayResult(result.getString(9));
				checkResultB.setHeartResult(result.getString(10));
				checkResultB.setCheckResult(result.getString(11));
			}
			return checkResultB;
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
}
