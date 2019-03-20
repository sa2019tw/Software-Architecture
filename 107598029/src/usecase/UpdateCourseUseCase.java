package usecase;

import dao.CourseDaoInterface;
import dao.MyCoursedaoimpl;
import dto.CourseDto;
import io.UseCaseOutput;
import model.Course;
import io.UseCaseInput;
import io.UseCaseError;

public class UpdateCourseUseCase {
    private CourseDaoInterface coursedao = new MyCoursedaoimpl();
    public void update(UseCaseInput courseinput, UseCaseError output){
        Course course = new Course(
                courseinput.getId(),
                courseinput.getCoursename(),
                courseinput.getCourselevel(),
                courseinput.getPrice(),
                courseinput.getDescription(),
                courseinput.getPrecautions(),
                courseinput.getRemarks()
        );

        try{
            coursedao.updatecourse(course);
        } catch (Exception e){
            e.printStackTrace();
            output.reportError(e.getMessage());
        }

    }

    public void getcourse(UseCaseInput input, UseCaseOutput output, UseCaseError error){
        Course course = new Course();
        try{
            course = coursedao.getcourseinfo(input.getId());
        } catch (Exception e){
            e.printStackTrace();
            error.reportError(e.getMessage());
        }

        CourseDto tmp = new CourseDto(
                course.getId(),
                course.getName(),
                course.getLevel(),
                course.getPrice(),
                course.getDescription(),
                course.getPrecautions(),
                course.getRemarks()
        );

        try{
            output.setCourseInfoDto(tmp);
        } catch (Exception e){
            e.printStackTrace();
            error.reportError(e.getMessage());
        }
    }

}
