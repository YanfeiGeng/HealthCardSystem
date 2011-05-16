package com.hcs.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataOperator {
	
	public static void main(String[] args){
		List<String[]> records = new ArrayList<String[]>(DataOperator.getHealthCardRecords());
		for(String[] value : records){
			for(int j = 0; j < value.length; j++){
				System.out.print(value[j]);
				System.out.print(", ");
			}
			System.out.println();
		}
		DataOperator.deleteHealthCardRecord("23123168");
		DataOperator.saveData();
	}
	
	private static List<String[]> records = null;
	
	static {
		records = new ArrayList<String[]>();
		initRecord();
	}
	
	
	
	//Get all records
	public static List<String[]> getHealthCardRecords(){
		return records;
	}
	
	private static void initRecord(){
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("healthCard.txt")));
			String value = reader.readLine();
			while(value != null){
				records.add(changeRecordToArray(value));
				value = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Add new record
	public static boolean addHealthCardRecord(String[] value){
		records.add(value);
		return true;
	}
	
	//Add delete specific record
	public static boolean deleteHealthCardRecord(String id) {
		for(String[] value : records){
			if(id != null && id.equals(value[0])){
				records.remove(value);
				break;
			}
		}
		return true;
	}
	
	//Change a,b,c,d,e to {a, b, c, d, e}
	private static String[] changeRecordToArray(String record){
		return record.split(",");
	}
	
	public synchronized static void saveData(){
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("healthCard.txt"));
			for(String[] value : new ArrayList<String[]>(records)){
				for(int i = 0; i < value.length; i++){
					writer.write(((value[i] != null) ? value[i] : "") + ",");
				}
				writer.write("\r\n");
			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
