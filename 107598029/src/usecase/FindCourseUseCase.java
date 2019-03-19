package usecase;

import dao.CourseDaoInterface;
import dao.MyCoursedaoimpl;
import dto.CourseDto;
import io.UseCaseInput;
import io.UseCaseError;
import model.Course;
import io.UseCaseOutput;

import java.util.List;

public class FindCourseUseCase {
    private CourseDaoInterface coursedao = new MyCoursedaoimpl();
    public void find(UseCaseInput input, UseCaseOutput output,UseCaseError error){
        try {
            List<Course> list = coursedao.findcourse(input.getCoursename());

            for(Course course : list){
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
