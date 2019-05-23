package Adapter.Presenter;

import CourseUseCase.AddCourseUseCase.AddCourseOutput;

public class AddCoursePresenter implements AddCourseOutput {
	
	private String courseId = "";
	@Override
	public String getCourseId() {
		return courseId;
	}
	
	@Override
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	
}
