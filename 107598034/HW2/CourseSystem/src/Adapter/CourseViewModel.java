package Adapter;

import javax.swing.table.DefaultTableModel;

import Adapter.Presenter.GetAllCoursePresenter;
import CourseManagerSystemUI.CourseManagerSystemFrame;


public class CourseViewModel {
	Object[][] presentOnCourseManagerUIData;
	CourseManagerSystemFrame view;
	GetAllCoursePresenter presenter;
	
	public CourseViewModel(CourseManagerSystemFrame view, GetAllCoursePresenter presenter) {
		this.view = view;
		this.presenter = presenter;
	}

	public Object[][] getAllCourseInJson() {
		return presentOnCourseManagerUIData;
	}

	public void setCourseData(Object[][] _courseData) {
		presentOnCourseManagerUIData = _courseData;
	}
}
