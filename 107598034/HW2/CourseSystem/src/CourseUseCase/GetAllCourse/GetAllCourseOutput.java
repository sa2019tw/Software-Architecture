package CourseUseCase.GetAllCourse;

import java.util.List;

import CourseUseCase.CourseModel;
import CourseUseCase.Output;

public interface GetAllCourseOutput extends Output{

	public Object[][] getAllCourseInJson();

	public void setCourseList(List<CourseModel> classList);
}
