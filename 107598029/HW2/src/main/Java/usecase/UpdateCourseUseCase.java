package usecase;

import Dto.CourseDto;
import dao.CourseDaoInterface;
import model.Course;
import usecase.io.UpdateUseCaseIO.UpdateUseCaseErrorInterface;
import usecase.io.UpdateUseCaseIO.UpdateUseCaseInputInterface;
import usecase.io.UpdateUseCaseIO.UpdateUseCaseOutputInterface;


public class UpdateCourseUseCase implements UpdateCourseUseCaseInterface{
    private CourseDaoInterface coursedao;

    public UpdateCourseUseCase(CourseDaoInterface coursedao) {
        this.coursedao = coursedao;
    }

    public void update(UpdateUseCaseInputInterface input, UpdateUseCaseErrorInterface error){
        Course course = new Course(
            input.getId(),
            input.getCourseName(),
            input.getCourseLevel(),
            input.getPrice(),
            input.getDescription(),
            input.getPrecautions(),
            input.getRemarks()
        );

        try{
            coursedao.updatecourse(course);
        } catch (Exception e){
//            e.printStackTrace();
            error.reportError(e.getMessage());
        }

    }

    public void getcourse(UpdateUseCaseInputInterface input, UpdateUseCaseOutputInterface output, UpdateUseCaseErrorInterface error){
        Course course = new Course();
        try{
            course = coursedao.getcourseinfo(input.getId());
        } catch (Exception e){
//            e.printStackTrace();
            error.reportError(e.getMessage());
        }
        output.setCourseDto(new CourseDto(
                course.getId(),
                course.getName(),
                course.getLevel(),
                course.getPrice(),
                course.getDescription(),
                course.getPrecautions(),
                course.getRemarks()));
    }

}
