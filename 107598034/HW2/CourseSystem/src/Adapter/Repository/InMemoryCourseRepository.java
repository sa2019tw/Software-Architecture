package Adapter.Repository;

import java.util.Map;
import java.util.TreeMap;

import CourseUseCase.CourseRepository;
import Entity.Course;

public class InMemoryCourseRepository implements CourseRepository{
	Map<String, Course> courseMap = new TreeMap<String, Course>();
	
	@Override
	public void addNewCourse(Course course) {
		courseMap.put(course.getCourseId(), course);
	}
	
	@Override
	public void editCourse(Course course) {
		if(courseMap.containsKey(course.getCourseId())) {
			courseMap.put(course.getCourseId(), course);
		}else return;
	}

	@Override
	public void deleteCourse(String courseId) {
		if (courseMap.isEmpty())
			return;
		if (courseMap.containsKey(courseId)) {
			courseMap.remove(courseId);
		}
	}

	@Override
	public Map<String, Course> getAllCourse() {
		return courseMap;
	}
}
