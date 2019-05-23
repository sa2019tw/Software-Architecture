package CourseUseCase.DeleteCourseUseCase;

import CourseUseCase.Input;

public interface DeleteCourseInput extends Input{
	
	public String getCourseId();
	
	public void setCourseId(String courseId);

}
