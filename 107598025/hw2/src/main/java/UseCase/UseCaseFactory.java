package UseCase;

import Dao.ICourseDao;
import UseCase.AddCourseUseCase.AddCourseUseCase;
import UseCase.DeleteCourseUseCase.DeleteCourseUseCase;
import UseCase.RetrieveAllCourseUseCase.RetrieveAllCourseUseCase;
import UseCase.RetrieveOneCourseUseCase.RetrieveOneCourseUseCase;
import UseCase.UpdateCourseUseCase.UpdateCourseUseCase;

public class UseCaseFactory {
    private ICourseDao courseDao;

    public UseCaseFactory(ICourseDao courseDao){
        this.courseDao = courseDao;
    }

    public UseCase createAddCourseUseCase(){
        return new AddCourseUseCase(courseDao);
    }

    public UseCase createRetrieveAllCourseUseCase(){
        return new RetrieveAllCourseUseCase(courseDao);
    }

    public UseCase createRetrieveOneCourseUseCase(){
        return new RetrieveOneCourseUseCase(courseDao);
    }

    public UseCase createUpdateCourseUseCase(){
        return new UpdateCourseUseCase(courseDao);
    }

    public UseCase createDeleteOneCourseUseCase(){
        return new DeleteCourseUseCase(courseDao);
    }

}
