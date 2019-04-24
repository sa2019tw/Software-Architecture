package usecase;

import usecase.io.UpdateUseCaseIO.UpdateUseCaseErrorInterface;
import usecase.io.UpdateUseCaseIO.UpdateUseCaseInputInterface;
import usecase.io.UpdateUseCaseIO.UpdateUseCaseOutputInterface;

public interface UpdateCourseUseCaseInterface {
    public void update(UpdateUseCaseInputInterface input, UpdateUseCaseErrorInterface error);
    public void getcourse(UpdateUseCaseInputInterface input, UpdateUseCaseOutputInterface output, UpdateUseCaseErrorInterface error);
}
