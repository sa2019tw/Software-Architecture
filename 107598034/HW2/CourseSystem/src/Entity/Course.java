package Entity;

import java.util.UUID;

public class Course {
	private String courseId;
	private String courseName;
	private String courseDescription;
	private String suitable;
	private int price;
	private String precautions;
	private String note;
	
	public Course() {
		
	}
	
	public Course(String courseName) {
		this.courseName = courseName;
	}
	
	public Course(String courseId,
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
	
	public static CourseBuilder builder() {
		return new CourseBuilder();
	}

	public static class CourseBuilder {
		private String courseName;
		private String courseDescription;
		private String suitable;
		private int price;
		private String precautions;
		private String note;

		CourseBuilder() {
		}
		
		

		public CourseBuilder courseName(final String courseName) {
			this.courseName = courseName;
			return this;
		}

		public CourseBuilder courseDescription(final String courseDescription) {
			this.courseDescription = courseDescription;
			return this;
		}
		
		public CourseBuilder suitable(final String suitable) {
			this.suitable = suitable;
			return this;
		}

		public CourseBuilder password(final String suitable) {
			this.suitable = suitable;
			return this;
		}

		public CourseBuilder price(final int price) {
			this.price = price;
			return this;
		}

		public CourseBuilder precautions(final String precautions) {
			this.precautions = precautions;
			return this;
		}
		
		public CourseBuilder note(final String note) {
			this.note = note;
			return this;
		}

		public Course build() {
			String courseId = UUID.randomUUID().toString();
			return new Course(courseId, courseName, courseDescription, suitable, price, precautions, note);
		}
	}
	
	public String getCourseId() {
		return courseId;
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
