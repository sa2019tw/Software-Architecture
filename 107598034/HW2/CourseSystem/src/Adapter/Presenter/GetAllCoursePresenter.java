package Adapter.Presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import Adapter.Controller.ClassDataMapper;
import Adapter.Repository.InJsonCourseRepository;
import CourseUseCase.CourseModel;
import CourseUseCase.CourseRepository;
import CourseUseCase.GetAllCourse.GetAllCourseOutput;
import Entity.Course;

public class GetAllCoursePresenter implements GetAllCourseOutput {
	
	CourseRepository courseRespository = new InJsonCourseRepository();
	Map<String, Course> courseMap = new TreeMap<String, Course>();
	List<CourseModel> classList = new ArrayList<>();
	ClassDataMapper classDataMapper = new ClassDataMapper();

	@Override
	public Object[][] getAllCourseInJson() {
		Object[][] presentOnCourseManagerUIData;
		courseMap = courseRespository.getAllCourse();
		presentOnCourseManagerUIData = classDataMapper.showCourseTable(courseMap);
		return presentOnCourseManagerUIData;
	}

	@Override
	public void setCourseList(List<CourseModel> classList) {
		this.classList = classList;
	}

}
