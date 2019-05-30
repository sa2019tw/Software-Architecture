package CourseUseCase.DeleteCourseUseCase;

import CourseUseCase.Output;

public interface DeleteCourseOutput extends Output {
	public String getCourseName();
	
	public void setCourseName(String courseName);

}
