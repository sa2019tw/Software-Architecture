package usecase;

import dao.CourseDaoInterface;
import io.UseCaseOutput;
import model.Course;
import io.UseCaseInput;
import io.UseCaseError;

public class UpdateCourseUseCase {
    private CourseDaoInterface coursedao;

    public UpdateCourseUseCase(CourseDaoInterface coursedao) {
        this.coursedao = coursedao;
    }

    public void update(UseCaseInput useCaseInput, UseCaseError error){
        Course course = new Course(
                useCaseInput.getId(),
                useCaseInput.getCoursename(),
                useCaseInput.getCourselevel(),
                useCaseInput.getPrice(),
                useCaseInput.getDescription(),
                useCaseInput.getPrecautions(),
                useCaseInput.getRemarks()
        );

        try{
            coursedao.updatecourse(course);
        } catch (Exception e){
//            e.printStackTrace();
            error.reportError(e.getMessage());
        }

    }

    public UseCaseOutput getcourse(UseCaseInput input, UseCaseError error){
        Course course = new Course();
        try{
            course = coursedao.getcourseinfo(input.getId());
        } catch (Exception e){
//            e.printStackTrace();
            error.reportError(e.getMessage());
        }

        return new UseCaseOutput(course.getId(),
                course.getName(),
                course.getLevel(),
                course.getPrice(),
                course.getDescription(),
                course.getPrecautions(),
                course.getRemarks());
    }

}
