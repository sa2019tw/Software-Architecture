package UseCase.DeleteCourseUseCase;

import Controller.InputModel;
import Dao.ICourseDao;
import Dao.MockCourseDao;
import Entity.Course;
import Output.DeleteCourseOutputData;
import Presenter.DeleteCoursePresenter;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeleteCourseUseCaseTest {

    private ICourseDao courseDao = new MockCourseDao();

    @Test
    public void execute() {
        Course course = new Course("test1", "this is a test", "everyone", 10000, "attention", "remark");
        courseDao.addCourse(course);

        InputModel inputModel = new InputModel("test1", "this is a test", "everyone", "10000", "attention", "remark");

        boolean isSuccess = courseDao.deleteCourse(inputModel.getCourseName());

        assertTrue(isSuccess);
    }

    @Test
    public void PresenterTest(){
        Course course = new Course("test1", "this is a test", "everyone", 10000, "attention", "remark");
        courseDao.addCourse(course);

        InputModel inputModel = new InputModel("test1", "this is a test", "everyone", "10000", "attention", "remark");

        boolean isSuccess = courseDao.deleteCourse(inputModel.getCourseName());
        DeleteCourseOutputData deleteCourseOutputData = new DeleteCourseOutputData(isSuccess);

        DeleteCoursePresenter deleteCoursePresenter = new DeleteCoursePresenter();

        deleteCoursePresenter.setOutputData(deleteCourseOutputData);

        deleteCoursePresenter.buildViewModel();
        assertTrue(deleteCoursePresenter.getViewModel().getIsSuccess());
    }

    @Test
    public void DeleteFailTest(){
        Course course = new Course("test1", "this is a test", "everyone", 10000, "attention", "remark");
        courseDao.addCourse(course);
        InputModel inputModel = new InputModel("t", "this is a test", "everyone", "10000", "attention", "remark");

        boolean isSuccess = courseDao.deleteCourse(inputModel.getCourseName());
        DeleteCourseOutputData deleteCourseOutputData = new DeleteCourseOutputData(isSuccess);

        DeleteCoursePresenter deleteCoursePresenter = new DeleteCoursePresenter();

        deleteCoursePresenter.setOutputData(deleteCourseOutputData);

        deleteCoursePresenter.buildViewModel();
        assertFalse(deleteCoursePresenter.getViewModel().getIsSuccess());
    }
}