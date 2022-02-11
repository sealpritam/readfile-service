package com.practice.readfile.domain;

public class SampleFileDetail extends BaseRecord{
	
	private String roll;
	private String name;
	private String about;
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	@Override
	public String toString() {
		return "SampleFileDetail [roll=" + roll + ", name=" + name + ", about=" + about + "]";
	}
	
}
