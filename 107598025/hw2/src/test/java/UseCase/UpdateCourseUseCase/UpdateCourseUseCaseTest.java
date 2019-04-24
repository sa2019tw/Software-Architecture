package UseCase.UpdateCourseUseCase;

import Dao.ICourseDao;
import Dao.MockCourseDao;
import Entity.Course;
import Output.UpdateCourseOutputData;
import Presenter.UpdateCoursePresenter;
import org.junit.Test;

import static org.junit.Assert.*;

public class UpdateCourseUseCaseTest {
    private ICourseDao courseDao = new MockCourseDao();

    @Test
    public void execute() {
        Course course = new Course("test1",
                                "this is a test",
                                "everyone",
                                10000,
                                "attention",
                                "remark");
        courseDao.addCourse(course);

        Course course1 = new Course("test1",
                "this is updated",
                "everyone can see",
                100000000,
                "attention",
                "remark");

        boolean isSuccess = courseDao.updateCourse(course1);

        assertTrue(isSuccess);
    }

    @Test
    public void PresenterTest(){
        Course course = new Course("test1",
                "this is a test",
                "everyone",
                10000,
                "attention",
                "remark");
        courseDao.addCourse(course);

        Course course1 = new Course("test1",
                "this is updated",
                "everyone can see",
                100000000,
                "attention",
                "remark");

        boolean isSuccess = courseDao.updateCourse(course1);
        UpdateCourseOutputData updateCourseOutputData = new UpdateCourseOutputData(isSuccess);

        UpdateCoursePresenter updateCoursePresenter = new UpdateCoursePresenter();

        updateCoursePresenter.setOutputData(updateCourseOutputData);
        updateCoursePresenter.buildViewModel();

        assertTrue(updateCoursePresenter.getViewModel().getIsSuccess());

    }
}