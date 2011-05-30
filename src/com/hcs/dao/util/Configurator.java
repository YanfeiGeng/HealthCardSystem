package com.hcs.dao.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class Configurator{
	
	private static Properties prop = new Properties();
	
	public static String DB_SERVER = "db.server",
		DB_USERNAME = "db.username",
		DB_PASSWORD = "db.password",
		DB_INSTANCE = "db.instance";
	
	public Configurator() throws FileNotFoundException, IOException{
		prop.load(new FileInputStream(new File("init.properties")));
	}
	
	public Enumeration<?> getConfigNames(){
		return prop.propertyNames();
	}
	
	public static String get(String key){
		String value = prop.getProperty(key);
		return value;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		Configurator configurator = new Configurator();
		System.out.println(configurator.get(Configurator.DB_SERVER));
		System.out.println(configurator.get(Configurator.DB_USERNAME));
		System.out.println(configurator.get(Configurator.DB_PASSWORD));
		System.out.println(configurator.get(Configurator.DB_INSTANCE));
	}
	
}