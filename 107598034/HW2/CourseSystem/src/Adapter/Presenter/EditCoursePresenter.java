package Adapter.Presenter;

import CourseUseCase.EditCourseUseCase.EditCourseOutput;

public class EditCoursePresenter implements EditCourseOutput {
	
	private String courseId;

	@Override
	public String getCourseId() {
		return courseId;
	}

	@Override
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

}
