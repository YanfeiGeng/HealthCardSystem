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
	
	private BasicInfoDao basicDao = new BasicInfoDao();
	
	private String searchSQL = "SELECT resultID, generalInfo, shParam1, shParam2, shParam3, shParam4, shParam5, shParam6, shParam7, rayResult, heartResult, checkResult, basicInfoId FROM health_check_result"
			+ " WHERE generalInfo LIKE ? OR shParam1 LIKE ? OR shParam2 LIKE ? OR shParam3 LIKE ? OR shParam4 LIKE ? OR shParam5 LIKE ? OR shParam6 LIKE ? OR shParam7 LIKE ? OR rayResult LIKE ? OR heartResult LIKE ? OR checkResult LIKE ?";
	
	/**
	 * Search check result with condition
	 * @return
	 */
	public List<CheckResultBean> searchCheckResult(String condition){
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet result = null;
		List<CheckResultBean> checkResultList = new ArrayList<CheckResultBean>();
		try {
			conn = DBHelper.getConnection();
			if(condition == null || "".equals(condition)){
				condition = "NULL";
			}
			state = conn.prepareStatement(searchSQL);
			state.setString(1, "%" + condition + "%");
			state.setString(2, "%" + condition + "%");
			state.setString(3, "%" + condition + "%");
			state.setString(4, "%" + condition + "%");
			state.setString(5, "%" + condition + "%");
			state.setString(6, "%" + condition + "%");
			state.setString(7, "%" + condition + "%");
			state.setString(8, "%" + condition + "%");
			state.setString(9, "%" + condition + "%");
			state.setString(10, "%" + condition + "%");
			state.setString(11, "%" + condition + "%");
			result = state.executeQuery();
			while(result.next()){
				CheckResultBean checkResultB = new CheckResultBean();
				checkResultB.setResultID(String.valueOf(result.getInt(1)));
				checkResultB.setGeneralInfo(result.getString(2));
				checkResultB.setShParam1(result.getString(3));
				checkResultB.setShParam2(result.getString(4));
				checkResultB.setShParam3(result.getString(5));
				checkResultB.setShParam4(result.getString(6));
				checkResultB.setShParam5(result.getString(7));
				checkResultB.setShParam6(result.getString(8));
				checkResultB.setShParam7(result.getString(9));
				checkResultB.setRayResult(result.getString(10));
				checkResultB.setHeartResult(result.getString(11));
				checkResultB.setCheckResult(result.getString(12));
				checkResultB.setReferedBasicInfo(basicDao.getHealthCardRecordById(result.getString(13)));
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
	
	private String getRecordListSQL = "SELECT resultID, generalInfo, shParam1, shParam2, shParam3, shParam4, shParam5, shParam6, shParam7, rayResult, heartResult, checkResult, basicInfoId FROM health_check_result";
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
				checkResultB.setResultID(String.valueOf(result.getInt(1)));
				checkResultB.setGeneralInfo(result.getString(2));
				checkResultB.setShParam1(result.getString(3));
				checkResultB.setShParam2(result.getString(4));
				checkResultB.setShParam3(result.getString(5));
				checkResultB.setShParam4(result.getString(6));
				checkResultB.setShParam5(result.getString(7));
				checkResultB.setShParam6(result.getString(8));
				checkResultB.setShParam7(result.getString(9));
				checkResultB.setRayResult(result.getString(10));
				checkResultB.setHeartResult(result.getString(11));
				checkResultB.setCheckResult(result.getString(12));
				checkResultB.setReferedBasicInfo(basicDao.getHealthCardRecordById(result.getString(13)));
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
	
	private String addOneRecordSQL = "INSERT INTO health_check_result(generalInfo, shParam1, shParam2, shParam3, shParam4, shParam5, shParam6, shParam7, rayResult, heartResult, checkResult, basicInfoId) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
			state.setString(1, checkResult.getGeneralInfo());
			state.setString(2, checkResult.getShParam1());
			state.setString(3, checkResult.getShParam2());
			state.setString(4, checkResult.getShParam3());
			state.setString(5, checkResult.getShParam4());
			state.setString(6, checkResult.getShParam5());
			state.setString(7, checkResult.getShParam6());
			state.setString(8, checkResult.getShParam7());
			state.setString(9, checkResult.getRayResult());
			state.setString(10, checkResult.getHeartResult());
			state.setString(11, checkResult.getCheckResult());
			state.setString(12, checkResult.getReferedBasicInfo().getId());
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
	
	private String deleteOneRecordSQL = "DELETE FROM health_check_result WHERE resultid = ?";
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
			state.setString(1, checkResult.getGeneralInfo());
			state.setString(2, checkResult.getShParam1());
			state.setString(3, checkResult.getShParam2());
			state.setString(4, checkResult.getShParam3());
			state.setString(5, checkResult.getShParam4());
			state.setString(6, checkResult.getShParam5());
			state.setString(7, checkResult.getShParam6());
			state.setString(8, checkResult.getShParam7());
			state.setString(9, checkResult.getRayResult());
			state.setString(10, checkResult.getHeartResult());
			state.setString(11, checkResult.getCheckResult());
			state.setInt(12, Integer.valueOf(checkResult.getResultID()));
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
	
	private String getOneRecordSQL = "SELECT resultID, generalInfo, shParam1, shParam2, shParam3, shParam4, shParam5, shParam6, shParam7, rayResult, heartResult, checkResult, basicInfoId FROM health_check_result WHERE resultID = ?";
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
			state.setInt(1, Integer.parseInt(id));
			result = state.executeQuery();
			while(result.next()){
				checkResultB.setResultID(String.valueOf(result.getInt(1)));
				checkResultB.setGeneralInfo(result.getString(2));
				checkResultB.setShParam1(result.getString(3));
				checkResultB.setShParam2(result.getString(4));
				checkResultB.setShParam3(result.getString(5));
				checkResultB.setShParam4(result.getString(6));
				checkResultB.setShParam5(result.getString(7));
				checkResultB.setShParam6(result.getString(8));
				checkResultB.setShParam7(result.getString(9));
				checkResultB.setRayResult(result.getString(10));
				checkResultB.setHeartResult(result.getString(11));
				checkResultB.setCheckResult(result.getString(12));
				checkResultB.setReferedBasicInfo(basicDao.getHealthCardRecordById(result.getString(13)));
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
