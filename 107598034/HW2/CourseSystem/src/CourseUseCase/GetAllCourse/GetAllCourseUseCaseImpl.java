package CourseUseCase.GetAllCourse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import CourseUseCase.CourseModel;
import CourseUseCase.CourseRepository;
import CourseUseCase.TransferCourseToDTO;
import Entity.Course;

public class GetAllCourseUseCaseImpl implements GetAllCourseInput, GetAllCourseUseCase {
	Course c;
	CourseRepository courseRepository;
	TransferCourseToDTO transCourseTODTO = new TransferCourseToDTO();
	private Map<String, Course> courses = new TreeMap<String, Course>();
	
	public GetAllCourseUseCaseImpl(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	@Override
	public void execute(GetAllCourseInput input, GetAllCourseOutput output) {
		List<CourseModel> classList = new ArrayList<>();
		courses = courseRepository.getAllCourse();
		for (String key : courses.keySet()) {
		    c = courses.get(key);
			}
		classList.add(transCourseTODTO.transform(c));
		output.setCourseList(classList);
	}
}
