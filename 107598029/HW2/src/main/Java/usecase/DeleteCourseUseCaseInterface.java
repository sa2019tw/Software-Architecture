package usecase;

import usecase.io.DeleteUseCaseIO.DeleteUseCaseErrorInterface;
import usecase.io.DeleteUseCaseIO.DeleteUseCaseInputInterface;

public interface DeleteCourseUseCaseInterface {
    public void deleteCourse(DeleteUseCaseInputInterface input, DeleteUseCaseErrorInterface error);
}
