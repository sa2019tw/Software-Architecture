package Adapter.Controller.DeleteCourse;

import java.util.ArrayList;
import java.util.List;

import Adapter.Controller.ClassDataMapper;
import Adapter.Controller.CourseData;
import Adapter.Presenter.DeleteCoursePresenter;
import Adapter.Repository.InJsonCourseRepository;
import CourseUseCase.CourseRepository;
import CourseUseCase.DeleteCourseUseCase.DeleteCourseInput;
import CourseUseCase.DeleteCourseUseCase.DeleteCourseOutput;
import CourseUseCase.DeleteCourseUseCase.DeleteCourseUseCase;
import CourseUseCase.DeleteCourseUseCase.DeleteCourseUseCaseImpl;

public class DeleteCourseController {
	CourseRepository inJsonRepository;
	
	public void deleteCourse(Object[] courseData) {
		List<CourseData> courseList = new ArrayList<>();
		ClassDataMapper classDataMapper = new ClassDataMapper();
		courseList = classDataMapper.transfromCourseData(courseData);
		
		inJsonRepository = new InJsonCourseRepository();
		DeleteCourseUseCase deleteCourseUseCase = new DeleteCourseUseCaseImpl(inJsonRepository);
		
		DeleteCourseInput input = (DeleteCourseInput)deleteCourseUseCase;
		input.setCourseId(courseList.get(0).getCourseId());
	
		DeleteCourseOutput output =  new DeleteCoursePresenter();
		
		deleteCourseUseCase.execute(input, output);
		
	}
}
