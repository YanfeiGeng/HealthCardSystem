package com.hcs.util;

public class StringUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
