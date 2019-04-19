package usecase;

import dao.CourseDaoInterface;
import io.UseCaseOutput;
import model.Course;
import io.UseCaseError;

import java.util.List;

public class ReadAllCourseUseCase {
    private CourseDaoInterface coursedao;

    public ReadAllCourseUseCase(CourseDaoInterface coursedao) {
        this.coursedao = coursedao;
    }

    public void ReadAllCourse(List<UseCaseOutput> outputs, UseCaseError error){
        try{
            List<Course> list = coursedao.readallcourse();
            for(Course course : list) {
                UseCaseOutput tmp = new UseCaseOutput(
                        course.getId(),
                        course.getName(),
                        course.getLevel(),
                        course.getPrice(),
                        course.getDescription(),
                        course.getPrecautions(),
                        course.getRemarks());
                outputs.add(tmp);
            }
        } catch (Exception e){
            error.reportError(e.getMessage());
        }
    }
}
