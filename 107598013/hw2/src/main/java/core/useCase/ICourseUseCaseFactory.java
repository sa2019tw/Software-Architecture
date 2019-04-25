package core.useCase;

import core.boundary.input.AddCourseInputData;
import core.boundary.input.DeleteCourseInputData;
import core.boundary.input.UpdateCourseInputData;
import core.boundary.input.UseCase;
import core.boundary.output.IAddCoursePresenter;
import core.boundary.output.IDeleteCoursePresenter;
import core.boundary.output.IGetAllCoursePresenter;
import core.boundary.output.IUpdateCoursePresenter;

public interface ICourseUseCaseFactory {
    UseCase createAddCourseUseCase(AddCourseInputData inputData, IAddCoursePresenter presenter);

    UseCase createDeleteCourseUseCase(DeleteCourseInputData inputData, IDeleteCoursePresenter presenter);

    UseCase createUpdateCourseUseCase(UpdateCourseInputData inputData, IUpdateCoursePresenter presenter);

    UseCase createGetAllCourseUseCase(IGetAllCoursePresenter presenter);
}
