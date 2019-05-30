package Adapter.Controller.getAllCourse;

import Adapter.Presenter.GetAllCoursePresenter;
import Adapter.Repository.InJsonCourseRepository;
import CourseUseCase.CourseRepository;
import CourseUseCase.GetAllCourse.GetAllCourseInput;
import CourseUseCase.GetAllCourse.GetAllCourseOutput;
import CourseUseCase.GetAllCourse.GetAllCourseUseCase;
import CourseUseCase.GetAllCourse.GetAllCourseUseCaseImpl;

public class GetAllCourseController {
	CourseRepository inJsonRepository;
	
	public void getAllCourse() {
		inJsonRepository = new InJsonCourseRepository();
		GetAllCourseUseCase getAllCourseUseCase = new GetAllCourseUseCaseImpl(inJsonRepository);
		
		GetAllCourseInput input = (GetAllCourseInput)getAllCourseUseCase;
		GetAllCourseOutput output =  new GetAllCoursePresenter();
		
		getAllCourseUseCase.execute(input, output);
	}

}
