package usecase;

import Dto.CourseDto;
import dao.CourseDaoInterface;
import usecase.io.CreatUseCaseIO.CreatUseCaseOutput;
import model.Course;
import usecase.io.CreatUseCaseIO.CreatUseCaseError;
import usecase.io.ReadAllUseCaseIO.ReadAllUseCaseErrorInterface;
import usecase.io.ReadAllUseCaseIO.ReadAllUseCaseOutput;
import usecase.io.ReadAllUseCaseIO.ReadAllUseCaseOutputInterface;

import java.util.ArrayList;
import java.util.List;

public class ReadAllCourseUseCase implements ReadAllCourseUseCaseInterface{
    private CourseDaoInterface coursedao;

    public ReadAllCourseUseCase(CourseDaoInterface coursedao) {
        this.coursedao = coursedao;
    }

    public void ReadAllCourse(ReadAllUseCaseOutputInterface outputs, ReadAllUseCaseErrorInterface error){
        List<CourseDto> listDto = new ArrayList<>();
        try{
            List<Course> list = coursedao.readallcourse();
            for(Course course : list) {
                CourseDto courseDto = new CourseDto(
                        course.getId(),
                        course.getName(),
                        course.getLevel(),
                        course.getPrice(),
                        course.getDescription(),
                        course.getPrecautions(),
                        course.getRemarks());
                listDto.add(courseDto);
            }

            outputs.setCourseDto(listDto);
        } catch (Exception e){
            error.reportError(e.getMessage());
        }
    }
}
