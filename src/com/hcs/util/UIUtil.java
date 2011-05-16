package com.hcs.util;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class UIUtil {
	
	//Check value can not be null
	public static boolean isEmpty(String label, Object obj){
		if(obj == null || (obj != null && "".equals(obj.toString()))) {
			JOptionPane.showMessageDialog(null, "\"" + label + "\" 不能为空", "警告", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}
	
	public static void setInCenter(JFrame UI){
		int width = UI.getWidth();
		int height = UI.getHeight();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		UI.setLocation((screenWidth - width) / 2, (screenHeight - height) / 2);
	}

	public static void main(String[] args) {
		UIUtil.isEmpty("姓名", null);
	}

}
