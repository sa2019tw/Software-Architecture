package usecase;

import dao.CourseDaoInterface;
import model.Course;
import usecase.io.CreatUseCaseIO.CreatUseCaseErrorInterface;
import usecase.io.CreatUseCaseIO.CreatUseCaseInputInterface;

public class CreateCourseUseCase implements CreateCourseUseCaseInterface{
    private CourseDaoInterface coursedao;

    public CreateCourseUseCase(CourseDaoInterface coursedao) {
        this.coursedao = coursedao;
    }

    public void creat(CreatUseCaseInputInterface input, CreatUseCaseErrorInterface error){
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
            coursedao.creatcourse(course);
        } catch (Exception e){
            error.reportError(e.getMessage());
        }
    }
}
