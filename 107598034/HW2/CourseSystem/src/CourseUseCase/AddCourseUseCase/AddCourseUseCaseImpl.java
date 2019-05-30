package CourseUseCase.AddCourseUseCase;


import CourseUseCase.CourseRepository;
import Entity.Course;

public class AddCourseUseCaseImpl implements AddCourseUseCase, AddCourseInput {
	private String courseName;
	private String courseDescription;
	private String suitable;
	private int price;
	private String precautions;
	private String note;
	
	CourseRepository courseRepository;
	Course c;
	
	public AddCourseUseCaseImpl(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	@Override
	public void execute(AddCourseInput input, AddCourseOutput output) {
		if(!input.getCourseName().equals("")) {
			c = Course.builder().courseName(input.getCourseName())
					.courseDescription(input.getCourseDescription())
					.suitable(input.getCourseSuitable())
					.price(input.getPrice()).precautions(input.getPrecautions())
					.note(input.getNote())
					.build();
			courseRepository.addNewCourse(c);
			
			output.setCourseId(c.getCourseId());
		}
	}
	
	@Override
	public String getCourseName() {
		// TODO Auto-generated method stub
		return courseName;
	}

	@Override
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Override
	public String getCourseDescription() {
		return courseDescription;
	}

	@Override
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
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
	public int getPrice() {
		return price;
	}

	@Override
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String getPrecautions() {
		return precautions;
	}

	@Override
	public void setPrecautions(String precautions) {
		this.precautions = precautions;
	}

	@Override
	public String getNote() {
		return note;
	}

	@Override
	public void setNote(String note) {
		this.note = note;
	}
	
}
