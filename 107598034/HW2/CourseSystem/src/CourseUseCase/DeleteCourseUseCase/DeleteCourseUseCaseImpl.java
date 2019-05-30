package CourseUseCase.DeleteCourseUseCase;

import java.util.Map;
import java.util.TreeMap;

import CourseUseCase.CourseRepository;
import Entity.Course;

public class DeleteCourseUseCaseImpl implements DeleteCourseUseCase, DeleteCourseInput {
	
	private String courseId;
	private Map<String, Course> courses = new TreeMap<String, Course>();
	private CourseRepository courseRepository;
	Course c;

	public DeleteCourseUseCaseImpl(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	@Override
	public void execute(DeleteCourseInput input, DeleteCourseOutput output) {
		courses = courseRepository.getAllCourse();
		if(courses.containsKey(input.getCourseId())) {
			System.out.println("test");
			courseRepository.deleteCourse(input.getCourseId());
			courses.remove(input.getCourseId());
		}
	}

	@Override
	public String getCourseId() {
		return courseId;
	}

	@Override
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
}
