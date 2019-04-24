package UseCase.AddCourseUseCase;

import Dao.ICourseDao;
import Dao.MockCourseDao;
import Entity.Course;
import Output.AddCourseOutputData;
import Presenter.AddCoursePresenter;
import UseCase.OutputBoundary;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddCourseUseCaseTest {
    private ICourseDao courseDao = new MockCourseDao();

    @Test
    public void execute() {
        Course course = new Course("test1", "this is a test", "everyone", 10000, "attention", "remark");
        boolean isSuccess = courseDao.addCourse(course);
        assertTrue(isSuccess);
    }

    @Test
    public void PresenterTest(){
        Course course = new Course("test1", "this is a test", "everyone", 10000, "attention", "remark");
        boolean isSuccess = courseDao.addCourse(course);

        AddCourseOutputData addCourseOutputData = new AddCourseOutputData(isSuccess);
        AddCoursePresenter addCourseOutput = new AddCoursePresenter();

        addCourseOutput.setOutputData(addCourseOutputData);

        addCourseOutput.buildViewModel();

        assertTrue(addCourseOutput.getViewModel().getIsSuccess());
    }
}