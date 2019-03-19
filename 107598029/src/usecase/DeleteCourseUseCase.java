package usecase;

import dao.CourseDaoInterface;
import dao.MyCoursedaoimpl;
import io.UseCaseInput;
import io.UseCaseError;

public class DeleteCourseUseCase {
    private CourseDaoInterface coursedao = new MyCoursedaoimpl();

    public void deleteCourse(UseCaseInput input, UseCaseError error){
        try{
            coursedao.deletecourse(input.getId());
        } catch (Exception e){
            e.printStackTrace();
            error.reportError(e.getMessage());
        }
    }
}
