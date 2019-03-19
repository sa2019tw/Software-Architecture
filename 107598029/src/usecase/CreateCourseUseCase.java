package usecase;

import dao.CourseDaoInterface;
import dao.MyCoursedaoimpl;
import model.Course;
import io.UseCaseInput;
import io.UseCaseError;

public class CreateCourseUseCase {
    private CourseDaoInterface coursedao = new MyCoursedaoimpl();

    public void creat(UseCaseInput courseinput, UseCaseError error){
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
            coursedao.creatcourse(course);
        } catch (Exception e){
            e.printStackTrace();
            error.reportError(e.getMessage());
        }
    }
}
