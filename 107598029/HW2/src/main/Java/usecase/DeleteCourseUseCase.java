package usecase;

import dao.CourseDaoInterface;
import io.UseCaseInput;
import io.UseCaseError;

public class DeleteCourseUseCase {
    private CourseDaoInterface coursedao;

    public DeleteCourseUseCase(CourseDaoInterface coursedao) {
        this.coursedao = coursedao;
    }

    public void deleteCourse(UseCaseInput input, UseCaseError error){
        try{
            coursedao.deletecourse(input.getId());
        } catch (Exception e){
//            e.printStackTrace();
            error.reportError(e.getMessage());
        }
    }
}
