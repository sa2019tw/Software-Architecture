package usecase;

import dao.CourseDaoInterface;
import dao.MyCoursedaoimpl;
import dto.CourseDto;
import io.UseCaseOutput;
import model.Course;
import io.UseCaseError;

import java.util.List;

public class ReadAllCourseUseCase {
    private CourseDaoInterface coursedao = new MyCoursedaoimpl();
    public void listCourse(UseCaseOutput output, UseCaseError error){
        try{
            List<Course> list = coursedao.readallcourse();
            for(Course course : list) {
                CourseDto tmp = new CourseDto(
                        course.getId(),
                        course.getName(),
                        course.getLevel(),
                        course.getPrice(),
                        course.getDescription(),
                        course.getPrecautions(),
                        course.getRemarks()
                );
                output.addCoursesDto(tmp);
            }
        } catch (Exception e){
            e.printStackTrace();
            error.reportError(e.getMessage());
        }
    }
}
