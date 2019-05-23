package CourseUseCase.AddCourseUseCase;

import CourseUseCase.Input;

public interface AddCourseInput extends Input {
	
	public String getCourseName();
	
	public void setCourseName(String courseName);
	
	public String getCourseDescription();
	
	public void setCourseDescription(String courseDescription);
	
	public String getCourseSuitable();
	
	public void setCourseSuitable(String suitable);
	
	public int getPrice();
	
	public void setPrice(int price);
	
	public String getPrecautions();
	
	public void setPrecautions(String precautions);
	
	public String getNote();
	
	public void setNote(String note);
}
