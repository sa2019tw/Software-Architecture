package usecase;

import dao.CourseDaoInterface;
import io.UseCaseInput;
import io.UseCaseError;
import model.Course;
import io.UseCaseOutput;

import java.util.List;

public class FindCourseUseCase {
    private CourseDaoInterface coursedao;

    public FindCourseUseCase(CourseDaoInterface coursedao) {
        this.coursedao = coursedao;
    }

    public void find(UseCaseInput input, List<UseCaseOutput> outputs, UseCaseError error){
        try {
            List<Course> list = coursedao.findcourse(input.getCoursename());

            for(Course course : list){
                UseCaseOutput tmp = new UseCaseOutput(
                        course.getId(),
                        course.getName(),
                        course.getLevel(),
                        course.getPrice(),
                        course.getDescription(),
                        course.getPrecautions(),
                        course.getRemarks()
                );
                outputs.add(tmp);
            }
        } catch (Exception e){
            e.printStackTrace();
            error.reportError(e.getMessage());
        }
    }
}
