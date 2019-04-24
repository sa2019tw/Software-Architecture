package usecase;

import usecase.io.ReadAllUseCaseIO.ReadAllUseCaseErrorInterface;
import usecase.io.ReadAllUseCaseIO.ReadAllUseCaseOutputInterface;

public interface ReadAllCourseUseCaseInterface {
    public void ReadAllCourse(ReadAllUseCaseOutputInterface outputs, ReadAllUseCaseErrorInterface error);
}
