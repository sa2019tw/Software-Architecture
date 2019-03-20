package entities;

import java.util.Scanner;

public class Courses {
	private String courseName;
	private String courseDescription;
	private String suitable;
	private int price;
	private String precautions;
	private String note;
	
	public Courses(Courses c) {
		this.courseName = c.getCourseName();
		this.courseDescription = c.getCourseDescription();
		this.suitable = c.getSuitable();
		this.price = c.getPrice();
		this.precautions = c.getPrecautions();
		this.note = c.getNote();
	}
	
	public Courses(String courseName) {
		this.courseName = courseName;
	}
	
	public Courses(String courseName, String courseDescription, String suitable, int price, String precautions, String note) {
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.suitable = suitable;
		this.price = price;
		this.precautions = precautions;
		this.note = note;
	}
	
	public Courses(Scanner input) {
		this.courseName = input.next();
		this.courseDescription = input.next();
		this.suitable = input.next();
		this.price = input.nextInt();
		this.precautions = input.next();
		this.note = input.next();
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public String getCourseDescription() {
		return courseDescription;
	}
	
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	
	public String getSuitable() {
		return suitable;
	}
	
	public void setSuitable(String suitable) {
		this.suitable = suitable;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getPrecautions() {
		return precautions;
	}
	
	public void setPrecautions(String precautions) {
		this.precautions = precautions;
	}
	
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
}
