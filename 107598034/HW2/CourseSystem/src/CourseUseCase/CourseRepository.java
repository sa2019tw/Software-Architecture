package CourseUseCase;

import java.util.Map;

import Entity.Course;

public interface CourseRepository {
	void addNewCourse(Course course);
	
	void deleteCourse(String courseId);
	
	void editCourse(Course course);
	
	Map<String, Course> getAllCourse();
}
