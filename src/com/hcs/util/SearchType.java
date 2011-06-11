package com.hcs.util;

import java.util.Vector;

public class SearchType {
	
	public static final String USER_BASIC = "健康证资料";
	
	public static final String HEALTH_CHECK = "体检结果";
	
	public static final String AUTH_USER = "管理人员";
	
	public static Vector<String> allTypes = null;
	
	static {
		allTypes = new Vector<String>();
		allTypes.add(USER_BASIC);
		allTypes.add(HEALTH_CHECK);
		allTypes.add(AUTH_USER);
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
