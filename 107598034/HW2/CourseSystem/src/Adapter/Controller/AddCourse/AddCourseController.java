package Adapter.Controller.AddCourse;

import java.util.ArrayList;
import java.util.List;

import Adapter.Controller.ClassDataMapper;
import Adapter.Controller.CourseData;
import Adapter.Presenter.AddCoursePresenter;
import Adapter.Repository.InJsonCourseRepository;
import CourseUseCase.CourseRepository;
import CourseUseCase.AddCourseUseCase.AddCourseInput;
import CourseUseCase.AddCourseUseCase.AddCourseOutput;
import CourseUseCase.AddCourseUseCase.AddCourseUseCase;
import CourseUseCase.AddCourseUseCase.AddCourseUseCaseImpl;

public class AddCourseController {

	CourseRepository inJsonRepository;
	
	public Boolean addCourse(Object[] courseData) {
		List<CourseData> courseList = new ArrayList<>();
		ClassDataMapper classDataMapper = new ClassDataMapper();
		courseList = classDataMapper.transfromCourseData(courseData);
		
		inJsonRepository = new InJsonCourseRepository();
		AddCourseUseCase addNewCourseUseCase = new AddCourseUseCaseImpl(inJsonRepository);
		
		AddCourseInput input = (AddCourseInput)addNewCourseUseCase;
		input.setCourseName(courseList.get(0).getCourseName());
		input.setCourseDescription(courseList.get(0).getCourseDescription());
		input.setCourseSuitable(courseList.get(0).getSuitable());
		input.setPrice(courseList.get(0).getPrice());
		input.setPrecautions(courseList.get(0).getPrecautions());
		input.setNote(courseList.get(0).getNote());
	
		AddCourseOutput output =  new AddCoursePresenter();
		
		addNewCourseUseCase.execute(input, output);
		if(!output.getCourseId().isEmpty())
			return true;
		else {
			return false;
		}
	}

}
