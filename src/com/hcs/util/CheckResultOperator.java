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

public class CheckResultOperator {
	
	public static void main(String[] args){
		List<String[]> records = new ArrayList<String[]>(CheckResultOperator.getCheckResultRecords());
		for(String[] value : records){
			for(int j = 0; j < value.length; j++){
				System.out.print(value[j]);
				System.out.print(", ");
			}
			System.out.println();
		}
		CheckResultOperator.deleteCheckResultRecord("23123168");
		CheckResultOperator.saveData();
	}
	
	private static List<String[]> records = null;
	
	static {
		records = new ArrayList<String[]>();
		initRecord();
	}
	
	
	
	//Get all records
	public static List<String[]> getCheckResultRecords(){
		return records;
	}
	
	
	private static void initRecord(){
		try {
			File file = new File("checkResult.txt");
			if(!file.exists()){
				file.createNewFile();
			}
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String value = reader.readLine();
			while(value != null){
				records.add(checkResultToArray(value));
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
	public static boolean addCheckResultRecord(String[] value){
		records.add(value);
		return true;
	}
	
	//Add delete specific record
	public static boolean deleteCheckResultRecord(String id) {
		for(String[] value : records){
			if(id != null && id.equals(value[0])){
				records.remove(value);
				break;
			}
		}
		return true;
	}
	
	//Update current record
	public static void updateCheckResultRecord(String id, String[] records){
		String[] orign = getCheckResult(id);
		if(orign != null && orign.length == records.length){
			orign = records;
		} else {
			addCheckResultRecord(records);
		}
	}
	
	//Return the c
	public static String[] getCheckResult(String id){
		if(null == id || "".equals(id)){
			return new String[]{};
		}
		for(String[] item : records){
			if(id.equals(item[0])){
				return item;
			}
		}
		return new String[]{};
	}
	
	//Change a,b,c,d,e to {a, b, c, d, e}
	private static String[] checkResultToArray(String record){
		String[] result = record.split(",");
		for(int i = 0; i < result.length; i++){
			result[i] = StringUtil.backGamaAndEnter(result[i]);
		}
		return result;
	}
	
	public synchronized static void saveData(){
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("checkResult.txt"));
			for(String[] value : new ArrayList<String[]>(records)){
				for(int i = 0; i < value.length; i++){
					writer.write(((StringUtil.filterGamaAndEnter(value[i]) != null) ? StringUtil.filterGamaAndEnter(value[i]) : "") + ",");
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
