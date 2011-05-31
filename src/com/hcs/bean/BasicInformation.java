package com.hcs.bean;

import java.sql.Date;

public class BasicInformation {

	public BasicInformation() {
		super();
	}

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public BasicInformation(String name, String sex, String age, Date birthday,
			String address, String currentAddress, String checkReport) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.birthday = birthday;
		this.address = address;
		this.currentAddress = currentAddress;
		this.checkReport = checkReport;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	@Override
	public String toString() {
		return name;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getCheckReport() {
		return checkReport;
	}

	public void setCheckReport(String checkReport) {
		this.checkReport = checkReport;
	}

	private String name;
	private String sex;
	private String age;
	private Date birthday;
	private String address;
	private String currentAddress;
	private String checkReport;

}
