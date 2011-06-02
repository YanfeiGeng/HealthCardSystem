package com.hcs.util;

import com.hcs.bean.AtmoRole;

public class StringUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Used for role
	public static String convertRoleIdToString(String roles){
		StringBuffer realRole = new StringBuffer();
		String[] ids = roles.split(",");
		for(int i = 0; i < ids.length; i++){
			int id = Integer.parseInt(ids[i]);
			for(AtmoRole role : RoleDefinition.roles){
				if(id == role.getLevel()){
					realRole.append(role.getName());
				}
			}
			if(i <= ids.length -1){
				realRole.append(",");
			}
		}
		return realRole.toString();
	}
	
	public static int[] convertRoleLevelToIntArray(String roles){
		String[] roleLevels = roles.split(",");
		int[] levels = new int[roleLevels.length];
		for(int i = 0; i < levels.length; i++){
			levels[i] = Integer.parseInt(roleLevels[i]);
		}
		return levels;
	}
	
	public static String filterGamaAndEnter(String source){
		if(null == source || "".equals(source)){
			return "";
		}
		return source.replaceAll(",", "[GAMA]").replaceAll("\r\n", "ENTER");
	}
	
	public static String backGamaAndEnter(String source){
		if(null == source || "".equals(source)){
			return "";
		}
		return source.replaceAll("[GAMA]", ",").replaceAll("ENTER", "\r\n");
	}

}
