package usecase;

import dao.CourseDaoInterface;
import usecase.io.DeleteUseCaseIO.DeleteUseCaseErrorInterface;
import usecase.io.DeleteUseCaseIO.DeleteUseCaseInputInterface;

public class DeleteCourseUseCase implements DeleteCourseUseCaseInterface{
    private CourseDaoInterface coursedao;

    public DeleteCourseUseCase(CourseDaoInterface coursedao) {
        this.coursedao = coursedao;
    }

    public void deleteCourse(DeleteUseCaseInputInterface input, DeleteUseCaseErrorInterface error){
        try{
            coursedao.deletecourse(input.getId());
        } catch (Exception e){
//            e.printStackTrace();
            error.reportError(e.getMessage());
        }
    }
}
