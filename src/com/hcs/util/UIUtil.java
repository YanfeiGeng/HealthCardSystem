package com.hcs.util;

import javax.swing.JOptionPane;

public class UIUtil {
	
	//Check value can not be null
	public static boolean isEmpty(String label, Object obj){
		if(obj == null || (obj != null && "".equals(obj.toString()))) {
			JOptionPane.showMessageDialog(null, "\"" + label + "\" ����Ϊ��", "����", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		UIUtil.isEmpty("����", null);
	}

}
