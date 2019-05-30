package CourseUseCase.EditCourseUseCase;

import java.util.Map;
import java.util.TreeMap;

import CourseUseCase.CourseRepository;
import Entity.Course;

public class EditCourseUseCaseImpl implements EditCourseUseCase, EditCourseInput {
	private String courseId;
	private String courseName;
	private String courseDescription;
	private String suitable;
	private int price;
	private String precautions;
	private String note;
	private Map<String, Course> courses = new TreeMap<String, Course>();
	
	private CourseRepository courseRepository;
	Course c;

	public EditCourseUseCaseImpl(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	@Override
	public void execute(EditCourseInput input, EditCourseOutput output) {
		courses = courseRepository.getAllCourse();
		if(courses.containsKey(input.getCourseId())) {
			c = courses.get(input.getCourseId());
			c.setCourseName(input.getCourseName());
			c.setCourseDescription(input.getCourseDescription());
			c.setSuitable(input.getCourseSuitable());
			c.setPrice(input.getPrice());
			c.setPrecautions(input.getPrecautions());
			c.setNote(input.getNote());
			output.setCourseId(c.getCourseId());
			courseRepository.editCourse(c);
		}
	}
	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public String getSuitable() {
		return suitable;
	}

	public void setSuitable(String suitable) {
		this.suitable = suitable;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPrecautions() {
		return precautions;
	}

	public void setPrecautions(String precautions) {
		this.precautions = precautions;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public CourseRepository getCourseRepository() {
		return courseRepository;
	}

	public void setCourseRepository(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	@Override
	public String getCourseSuitable() {
		return suitable;
	}

	@Override
	public void setCourseSuitable(String suitable) {
		this.suitable = suitable;
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
