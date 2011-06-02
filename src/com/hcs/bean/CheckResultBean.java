package com.hcs.bean;

public class CheckResultBean {
	
	public CheckResultBean() {
		super();
	}

	public CheckResultBean(String generalInfo, String shParam1,
			String shParam2, String shParam3, String shParam4, String shParam5,
			String shParam6, String shParam7, String rayResult,
			String heartResult, String checkResult) {
		super();
		this.generalInfo = generalInfo;
		this.shParam1 = shParam1;
		this.shParam2 = shParam2;
		this.shParam3 = shParam3;
		this.shParam4 = shParam4;
		this.shParam5 = shParam5;
		this.shParam6 = shParam6;
		this.shParam7 = shParam7;
		this.rayResult = rayResult;
		this.heartResult = heartResult;
		this.checkResult = checkResult;
	}

	private String resultID;

	private String generalInfo;
	
	private String shParam1;

	private String shParam2;
	
	private String shParam3;
	
	private String shParam4;
	
	private String shParam5;
	
	private String shParam6;
	
	private String shParam7;
	
	private String rayResult;
	
	private String heartResult;
	
	private String checkResult;
	
	private BasicInformation referedBasicInfo;
	
	public BasicInformation getReferedBasicInfo() {
		return referedBasicInfo;
	}

	public void setReferedBasicInfo(BasicInformation referedBasicInfo) {
		this.referedBasicInfo = referedBasicInfo;
	}

	public String getResultID() {
		return resultID;
	}

	public void setResultID(String resultID) {
		this.resultID = resultID;
	}

	public String getGeneralInfo() {
		return generalInfo;
	}

	public void setGeneralInfo(String generalInfo) {
		this.generalInfo = generalInfo;
	}

	public String getShParam1() {
		return shParam1;
	}

	public void setShParam1(String shParam1) {
		this.shParam1 = shParam1;
	}

	public String getShParam2() {
		return shParam2;
	}

	public void setShParam2(String shParam2) {
		this.shParam2 = shParam2;
	}

	public String getShParam3() {
		return shParam3;
	}

	public void setShParam3(String shParam3) {
		this.shParam3 = shParam3;
	}

	public String getShParam4() {
		return shParam4;
	}

	public void setShParam4(String shParam4) {
		this.shParam4 = shParam4;
	}

	public String getShParam5() {
		return shParam5;
	}

	public void setShParam5(String shParam5) {
		this.shParam5 = shParam5;
	}

	public String getShParam6() {
		return shParam6;
	}

	public void setShParam6(String shParam6) {
		this.shParam6 = shParam6;
	}

	public String getShParam7() {
		return shParam7;
	}

	public void setShParam7(String shParam7) {
		this.shParam7 = shParam7;
	}

	public String getRayResult() {
		return rayResult;
	}

	public void setRayResult(String rayResult) {
		this.rayResult = rayResult;
	}

	public String getHeartResult() {
		return heartResult;
	}

	public void setHeartResult(String heartResult) {
		this.heartResult = heartResult;
	}

	public String getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}

	public static void main(String[] args) {
		
	}

	@Override
	public String toString() {
		return "[体检报告ID=" + resultID + ", 一般="
				+ generalInfo + ", 检查=" + shParam1 + ", X照射="
				+ rayResult + ", 心电图=" + heartResult + ", 检验="
				+ checkResult + "]";
	}

}
