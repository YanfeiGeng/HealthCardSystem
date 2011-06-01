package com.hcs.util;

import java.util.Vector;

import com.hcs.bean.AtmoRole;

public class RoleDefinition {
	
	public static final int BASIC_INFO = 0;
	
	public static final int HEALTH_CHECK = 1;
	
	public static final int HEALTH_STATICS = 2;
	
	public static final int USER_ROLE = 3;
	
	public static Vector<AtmoRole> roles;
	
	static {
		roles = new Vector<AtmoRole>();
		roles.add(new AtmoRole(RoleDefinition.BASIC_INFO, "人员基本信息管理"));
		roles.add(new AtmoRole(RoleDefinition.HEALTH_CHECK, "体检结果管理"));
		roles.add(new AtmoRole(RoleDefinition.HEALTH_STATICS, "统计搜索信息管理"));
		roles.add(new AtmoRole(RoleDefinition.USER_ROLE, "用户权限管理"));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
