package Adapter.Controller;

public class CourseData {
	private String courseId;
	private String courseName;
	private String courseDescription;
	private String suitable;
	private int price;
	private String precautions;
	private String note;
	
	public CourseData(String courseId,
			  String courseName, 
			  String courseDescription, 
			  String suitable, 
			  int price, 
			  String precautions, 
			  String note) {
	this.courseId = courseId;
	this.courseName = courseName;
	this.courseDescription = courseDescription;
	this.suitable = suitable;
	this.price = price;
	this.precautions = precautions;
	this.note = note;
	}
	
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
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
