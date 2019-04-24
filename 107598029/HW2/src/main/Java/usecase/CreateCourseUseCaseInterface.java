package usecase;

import usecase.io.CreatUseCaseIO.CreatUseCaseErrorInterface;
import usecase.io.CreatUseCaseIO.CreatUseCaseInputInterface;

public interface CreateCourseUseCaseInterface {
    public void creat(CreatUseCaseInputInterface creatUseCaseInputInterface, CreatUseCaseErrorInterface creatUseCaseErrorInterface);
}
