package Adapter.Presenter;

import CourseUseCase.DeleteCourseUseCase.DeleteCourseOutput;

public class DeleteCoursePresenter implements DeleteCourseOutput {
	
	private String courseName = "";

	@Override
	public String getCourseName() {
		return courseName;
	}

	@Override
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}
