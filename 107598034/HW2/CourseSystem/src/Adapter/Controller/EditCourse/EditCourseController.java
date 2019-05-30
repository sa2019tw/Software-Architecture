package Adapter.Controller.EditCourse;

import java.util.ArrayList;
import java.util.List;

import Adapter.Controller.ClassDataMapper;
import Adapter.Controller.CourseData;
import Adapter.Presenter.EditCoursePresenter;
import Adapter.Repository.InJsonCourseRepository;
import CourseUseCase.CourseRepository;
import CourseUseCase.EditCourseUseCase.EditCourseInput;
import CourseUseCase.EditCourseUseCase.EditCourseOutput;
import CourseUseCase.EditCourseUseCase.EditCourseUseCase;
import CourseUseCase.EditCourseUseCase.EditCourseUseCaseImpl;

public class EditCourseController {
	
	CourseRepository inJsonRepository;
	
	public void editCourse(Object[] courseData) {
		List<CourseData> courseList = new ArrayList<>();
		ClassDataMapper classDataMapper = new ClassDataMapper();
		courseList = classDataMapper.transfromCourseData(courseData);
		
		inJsonRepository = new InJsonCourseRepository();
		EditCourseUseCase editCourseUseCase = new EditCourseUseCaseImpl(inJsonRepository);
		
		EditCourseInput input = (EditCourseInput)editCourseUseCase;
		EditCourseOutput output =  new EditCoursePresenter();
		
		input.setCourseId(courseList.get(0).getCourseId());
		input.setCourseName(courseList.get(0).getCourseName());
		input.setCourseDescription(courseList.get(0).getCourseDescription());
		input.setCourseSuitable(courseList.get(0).getSuitable());
		input.setPrice(courseList.get(0).getPrice());
		input.setPrecautions(courseList.get(0).getPrecautions());
		input.setNote(courseList.get(0).getNote());
		
		editCourseUseCase.execute(input, output);
	}

}
