package CourseUseCase;

import Entity.Course;

public class TransferCourseToDTO {
	public  CourseModel transform(Course c) {
		CourseModel courseModelDTO = new CourseModel();
		int price = c.getPrice();
		
		courseModelDTO.setCourseId(c.getCourseId());
		courseModelDTO.setCourseName(c.getCourseName());
		courseModelDTO.setCourseDescription(c.getCourseDescription());
		courseModelDTO.setPrice(Integer.toString(price));
		courseModelDTO.setSuitable(c.getSuitable());
		courseModelDTO.setPrecautions(c.getPrecautions());
		courseModelDTO.setNote(c.getNote());
		
		return courseModelDTO;
		
	}
	
}
